var utils = require('../utils/mall_utils')
var postUtils = require('../post')
var queryString = require('querystring')

const mysql = require('../utils/mysql_util')
const redis = require('../utils/redis_util')

var sessionId = ""
const SEVEN_DAY = 604800

function onRequest(req, resp) {
      postUtils.getPost(req, function (postData) {
            var parsedArgs = queryString.parse(postData)
            var userName = parsedArgs['name']
            var password = parsedArgs['pwd']

            var querySql = "SELECT uid, name, pwd FROM users where name = ?"
            var queryParams = [userName]
            mysql.queryAsync(querySql, queryParams)
                  .then((rows) => {
                        console.log("\n")
                        console.log(rows)
                        var pwdInDb = rows[0].pwd
                        if (pwdInDb != password) {
                              utils.errResp(resp, 9001, "Wrong username and password combination")
                        } else {
                              sessionId = utils.generateSessionId()

                              var modifySql = "UPDATE users SET session = ? WHERE name = ?"
                              var modifyParams = [sessionId, userName]
                              return mysql.query(modifySql, modifyParams)
                        }
                  })
                  .then((result) => {
                        console.log("\n" + sessionId)

                        var sessionKey = `${userName}Session`
                        var expireTime = SEVEN_DAY  // TODO 测试可能要改短一些
                        redis.setAsync(sessionKey, sessionId)
                              .then((result) => {
                                    redis.expireAsync(sessionKey, expireTime)
                              })

                        utils.succResp(resp, '"sessionId": "' + sessionId + '"')
                  })
      })

}
exports.login = onRequest