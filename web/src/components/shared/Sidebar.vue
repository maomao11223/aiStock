<template>
  <div class="flex flex-col min-h-svh max-h-svh">
    <a-button style="margin-left: auto" type="primary" @click="toggleCollapsed">
      <MenuUnfoldOutlined v-if="state.collapsed"/>
      <MenuFoldOutlined v-else/>
    </a-button>
    <a-menu
        id="dddddd"
        :inline-collapsed="state.collapsed"
        v-model:openKeys="state.openKeys"
        v-model:selectedKeys="state.selectedKeys"
        class="h-full overflow-y-auto"
        mode="inline"
        :items="items"
        @click="handleClick"
    ></a-menu>
  </div>
</template>
<script setup>
import {reactive, ref, watch, VueElement, h} from 'vue';
import {
  AppstoreOutlined,
  SettingOutlined,
  StockOutlined,
  HomeOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined
} from '@ant-design/icons-vue';
import {useRouter} from "vue-router";

const $router = useRouter()

const state = ref({
  selectedKeys: ['Home'],
  openKeys: ['Home'],
  preOpenKeys: ['Home'],
})

function getItem(
    label,
    key,
    icon,
    children,
    type,
) {
  return {
    key,
    icon,
    children,
    label,
    type,
  };
}

const items = reactive([
  {
    label: "Home", key: "Home", icon: () => h(HomeOutlined)
  },
  {
    label: "Stock", key: "Stock", icon: () => h(StockOutlined),
    children: [
      {
        label: "List", key: "StockList", icon: () => h(StockOutlined),
      }
    ]
  },

  {type: 'divider'},
]);

const handleClick = e => {
  console.log('click', e);
  $router.push({name: e.key})
};


const toggleCollapsed = () => {
  state.value.collapsed = !state.value.collapsed;
  state.value.openKeys = state.value.collapsed ? [] : state.value.preOpenKeys;
};

watch(state.value.openKeys, (_val, oldVal) => {
  console.log('openKeys', val);

  state.value.preOpenKeys = oldVal;

});
</script>

