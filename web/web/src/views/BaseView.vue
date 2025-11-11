<template>
    <header class="base-header">
        <h1 class="base-header-logo">Music Dreamer悦享音乐</h1>
    </header>
    <main class="base-main">
        <RouterView />
    </main>
    <nav class="base-navigation">
        <RouterLink :to="{ name: 'index' }" class="base-navigation-item">
            <HomeIcon class="base-navigation-item-icon" />
            <span class="base-navigation-item-text">发现</span>
        </RouterLink>
        <RouterLink :to="{ name: 'music' }" class="base-navigation-item">
            <MusicIcon class="base-navigation-item-icon" />
            <span class="base-navigation-item-text">歌单</span>
        </RouterLink>
        <RouterLink :to="{ name: 'user' }" class="base-navigation-item">
            <UserIcon class="base-navigation-item-icon" />
            <span class="base-navigation-item-text">设置</span>
        </RouterLink>
    </nav>
</template>

<script setup>
import { RouterView, RouterLink } from 'vue-router'
import HomeIcon from '~icons/bi/globe'
import MusicIcon from '~icons/bi/music-note-list'
import UserIcon from '~icons/bi/person'
</script>

<style>
/* header */
.base-header {
    background: rgb(255, 255, 255, 0.8);
    border-bottom: 0.0625rem solid #dddddd;
    box-shadow: 0rem 0rem 0.5rem #eeeeee;

    position: fixed;
    top: 0rem;
    width: 100%;
    z-index: 999;
}

.base-header-logo {
    color: var(--color-primary-normal);
    font-size: var(--font-size-large);
    font-weight: var(--font-weight);
    line-height: var(--line-height-normal);
    margin: 0rem;
    padding: 0.5rem 2rem;
    text-align: center;
}

/* main */
.base-main {
    padding: 3.5rem 2rem 5.5rem 2rem;
}

/* navigation */
.base-navigation {
    display: flex;
    flex-flow: row nowrap;
    align-items: stretch;
    justify-content: space-between;

    background: rgb(255, 255, 255, 0.8);
    border-top: 0.0625rem solid #dddddd;
    box-shadow: 0rem 0rem 0.5rem #eeeeee;
    position: fixed;
    bottom: 0rem;
    width: 100%;
    z-index: 999;
}

.base-navigation-item {
    display: flex;
    flex-flow: column nowrap;
    align-items: center;
    justify-content: center;

    /* background: #ffffff; */
    /* border-top: 0.0625rem solid #ffffff; */
    color: var(--font-color-normal);
    padding: 1rem 2rem;
    /* transition: all 0.2s; */
    text-decoration: none;
}

.base-navigation-item-icon {
    height: 1rem;
    width: 1rem;
}

.base-navigation-item-text {
    font-size: var(--font-size-small);
    line-height: var(--line-height-normal);
}

.base-navigation-item.router-link-exact-active {
    /* background: var(--color-primary-light-extra); */
    color: var(--color-primary-normal);
    /* border-top-color: var(--color-primary-normal); */
}
</style>
