<script setup>

import {computed, nextTick, useAttrs, useSlots, watch,ref} from "vue";

const grid = defineProps(['isSelect', 'selector', 'isExpandedRowRender'])
const $emit = defineEmits(['inspectClick', 'tableChange', 'onSelectChange', 'batch', 'update:selector'])

const $attrs = useAttrs()
const $slots = useSlots()

const rowSelection =
    {
      onChange: (selectedRowKey, selectedRows) => {
        //觸發父層事件
        $emit('onSelectChange', selectedRows)
      },
      onSelect: (record, selected, selectedRows) => {
        // 更新父層變數
        $emit('update:selector', selectedRows)
      },
      onSelectAll: (selected, selectedRows, changeRows) => {
        // 更新父層變數
        $emit('update:selector', selectedRows, changeRows)
      }
    }

const renderColumns = computed(() => {
  return ($attrs.columns).filter(c => c.hidden)
})

function plainTextOf({record, column}) {
  if (column.formatter) {
    return column.formatter(record)
  }
  return (record)[column.dataIndex]
}

/**
 * Event
 */
const handleInspectClick = record => {
  $emit('inspectClick', record)
}
const handleTableChange = record => {
  $emit('tableChange', record)
}
/**
 * Element
 */
const tableRef = ref(null)

/**
 * 監聽
 */
watch(
    () => $attrs.columns,
    () => {
      nextTick(() => {
        if (tableRef.value) {
          const nativeTable = tableRef.value.$el
          const allHeader = nativeTable.querySelector('.ant-table-thead th')
          renderColumns.value.forEach((c, idx) => {
            if (grid.isSelect) {
              idx += 1
            }
            const head = allHeader[idx]
            if (c.width) {
              head.style.width = `${c.width}px`
              head.style.minWidth = `${c.width}px`
            } else {
              head.style.width = ''
            }

            if (c.ellipsis && c.width) {
              if (c.width) {
                head.style.maxWidth = `${c.width}px`
              } else {
                head.style.maxWidth = '50px'
              }
            }
          })
        }
      })
    }, {
      immediate: true
    }
)
</script>

<template>
  <div>
    <a-table
        class="cus__table"
        ref="tableRef"
        :rowClassName="(record,index)=>(index%2==1?'table-striped':null)"
        :row-selection="grid.isSelected ? rowSelection : null"
        v-bind="$attrs"
        @change="handleTableChange"
    >
      <template #headerCell="scope">
        <template v-if="scope.column.headerCellTemp">
          <slot :name="scope.column.headerCellTemp" :scope="scope"></slot>
        </template>
      </template>

      <template #bodyCell="scope">
        <template v-if="scope.column.type==='TEMPLATE'">
          <slot :name="scope.column.bodyCellTemp" :scope="scope"></slot>
        </template>

        <template v-else-if="scope.column.type === 'PLAIN'">
          <a class="link" v-if="scope.column.inspect" @click="handleInspectClick(scope)">{{ plainTextOf(scope) }}</a>
          <span v-else>{{ plainTextOf(scope) }}</span>
        </template>
      </template>

      <template v-if="grid.isExpandedRowRender" #expandedRowRender="{record,index}">
        <slot name="expandedRowRender" :record="record" :index="index" />
      </template>

      <template #title v-if="Object.keys($slots).includes('title')">
        <slot name="title"/>
      </template>

      <template #footer v-if="Object.keys($slots).includes('footer')">
        <slot name="footer"/>
      </template>


    </a-table>
  </div>
</template>

<style scoped lang="postcss">
.cus__table{
  .ant-table{
    @apply rounded-[12px_12px_0_0] text-base;
  }
  .ant-table-thead {
    /* 勾選 checkbox 欄位*/
    .ant-table-selection-column{
      --width:56px;
      @apply !w-[var(--width)] !min-w-[var(--width)];
      &:before{
        position:absolute;
        top: 50%;
        right: 0;
        width:1px;
        height: 1.6em;
        background-color: rgba(0,0,0,0.06);
        transform:translateY(-50%);
        transition: background-color 0.3s;
        content:'';
      }
    }
  }
  .ant-checkbox-inner{
    &:after{
      @apply left-[22.3%]
    }
  }
  .ant-table-row{
    &.ant-table-row-selected{
      >td{
        @apply border-b-0;
      }
      &:hover{
        >td{
          @apply !bg-primary-bg-light;
        }
      }
    }
  }

  .fblDataGridExpanded{
   @apply ml-[56px] rounded border border-border-gray bg-white;
    .ant-form{
      @apply inline-grid gap-2 p-[12px_16px];
      .ant-form-item{
        @apply mb-0;
      }
      .ant-form-item-label{
        @apply pb-1 font-medium;
      }
      .ant-form-item-control{
        .ant-form-item-control-input{
          @apply min-h-0 min-w-[240px] text-base;
        }
      }
      .ant-radio-wrapper{
        @apply whitespace-nowrap;
      }
    }
  }
  .ant-table-cell{
    .amount{
      @appl text-lg font-medium;
    }
  }
}

</style>
