import Vue ,{ createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementPlus from 'element-plus';
import 'element-plus/lib/theme-chalk/index.css';
import lang from 'element-plus/lib/locale/lang/zh-cn'
import locale from 'element-plus/lib/locale'


// 设置语言
locale.use(lang)

const app = createApp(App)
app.use(store)
  .use(router)
  .use(ElementPlus, { locale })
  .mount("#app");
