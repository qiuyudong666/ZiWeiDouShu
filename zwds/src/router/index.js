import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../../../yijing-admin/src/views/Home'

Vue.use(VueRouter)

const router=new VueRouter({
    routes:[
        {
            path:'/',
            component:Home,
            children: [
                {
                    path: '/Role',
                    component: Role,
                    name: '角色管理',
                },
                {
                    path: '/User',
                    component: User,
                    name: '用户管理'
                }
            ]
        }
    ]
})

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
