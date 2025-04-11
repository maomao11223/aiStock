<script setup>

import Sidebar from "@/components/shared/Sidebar.vue";
import {computed, ref, watch} from "vue";
import {useRoute, useRouter} from "vue-router";

const $route = useRoute()
const $router = useRouter()

const breadcrumbs = computed(() => {
  const newList = $route.matched.map((item) => {
    if (item.meta && item.meta.breadcrumbName) {

      console.log('bread', item)
      return {
        name: item.meta.breadcrumbName
      }
    }
    return null
  }).filter(Boolean)
  return newList
})

const toLogin=()=>{
  $router.push({name:'Login'})
}


</script>

<template>
  <section class="flex min-h-full">
    <Sidebar></Sidebar>
    <main class="grow min-h-svh max-h-svh">
      <nav class="w-full flex justify-between px-4 pt-4">
        <a-breadcrumb>
          <a-breadcrumb-item v-for="b in breadcrumbs">{{ b.name }}</a-breadcrumb-item>
        </a-breadcrumb>
        <div class="">
          username
          <a-button type="primary" @click="toLogin">login</a-button>
        </div>
      </nav>
      <router-view></router-view>
    </main>
  </section>
</template>

<style scoped>

</style>
