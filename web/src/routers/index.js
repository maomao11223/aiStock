import {createWebHistory, createRouter} from 'vue-router'

import BaseLayoutView from '@/layouts/BaseLayout.vue'
import LoginLayoutView from '@/layouts/LoginLayout.vue'

import HomePageView from '@/views/HomePage.vue'
import StockListView from '@/views/StockList.vue'

import LoginView from '@/views/Login.vue'

const routes = [
    {
        path: '/',
        component: BaseLayoutView,
        redirect: 'Home',
        meta: {
            breadcrumbName: 'Home'
        },
        children: [
            {
                path: '',
                component: HomePageView,
                name: 'Home',
            },
            {
                path: '/stocks', component: StockListView, name: 'StockList',
                meta: {
                    breadcrumbName: 'StockList',
                }
            },
        ]
    },
    {
        path:'/login',
        component: LoginLayoutView,
        children: [
            {
                path: '',
                component: LoginView,
                name:'Login'
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
