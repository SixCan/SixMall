var globals = require('../globals')
var utils = require('../mall_utils')
var postUtils = require('../post')
var queryString = require('querystring')

// Renran4, 594szw
var userDatabase = {
      'renran': 'cfe3d11e25d864f9c5370ac839062c83e014ae261b5d7f8029348c448939780b5f3136f5974bf4d9219d6e742069ddf7860ecc1ca6b9e27d7b5ca3d259b4c5fc',
      'szw': '54c57e3b29df8a913897885eb7706a70c41776ba20bfddadab21bf728b2be84966344b92f47fed2ceac37df8a3be9dd2d856cdf064a3df6beb984c8a83ecb349'
}

function onRequest(req, resp) {
      postUtils.getPost(req, function (postData) {
            var parsedArgs = queryString.parse(postData)
            var userName = parsedArgs['name']
            var password = parsedArgs['pwd']

            var pwdInDb = userDatabase[userName]
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