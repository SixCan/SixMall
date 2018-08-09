var http = require('http')
var url = require('url')
var queryString = require('querystring')
var fs = require('fs')

http.createServer(onRequest).listen(8899, function () {
      console.log("server starts up! (listen on 8899)")
})

/* 应对两种请求: 一种是静态文件(如图片)的请求, 返回文件; 另一种是API请求, 返回json串:

a.com/123.jpg

a.com/home
a.com/item?id=123&from=3rd
*/
function onRequest(req, resp) {
      var reqUrl = req.url          //=> "item?id=2&from=a" , "/", "/public/a.jpg"
      var apiName = url.parse(reqUrl).pathname  //=> "/item", "/", "/public/a.jpg"
      console.log("szw : url = " + reqUrl + " ; api = " + apiName)
}



/* response : 
{
      "code":100 //100为成功
      "msg": "success"
      "payload":{
            ...
      }
}
*/
