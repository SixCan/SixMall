var utils = require('../utils/mall_utils')

function onRequest(req, resp) {
      var itemDescription = `"id":"39401","shopId":"301","pic":["http://192.168.2.26:8899/images/items/pixel1.webp","http://192.168.2.26:8899/images/items/pixel2.webp","http://192.168.2.26:8899/images/items/pixel3.webp","http://192.168.2.26:8899/images/items/pixel4.webp","http://192.168.2.26:8899/images/items/pixel5.webp"],"title":"Pixel Phone","subtitle":"Made by Google, inside and out","price":"399.99","originalPrice":"599.99","sku":{"color":[{"text":"black","hex":"#1e1e1e"},{"text":"grey","hex":"#cccccc"}]},"descrption":""`

      utils.succResp(resp, itemDescription)
      
}
exports.item = onRequest