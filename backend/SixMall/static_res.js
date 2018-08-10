var path = require('path')
var fs = require('fs')

// req : url = /images/splash/splash7.jpg
function onRequest(reqUrl, resp) {
      var staticDir = path.resolve(__dirname, "public")
      var imgPath = staticDir + reqUrl
      console.log("szw image = " + imgPath)

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

exports.requestStaticRes = onRequest