var utils = require('../utils/mall_utils')

function onRequest(req, resp) {
      var homeContent = `"hotkey":"kitty","recommendations":[{"id":"33880013","pic":"http://192.168.2.26:8899/images/items/cat3.webp","title":"Kitty Adoption"},{"id":"33880014","pic":"http://192.168.2.26:8899/images/items/cat4.webp","title":"Kitty Adoption"},{"id":"338203303","pic":"http://192.168.2.26:8899/images/items/iphoneX2.png","title":"iPhone X"},{"id":"33880019","pic":"http://192.168.2.26:8899/images/items/cat9.webp","title":"Kitty Adoption"},{"id":"338203301","pic":"http://192.168.2.26:8899/images/items/iphone6.webp","title":"iPhone6"}]`

      utils.succResp(resp, homeContent)
      
}
exports.home = onRequest