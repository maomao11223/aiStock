<script setup>
import {getCurrentInstance, onMounted, ref} from "vue";
import DataGrid from "@/components/shared/dataGrid.vue";

const {proxy: {$axios}} = getCurrentInstance()

const dataGridTable = ref({
  rowKey: 'stockId',
  columns: [
    {
      title: 'id',
      dataIndex: 'stockId',
      type: 'PLAIN'
    },
    {
      title: 'StockName',
      dataIndex: 'stockName',
      type: 'PLAIN'
    },
    {
      title: 'market',
      dataIndex: 'market', type: 'PLAIN'
    },
    {
      title: 'industry',
      dataIndex: 'industry', type: 'PLAIN'
    },
    {
      title:'detail',
      type:'TEMPLATE',
      bodyCellTemp:'detailTemp'
    }
  ],
  datas: [],
  pagination: {
    current: 1,
    pageSize: 1,
    pageSizeOptions: ['1', '5', '50'],
    showSizeChanger: true,
    total: 0
  }
})


const getStocksApi = async () => {

  const params = {
    page: dataGridTable.value.pagination.current - 1,
    size: dataGridTable.value.pagination.pageSize
  }

  $axios.get('/stocks', params)
      .then(res => {

        const $resData = res.data;

        dataGridTable.value.datas = $resData.content;
        dataGridTable.value.pagination.total = Number($resData.totalElements)


      })
}

const onTableChange = (record) => {
  console.log('onTableChange',record)
  dataGridTable.value.pagination.current = record.current
  dataGridTable.value.pagination.pageSize=record.pageSize

  getStocksApi();
}
const toDetailPage=(record)=>{
  console.log(record)
  //todo to detailpage
}
onMounted(
    async () => {
      await getStocksApi();
    }
)

</script>

<template>
  <section class=" m-6">
    <dataGrid :columns="dataGridTable.columns" :data-source="dataGridTable.datas" bordered
              :pagination="dataGridTable.pagination"
              @tableChange="onTableChange"
    >
      <template #detailTemp="{scope:{value}}">
        <a-button type="primary" @click="toDetailPage(value)">detail</a-button>
      </template>

    </dataGrid>

  </section>
</template>

<style scoped>

</style>
