import {createApp} from 'vue'
import './assets/css/style.css'
import App from './App.vue'

import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';

import AxiosUtil from "./utils/api/axiosUtil.js";
import CookieUtil from './utils/cookieUtil.js'
import Router from './routers'

import {createPinia} from "pinia";

const pinia = createPinia()


createApp(App)
    .use(Antd).use(AxiosUtil)
    .use(CookieUtil)
    .use(Router)
    .use(pinia)
    .mount('#app')
