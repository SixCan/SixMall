Node.js Back-End

## API document

#### 1. 图片请求

example : "http://192.168.2.26:8899/images/splash/splash7.jpg"

#### 2. "/splash" 请求 (GET)


**example - request** :   

`http://192.168.2.26:8899/splash`

**example - response** :

```
{
  code: 100,
  msg: "success",
  payload: {
  imgUrl: "http://192.168.2.26:8899/images/splash/splash7.jpg"
  }
}
```

#### 3. "/home"请求 (GET)

#### 4. "/login"请求 (POST)



## 二. 错误码
200  访问成功

9001 登录失败. 用户名或密码不匹配


## 三. 重启机器后的步骤
1. 启动redis 
`$ redis-server`

2. 启动MySql
Mac上就是去设置中点击"Start MySQL Server"

3. 启动server
`$ node server.js`

