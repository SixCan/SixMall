
function getPostData(req){
      var result = ''
      req.setEncoding('utf-8')
      console.log('01')
      req.on('data', function(chunk){
            console.log('02 '+chunk)
            result += chunk
      })
      req.on('end', function(){
            console.log('03')
            return result  //TODO 在callback中return, 还不知道行不行, 试一下
      })
      console.log('04')
}

exports.getPost = getPostData