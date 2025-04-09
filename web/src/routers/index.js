import { createWebHistory, createRouter } from 'vue-router'
import HomePageView from '@/views/HomePage.vue'
import StockListView from '@/views/StockList.vue'

const routes = [
    { path: '/', component: HomePageView },
    { path: '/stocks', component: StockListView },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
