const redis = require('./utils/redis_util')

redis. select(1)

redis.getAsync('name2')
      .then( (result) => {
            console.log(result) //=> szw
            redis.quit()
      })

/* [MySQL]

// 发现mysql不调用connect()方法也行! 

const mysql = require('./utils/mysql_util')

mysql.queryAsync("select * from users")
      .then( (result) => {
            console.log("\n")
            console.log(result)
      })

mysql.queryAsync("select uid,name,session from users")
      .then( (result) => {
            console.log("\n")
            console.log(result)
      })

mysql.queryAsync("select uid,name,session from users")
      .then( (rows) => {
            console.log("\n")
            console.log(rows[0].name)
            console.log(rows[1].name)
            console.log(rows[1].uid)
      })

var querySql = "SELECT uid, name, pwd FROM users where name = ?"
var queryParams = ['szw']
mysql.queryAsync(querySql, queryParams)
      .then( (rows) => {
            console.log("\n")
            console.log(rows)
            console.log(rows[0].name)
      })

mysql.end()

*/