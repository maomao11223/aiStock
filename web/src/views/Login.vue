<script setup>
import {getCurrentInstance, reactive} from 'vue'
import {message, Form} from 'ant-design-vue'
import {useLoadingStore} from "@/stores/useLoading.js";
import {useRouter} from "vue-router";
import {useUserStore} from "@/stores/useUser.js";

const loadingStore = useLoadingStore();
const userStore = useUserStore()

const {proxy: {$axios, $cookies}} = getCurrentInstance()

const $router = useRouter()

const form = reactive({
  email: '123@gmail.com',
  password: '123'
})

const rules = {
  email: [
    {required: true, message: '請輸入Email', trigger: 'blur'},
    {type: 'email', message: 'Email格式不正確', trigger: ['blur', 'change']}
  ],
  password: [
    {required: true, message: '請輸入密碼', trigger: 'blur'}
  ]
}

const {validate, validateInfos} = Form.useForm(form, rules)

/**
 * api
 */
const loginApi = async (inParams) => {
  try {
    const res = await $axios.post('/users/login', inParams)

    console.log(res)

    const resData = res.data

    // 儲存 token 到 cookie
    $cookies.set({key: 'token', value: resData.token})

    // 儲存使用者資訊（例如 userId）
    userStore.setUserInfo({userId: resData.userId})

    return resData
  } catch (err) {
    console.log(err)
    message.error('登入失敗，請檢查帳號密碼')
    throw err
  }
}
const getUserInfoApi = async () => {
  const userInfo = userStore.getUserInfo


  try {
    const res = await $axios.get('/users/getUserDetail', {
      userId: userInfo.userId
    })

    const resData = res.data
    userStore.setUserInfo({
      userId: resData.userId,
      userName: resData.userName
    })

    await $router.push({name: 'Home'})
  } catch (err) {
    console.log(err)
    message.error('取得使用者資訊失敗')
    throw err
  }
}


/**
 * methods
 */
const handleSubmit = () => {
  validate().then(async () => {
    loadingStore.showLoading()

    try {
      message.success('驗證成功，準備登入...')
      await loginApi(form)
      await getUserInfoApi()
    } catch (e) {
      // 已在 loginApi / getUserInfoApi 顯示錯誤訊息
    } finally {
      loadingStore.hideLoading()
    }
  })
}

</script>
<template>
  <div class="min-h-screen flex items-center justify-center bg-gray-100">
    <a-card class="w-full max-w-md shadow-lg">
      <template #title>
        <h2 class="text-xl font-semibold text-center">登入</h2>
      </template>
      <a-form
          layout="vertical"
      >
        <a-form-item label="Email" name="email" v-bind="validateInfos.email">
          <a-input v-model:value="form.email" placeholder="請輸入Email"/>
        </a-form-item>

        <a-form-item label="密碼" name="password" v-bind="validateInfos.password">
          <a-input-password v-model:value="form.password" placeholder="請輸入密碼"/>
        </a-form-item>

        <a-form-item>
          <a-button type="primary" html-type="submit" class="w-full" @click="handleSubmit">
            登入
          </a-button>
        </a-form-item>
      </a-form>
    </a-card>
  </div>
</template>


