/* 发现不调用connect()方法也行! */
const mysql = require('./utils/mysql_util')

mysql.queryAsync("select * from users")
      .then( (result) => {
            console.log(result)
      })

mysql.queryAsync("select uid,name,session from users")
      .then( (result) => {
            console.log(result)
      })



// mysql.end()