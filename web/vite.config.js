import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import tailwindcss from '@tailwindcss/vite'
import path, { resolve } from 'path'
// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(),tailwindcss()],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src')
    }
  },
  server: {
    host: '0.0.0.0',
    port:3000,
    proxy:{
      '/api':{
        target:'http://localhost:8080/api/',
        changeOrigin:true,
        secure:false,
      }
    }
  },
})
