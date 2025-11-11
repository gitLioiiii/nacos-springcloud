import { createRouter, createWebHistory } from 'vue-router'
import { useUserStore } from '@/stores/user'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'base',
            component: () => import('@/views/BaseView.vue'),
            children: [
                {
                    path: '',
                    name: 'index',
                    component: () => import('@/views/IndexView.vue'),
                },
                {
                    path: '',
                    name: 'music',
                    component: () => import('@/views/music/IndexView.vue'),
                },
                {
                    path: '',
                    name: 'user',
                    component: () => import('@/views/user/IndexView.vue'),
                },
            ],
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('@/views/LoginView.vue'),
        },
        {
            path: '/denied',
            name: 'denied',
            component: () => import('@/views/DeniedView.vue'),
        },
    ],
})

router.beforeEach((to) => {
    const userStore = useUserStore()

    // if (to.name !== 'login' && !userStore.logged) {
    //     return { name: 'login' }
    // }

    if (to?.meta?.authority) {
        if (userStore.logged) {
            if (!userStore.granted(to.meta.authority)) {
                return { name: 'denied' }
            }
        } else {
            return { name: 'login' }
        }
    }
})

export default router
