<script setup>
import {useLoadingStore} from "@/stores/useLoading.js";
import Loading from '@/components/shared/Loading.vue'

</script>

<template>
  <Loading></Loading>
  <router-view></router-view>
</template>


