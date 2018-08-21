
function getPostData(req, callback){
      var result = ''
      req.setEncoding('utf-8')
      req.on('data', function(chunk){
            result += chunk
      })
      req.on('end', function(){
            callback(result) //TODO 在callback中return, 还不知道行不行, 试一下
      })
}

exports.getPost = getPostData