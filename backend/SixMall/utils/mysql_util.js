// terminate :  > mysql -u root -p

var mysqlClient = require('mysql')
var Q = require('bluebird')

Q.promisifyAll(require('mysql/lib/Connection').prototype)
Q.promisifyAll(require('mysql/lib/Pool').prototype)

var mysql = mysqlClient.createConnection({
      host: 'localhost',
      user: 'root',
      password: '594_zheYoung',
      database: 'sixmall'
})


module.exports = mysql

