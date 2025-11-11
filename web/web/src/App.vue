<template>
    <RouterView />
</template>

<script setup>
import { RouterView } from 'vue-router'
import { useUserStore } from '@/stores/user'

const userStore = useUserStore()
userStore.login(userStore.load('user'))
</script>

<style>
:root:root {
    --el-color-primary: #0da5aa;
    --el-color-primary-light-3: #14c9c9;
    --el-color-primary-light-5: #37d4cf;
    --el-color-primary-light-7: #5edfd6;
    --el-color-primary-light-8: #89e9e0;
    --el-color-primary-light-9: #e8fffb;
    --el-color-primary-dark-2: #07828b;
}

.el-pagination {
    margin: 2rem 0rem;
}

body {
    margin: 0rem;
}
</style>
