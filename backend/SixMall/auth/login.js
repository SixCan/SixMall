var utils = require('../utils/mall_utils')
var postUtils = require('../post')
var queryString = require('querystring')
var globals = require('../globals')  //显示没用. 其实有用. 因为要初始化好globals中的session对象. 不可以删除此句

// Renran4, 594szw
var userDatabase = {
      'renran': 'ca4b2fbde5891f461a1c30c76dd18d71692ebe11d7e470acf1cd7e487267d3ed33bd3e56cb7d84e51ca44c263fcec125a04123d6850b5bc0b2ce682a8cb79069',
      'szw': 'd9f4e9e7235040a223d972a53ee78289e88e75ff4ac3d7101fdc57c0de099aa7b490331aefb7ef2c5b06d7c3ef5eca664fb529d5ed0f09d7eb1d6220a4116a47'
}

function onRequest(req, resp) {
      postUtils.getPost(req, function (postData) {
            var parsedArgs = queryString.parse(postData)
            var userName = parsedArgs['name']
            var password = parsedArgs['pwd']

            var pwdInDb = userDatabase[userName] //TODO 从db中取来
            if (pwdInDb != password) {
                  utils.errResp(resp, 9001, "Wrong username and password combination")
            } else {
                  var sessionId = utils.generateSessionId()
                  sessions[sessionId] = userName
                  utils.succResp(resp, '"sessionId": "' + sessionId + '"')
            }

      })
      //TODO 后续考虑使用数据库

}
exports.login = onRequest