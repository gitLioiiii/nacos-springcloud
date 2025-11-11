import { computed, ref } from 'vue'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', () => {
    const user = ref(null)

    const name = computed(() => user.value?.user.name || user.value?.user.username)

    const logged = computed(() => user.value !== null)

    const granted = (authority) => {
        // return user.value?.authorities.includes(authority)
        return user.value && user.value.authorities
            ? user.value.authorities.includes(authority)
            : false
    }

    const login = (data) => {
        user.value = data
    }

    const logout = () => {
        user.value = null
    }

    const load = (key) => {
        return JSON.parse(window.localStorage.getItem(key))
    }

    const cache = (key, value) => {
        window.localStorage.setItem(key, JSON.stringify(value))
    }

    const clear = (key) => {
        window.localStorage.removeItem(key)
    }

    return { user, name, logged, login, logout, load, cache, clear, granted }
})
