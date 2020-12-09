/**
 * 退出登陆
 */
import request from '@/common/utils/request'
import router from '@/router'


export default () => {
  // 不管是否登陆成功都要清除本地 Token 所以直接异步请求就完事了
  // 因为要等请求发出去之后才能清除 token，否则请求里面没有这个 token
  request.post('/api/auth/logout')
    .then(res => {
      // 先清空菜单
      localStorage.removeItem('menus');
      // 再清除 token
      localStorage.removeItem('token')
    })
    .catch(error => {
      localStorage.removeItem('menus');
      localStorage.removeItem('token')
      console.error(error);
    })

  router.push('/login')
}