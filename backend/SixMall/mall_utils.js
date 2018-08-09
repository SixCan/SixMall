function getResponse(content) {
      var json = '{"code":100,"msg":"success","payload":{' + content + '}}'
      return json
}


exports.succResp = getResponse