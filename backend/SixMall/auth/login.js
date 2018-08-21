var path = require('path')
var utils = require('../mall_utils')
var postUtils = require('../post')

function onRequest(req, resp) {
      var postData = postUtils.getPost(req)
      console.log('szw post data = ' + postData)
}
exports.login = onRequest