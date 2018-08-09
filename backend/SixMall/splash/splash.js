var path = require('path')
var fs = require('fs')
var utils = require('../mall_utils')

// TODO 后续splash不直接返回图片, 改为返回图片url, 让client端自己去加载图片

function onRequest(resp) {
      console.log("splash API : get request")

      var randomNum = Math.floor(1 + Math.random() * 7)  //序号1到7
      var rootPath = path.resolve(__dirname, "..","public/images/splash") //splash目录的父目录才有public文件
      var imgPath = path.join(rootPath, "splash" + randomNum + ".jpg")
      var imgUrl = "http://192.168.2.26:8899/images/splash/splash" + randomNum + ".jpg"

      utils.succResp(resp, ' "imgUrl": "'+imgUrl+'"')
}


exports.splash = onRequest


