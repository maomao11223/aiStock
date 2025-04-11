import {defineStore} from "pinia";
import {computed, ref} from "vue";

export const useUserStore = defineStore("user", () => {
    const userInfo = ref({
        userName: '',
        userId: '',
    });


    const setUserInfo = ({userName, userId}) => {
        userInfo.value.userName = userName;
        userInfo.value.userId = userId;
    }

    const getUserInfo = computed(() => {
        return userInfo.value
    })


    return {
        setUserInfo,
        getUserInfo
    }
})
