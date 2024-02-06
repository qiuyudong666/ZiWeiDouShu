// import Vue from 'vue'
// import VueRouter from 'vue-router'
// import Home from '../views/Home'
//
// Vue.use(VueRouter)

import Vue from 'vue'
import Router from 'vue-router'
//主页面
import mainPage from '@/views/main/mainPage'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            component: mainPage,
            children: [
                {
                    path: '/system/role',
                    component: () => import('../views/system/role.vue'),
                    name: 'jsgl',
                },
                {
                    path: '/system/authority',
                    component: () => import('../views/system/authority.vue'),
                    name: 'qxgl'
                },
                {
                    path: '/system/user',
                    component: () => import('../views/system/user.vue'),
                    name: 'yhgl'
                }
            ]
        }
    ]
})

