var http = require('http')
var url = require('url')
var queryString = require('querystring')
var fs = require('fs')

http.createServer(onRequest).listen(8899, function(){
      console.log("server starts up! (listen on 8899)")
})

/*
a.com/123.jpg

a.com/home
a.com/item?id=123&from=3rd
*/
function onRequest(req, resp){
      var reqUrl = req.url

}

function send404(response, err) {
      response.writeHead(404, { 'Content-Type': 'application/json' });
      response.write('Error 404: resource not found : ' + err);
      response.end();
}

function sendFile(response, filePath, fileContents) {
      response.writeHead(200, { 'Content-Type': 'text/plain' });
      response.end(fileContents);
}