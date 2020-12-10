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
        path: "/createMeeting",
        name: "CreateMeeting",
        component: () => import("@/views/meeting/CreateMeeting.vue")
      },
      {
        path: "/historyMeeting",
        name: "HistoryMeeting",
        component: () => import("@/views/meeting/HistoryMeeting.vue")
      },
      {
        path: "/currentMeeting",
        name: "CurrentMeeting",
        component: () => import("@/views/meeting/CurrentMeeting.vue")
      },
      {
        path: "/updateMeeting",
        name: "ManageMeeting",
        component: () => import("@/views/meeting/ManageMeeting.vue")
      },
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
