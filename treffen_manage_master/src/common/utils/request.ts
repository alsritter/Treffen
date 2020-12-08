
import axios from 'axios'
import { ElMessage } from 'element-plus'
import router from "@/router";

const http = axios.create({
  baseURL: process.env.VUE_APP_BASEURL,
  timeout: 10000
})

//------------------- 请求拦截器
http.interceptors.request.use(config => {
  const token = window.localStorage.getItem('token')
  if (token != null) {
    // 请求前先带上 token
    config.headers.Authorization = token
  }

  return config
})


//----------------- 响应拦截器
http.interceptors.response.use(response => {
  return response
}, async error => {
  // 对响应错误做处理,拦截到 401 Token 错误就返回登陆
  if (error.response.data.code === 401) {
    ElMessage.error('登录过期了，请重新登陆')
    setTimeout(()=> {
      router.push("/login")
    }, 500)
  } else {
    return Promise.reject(error)
  }
})


export default http

