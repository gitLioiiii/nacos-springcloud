import axios from 'axios'
// import { useUserStore } from '@/stores/user'

const instance = axios.create({
    baseURL: import.meta.env.APP_BASE_URL,
})

// instance.interceptors.request.use((config) => {
//     const userStore = useUserStore()

//     if (userStore.logged) {
//         config.headers.Authorization = userStore.user.token.token
//     }

//     return config
// })

export default instance
