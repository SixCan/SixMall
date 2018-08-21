function getResponse(resp, content) {
      resp.writeHead(200, {'Content-Type' : 'application/json'})
      var json = '{"code":200,"msg":"success","payload":{' + content + '}}'
      resp.end(json)
}


function sendError(response, errCode, errMsg) {
      response.writeHead(404, { 'Content-Type': 'application/json' });
      response.write('{"code": ' + errCode + ', "msg":"' + errMsg + '", "payload":{}}');
      response.end();
}


exports.succResp = getResponse
exports.errResp = sendError