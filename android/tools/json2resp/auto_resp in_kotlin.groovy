// 使用指南，要预告建立好${path}目录和“${path}/item目录”
//========== !!! src.json里不能带中文 !!! =============
//========== !!! src.json里不能带中文 !!! =============
//========== !!! src.json里不能带中文 !!! =============
//========== !!! src.json里不能带中文 !!! =============

 
import groovy.json.JsonSlurper

//TODO put this as a command argument
basicFileName = 'Home'

path = "./output/" //要以 "/" 结尾
responseName = "${basicFileName}Response"
responseFileName = "${path}${responseName}.kt"
lineSeparator = System.getProperty("line.separator");

def directory = new File(path)
directory.mkdirs()
def reader = new FileReader('src.json')
ajson = new JsonSlurper().parse(reader)


println '======================================='
sb = new StringBuilder()
sb = parseJson2ResponseFileContent()
write2File(responseFileName, sb)
println '======================================='



def write2File(fileFullName, content){
    println("szw file = $fileFullName")
    def file = new File(fileFullName)
    file.withWriter{ Writer writer ->
        writer.append(content)
    }
}

//key参数是防备有JsonArray<自定义类>的， 这样可以给子Item命名
def getTypeFromWholePath(key, value){
    if(key.endsWith('id') || key.endsWith('Id')){
        return 'Long'
    }
    valueType = value.getClass()
    switch(valueType){
        case 'class java.lang.String':
            return 'String';
        case 'class java.lang.Boolean':
            return 'Boolean';
        case 'class java.lang.Integer':
            return 'Int';
        case 'class java.util.ArrayList':
            listSubClass = value[0].getClass()
            //println "getType() : ArrayList : listSubClass = $listSubClass"
            listSubType = getTypeFromWholePath("${key}Item", value[0])
            return "ArrayList<$listSubType>"
        case 'class groovy.json.internal.LazyMap':
            //println "$key -- ${key.getClass()}"
            objectType = key.capitalize();
            return objectType;
    }
}


def parseJson2ResponseFileContent(){
    sb = new StringBuilder()
    sb<<"package your.company.data.entity"<<lineSeparator
    sb<<lineSeparator  //这一块不用太在意, 粘贴时AndroidStudio会帮你修正package的

    sb<<"import java.util.ArrayList;"<<lineSeparator
    sb<<"import org.json.JSONArray;"<<lineSeparator
    sb<<"import org.json.JSONObject;"<<lineSeparator
    sb<<lineSeparator

    sb<<"class ${responseName} (json : JSONObject) {"<<lineSeparator
    ajson.each{key, value ->
        def type = getTypeFromWholePath(key, value)
        //TODO kotlin中lateinit不能用于基本类型, 这里怕是要改
        sb<<"\tlateinit var $key :  $type "<<lineSeparator
    }
    sb<<lineSeparator

    sb<<"\tconstruct(jsonStr : String) : this(JSONObject(jsonStr)) {}"
    sb<<lineSeparator

    sb<<"\tinit {"<<lineSeparator
    ajson.each{key, value ->
        def type = getTypeFromWholePath(key, value)

        if (type.startsWith("ArrayList")){
            def subtype = ""
            def pattern = ~/ArrayList<(.*)>/
            type.find(pattern){
                subtype = it[1]
            }

            sb<<lineSeparator
            sb<<"\t\tval array = json.optJSONArray(\"$key\")"<<lineSeparator


            //println "subtype = $subtype"
            if(subtype.equals("Long") || subtype.equals("Int")
                    || subtype.equals("String") || subtype.equals("Boolean")){
                sb<<"\t\t$key = new $type();"<<lineSeparator
                sb<<"\t\tfor(i in 0 until array.length){"<<lineSeparator
                sb<<"\t\t\tval asub = array.opt(i) as $subtype"<<lineSeparator
                sb<<"\t\t\t${key}.add(asub)"<<lineSeparator
                sb<<"\t\t}"<<lineSeparator

            } else {
                writeItemData2File(subtype, value[0])

                sb<<"\t\t${key} = create${subtype}(array)"<<lineSeparator
                sb<<"\t\t"<<lineSeparator

            }

        }


        else if(type.equals("Long") || type.equals("Int")
                || type.equals("String") || type.equals("Boolean")){
            type = type.capitalize()
            sb<<"\t\t$key = json.opt${type}(\"$key\")"<<lineSeparator
        }


        else {
            //create the Item's JavaBean
            writeItemData2File(key,value)

            //add lines to File
            sb<<lineSeparator
            sb<<"\t\tval sub = json.optJSONObject(\"${key}\")"<<lineSeparator
            sb<<"\t\t$key = $type(sub)"<<lineSeparator
            sb<<lineSeparator
        }
    }

    sb<<"\t}"<<lineSeparator
    sb<<lineSeparator
    sb<<"}"<<lineSeparator
}




def writeItemData2File(fkey, fvalue){
    def sb2 = new StringBuilder()
    sb2<<"package your.company.data.entity"<<lineSeparator
    sb2<<lineSeparator

    sb2<<"import java.util.ArrayList"<<lineSeparator
    sb2<<"import org.json.JSONArray"<<lineSeparator
    sb2<<"import org.json.JSONObject"<<lineSeparator
    sb2<<lineSeparator

    sb2<<"class ${fkey.capitalize()}(json : JSONObject?) {"<<lineSeparator
    fvalue.each{key, value ->
        def type = getTypeFromWholePath(key, value)
        //TODO kotlin中lateinit不能用于基本类型, 这里怕是要改
        sb2<<"\tlateinit var $key : $type"<<lineSeparator
    }
    sb2<<lineSeparator

    sb2<<"\tpublic ${fkey.capitalize()} {"<<lineSeparator
    sb2<<"\t\tif(json != null){"<<lineSeparator
    fvalue.each{key, value ->
        def type = getTypeFromWholePath(key, value)
        if(type.startsWith("ArrayList")) {
            def subtype = ""
            def pattern = ~/ArrayList<(.*)>/
            type.find(pattern){
                subtype = it[1]
            }

            sb2<<"\t\t\tJSONArray ary = json.optJSONArray(\"$key\");"<<lineSeparator
            sb2<<"\t\t\tint size = ary.length();"<<lineSeparator
            sb2<<"\t\t\t$key = new ArrayList<>();"<<lineSeparator
            sb2<<"\t\t\tfor (int i = 0 ; i < size ; i++) {"<<lineSeparator
            sb2<<"\t\t\t\t${key}.add(ary.opt${subtype.capitalize()}(i));"<<lineSeparator
            sb2<<"\t\t\t\t}"<<lineSeparator

        } else {
            sb2<<"\t\t\t${key} = json.opt${type.capitalize()}(\"${key}\");"<<lineSeparator
        }
    }
    sb2<<"\t\t}"<<lineSeparator
    sb2<<"\t}"<<lineSeparator
    sb2<<lineSeparator

    sb2<<"\tpublic static ArrayList<${fkey.capitalize()}> createWithJsonArray(JSONArray array) {"<<lineSeparator
    sb2<<"\t\tif(array != null){"<<lineSeparator
    sb2<<"\t\t\tint len = array.length();"<<lineSeparator
    sb2<<"\t\t\tArrayList<${fkey.capitalize()}> list = new ArrayList<${fkey.capitalize()}>();"<<lineSeparator
    sb2<<"\t\t\tfor(int i = 0 ; i < len ; i++){"<<lineSeparator
    sb2<<"\t\t\t\tJSONObject obj = array.optJSONObject(i);"<<lineSeparator
    sb2<<"\t\t\t\t${fkey.capitalize()} oneItem = new ${fkey.capitalize()}(obj);"<<lineSeparator
    sb2<<"\t\t\t\tlist.add(oneItem);"<<lineSeparator
    sb2<<"\t\t\t}"<<lineSeparator
    sb2<<"\t\t\treturn list;"<<lineSeparator
    sb2<<"\t\t}"<<lineSeparator
    sb2<<"\t\treturn null;"<<lineSeparator
    sb2<<"\t}"<<lineSeparator
    sb2<<lineSeparator


    sb2<<"}"

    write2File("${path}${fkey.capitalize()}.java", sb2)
}