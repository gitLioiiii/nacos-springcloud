<template>
    <div class="login-wrapper">
        <h1>登录</h1>
        <ElForm ref="form" :model="model" :rules="rules" size="large" @submit.prevent="login">
            <ElFormItem prop="username">
                <ElInput v-model="model.username" placeholder="账号" />
            </ElFormItem>
            <ElFormItem prop="password">
                <ElInput v-model="model.password" type="password" placeholder="密码" />
            </ElFormItem>
            <ElFormItem>
                <ElButton native-type="submit" type="primary" style="flex: auto">登录</ElButton>
            </ElFormItem>
        </ElForm>
        <div>
            <RouterLink :to="{ name: 'index' }" class="back">立即返回</RouterLink>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
import { useRouter, RouterLink } from 'vue-router'
import { ElForm, ElFormItem, ElInput, ElButton, ElMessage } from 'element-plus'
import { useUserStore } from '@/stores/user'
import request from '@/utils/request'

const userStore = useUserStore()

const router = useRouter()
const form = ref(null)

const model = reactive({
    username: '',
    password: '',
})

const rules = reactive({
    username: [
        { required: true, message: '请输入账号。', trigger: 'blur' },
        { min: 2, max: 16, message: '账号仅限1~16个字符。', trigger: 'change' },
    ],
    password: [
        { required: true, message: '请输入密码。', trigger: 'blur' },
        { min: 6, max: 16, message: '账号仅限6~16个字符。', trigger: 'change' },
    ],
})

const login = () => {
    form.value.validate().then((result) => {
        if (result === true) {
            request
                .post('/login', model)
                .then((response) => {
                    if (response.data.status === true) {
                        let authorities = response.data.payload.authorities.map(
                            (authority) => authority.name,
                        )

                        userStore.login({ ...response.data.payload, authorities })
                        userStore.cache('user', { ...response.data.payload, authorities })

                        ElMessage.success('登录成功。')
                        router.replace({ name: 'index' })
                    } else {
                        ElMessage.error('登录失败。')
                    }
                })
                .catch(() => {
                    ElMessage.error('登录失败。')
                })
        }
    })
}
</script>

<style>
.login-wrapper {
    display: flex;
    flex-flow: column nowrap;
    align-items: center;
    justify-content: center;

    height: 100vh;
    width: 100vw;
}

.login-wrapper h1 {
    font-size: 1.5rem;
    margin: 0rem 0rem 2rem 0rem;
}

.login-wrapper .back {
    color: var(--el-text-color-secondary);
    font-size: var(--el-font-size-small);
}
</style>
