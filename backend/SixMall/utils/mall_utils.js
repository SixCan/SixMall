function getResponse(resp, content) {
      resp.writeHead(200, { 'Content-Type': 'application/json' })
      var json = '{"code":200,"msg":"success","payload":{' + content + '}}'
      resp.end(json)
}


function sendError(response, errCode, errMsg) {
      response.writeHead(404, { 'Content-Type': 'application/json' });
      response.write('{"code": ' + errCode + ', "msg":"' + errMsg + '", "payload":{}}');
      response.end();
}

function generateSessionId() {
      var chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_"
      var SESSION_LENGTH = 128
      var id = ""
      var len = chars.length
      for (var i = 0; i < SESSION_LENGTH; i++) {
            id += chars[Math.floor(Math.random() * len)]
      }
      return id
}


exports.succResp = getResponse
exports.errResp = sendError
exports.generateSessionId = generateSessionId