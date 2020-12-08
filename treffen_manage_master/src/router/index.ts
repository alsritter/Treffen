import { createRouter, createWebHashHistory, RouteRecordRaw } from "vue-router";
import Home from '@/views/Home.vue';
import Login from '@/views/Login.vue'
import NotDefine from '@/views/NotDefine.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
    children: [
      {
        path: "/:other",
        name: "Other",
        component: NotDefine
      }
    ]
  },
  {
    path: "/login",
    name: "Login",
    component: Login
  }

  // {
  //   path: "/about",
  //   name: "About",
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () =>
  //     import(/* webpackChunkName: "about" */ "../views/About.vue")
  // }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes
});

export default router;
