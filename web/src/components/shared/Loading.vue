<script setup>
import {useLoadingStore} from "@/stores/useLoading.js";

const loadingStore = useLoadingStore()
</script>

<template>
<div v-if="loadingStore.isLoading" class="absolute z-50 h-screen w-screen bg-gray-200/50 flex">

  <a-spin
  size="large"
  tip="Loading..."
  spinning
  style="margin: auto;"
  class=" z-50  items-center justify-center"
  ></a-spin>
</div>
</template>

<style scoped>

</style>
