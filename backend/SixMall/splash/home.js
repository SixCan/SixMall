var utils = require('../utils/mall_utils')

function onRequest(req, resp) {
      var homeContent = `"hotkey":"kitty","recommendations":[{"id":"38013","pic":"http://192.168.2.26:8899/images/items/cat3.webp","title":"Kitty Adoption"},{"id":"38014","pic":"http://192.168.2.26:8899/images/items/cat4.webp","title":"Kitty Adoption"},{"id":"39303","pic":"http://192.168.2.26:8899/images/items/iphoneX2.png","title":"iPhone X"},{"id":"39319","pic":"http://192.168.2.26:8899/images/items/cat9.webp","title":"Kitty Adoption"},{"id":"39401","pic":"http://192.168.2.26:8899/images/items/pixel1.webp","title":"Pixel Phone"}]`

      utils.succResp(resp, homeContent)
      
}
exports.home = onRequest