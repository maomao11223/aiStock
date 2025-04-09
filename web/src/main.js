import { createApp } from 'vue'
import './assets/css/style.css'
import App from './App.vue'

import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';

import AxiosUtil from "./utils/api/axiosUtil.js";
import Router from './routers'


createApp(App).use(Antd).use(AxiosUtil).use(Router).mount('#app')
