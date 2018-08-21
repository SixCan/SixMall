var http = require('http')
var url = require('url')
var queryString = require('querystring')

var router = {}
// 请求静态图片
var staticRes = require('./static_res') 
router["res"] = staticRes.requestStaticRes

var splashApi = require('./splash/splash')
router["/splash"] = splashApi.splash
var loginApi = require('./auth/login')
router["/login"] = loginApi.login


http.createServer(onRequest).listen(8899, function () {
      console.log("server starts up! (listen on 8899)")
})



/* 应对三种请求: 
      * 一种是静态文件(如图片)的请求, 返回文件: a.com/123.jpg
      * 另一种是GET API请求, 返回json串: a.com/item?id=123&from=3rd
      * 再一种就是POST API请求: a.com/login
*/
function onRequest(req, resp) {
      var reqUrl = req.url          //=> "item?id=2&from=a" , "/", "/home", "/public/a.jpg"
      var apiName = url.parse(reqUrl).pathname  //=> "/item", "/", "/home", "/public/a.jpg"
      if (reqUrl === '/favicon.ico') {
            return
      }

      if (reqUrl.endsWith("jpg")) {
            router["res"](reqUrl, resp)
            return
      }

      console.log("szw : url = " + reqUrl + " ; api = " + apiName)

      dispatch(req, apiName, resp)
}

function dispatch(req, apiName, resp) {
      var target = router[apiName]
      if (typeof target === 'function') {
            target(req, resp)
      } else {
            // TODO 有问题就sendError()
      }
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
