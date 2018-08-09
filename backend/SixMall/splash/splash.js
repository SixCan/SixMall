var path = require('path')
var fs = require('fs')

// TODO 后续splash不直接返回图片, 改为返回图片url, 让client端自己去加载图片

function onRequest(resp) {
      console.log("splash API : get request")

      var randomNum = Math.floor(1 + Math.random() * 7)  //序号1到7
      var rootPath = path.resolve(__dirname, "..","public/images/splash") //splash目录的父目录才有public文件
      var imgPath = path.join(rootPath, "splash" + randomNum + ".jpg")

      fs.exists(imgPath, function (isExist) {
            if (!isExist) {
                  sendError(resp, 200, "file not found : " + imgPath)
                  return
            }
            
            var stat = fs.statSync(imgPath)
            resp.writeHead(200, {
                  "Content-Type": "image/jpg",
                  "Content-Length": stat.size
            })

            var readStream = fs.createReadStream(imgPath)
            readStream.pipe(resp)
      })

}

function sendError(response, errCode, errMsg) {
      response.writeHead(404, { 'Content-Type': 'application/json' });
      response.write('{"code": ' + errCode + ', "msg":"' + errMsg + '", "payload":{}}');
      response.end();
}

exports.splash = onRequest


