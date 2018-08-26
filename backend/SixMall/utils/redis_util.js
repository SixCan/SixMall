// terminal :   > redis-cli 

const Q = require('bluebird')
var rediz = require('redis')

// 在同步API后加"Async", 即为新的异步API
Q.promisifyAll(rediz.RedisClient.prototype)
Q.promisifyAll(rediz.Multi.prototype)

var redis = rediz.createClient()
redis.on('error', function (err) {
      console.log('Error = ' + err)
})

redis.select(2) //2号数据库就是SixMall用的

module.exports = redis