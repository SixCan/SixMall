var fs = require('fs')

// TODO 后续splash不直接返回图片, 改为返回图片url, 让client端自己去加载图片

function onRequest(resp){
      console.log("splash API : get request")

      var randomNum = Math.floor( 1+ Math.random() * 7)
      var path = "../public/splash"+randomNum+".jpg"

      fs.exists(path, function(isExist){
            if(!isExist){
                  sendError(resp, 200, "file ["+path+"] not found")
                  return
            } 
            fs.readFile(path, function(err, data){
                  if(err){
                        sendError(resp, 210, "read file error : "+path)
                        return
                  }
                  sendFile(resp, data)
            })
      })

}

function sendError(response, errCode, errMsg) {
      response.writeHead(404, { 'Content-Type': 'application/json' });
      response.write('{"code": '+errCode+', "msg":"'+errMsg+'", "payload":{}}');
      response.end();
}


function sendFile(response, fileContents) {
      response.writeHead(200, { 'Content-Type': 'text/plain' });
      response.end(fileContents);
}


exports.splash = onRequest


