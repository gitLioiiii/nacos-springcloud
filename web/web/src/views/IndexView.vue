<template>
        <div class="search-bar" >
            <div class="search-bar-input-group">
                <ElInput
                    v-model="input"
                    class="search-input"
                    placeholder="请输入歌名"
                    @keyup.enter="performSearch"
                    />
                <ElButton type="primary" @click="performSearch">搜索</ElButton>
            </div>
            <ElCard>
                <span>最新搜索</span>
                <div class="flex gap-2" v-if="searchHistory.length">
                <ElTag
                    v-for="item in searchHistory"
                    :key="item.term"
                    :type="item.type"
                    closable
                    style="cursor: pointer"
                    @close="removeTag(item.term)"
                    @click="handleTagClick(item.term)"
                >
                    {{ item.term }}
                </ElTag>
                </div>
            </ElCard>
        </div>
    <div class="music-list">
        <div class="music-list-item">


            <div class="music-list-item-cover">
                <img src="/public/pic/cover.png" alt="music" />
            </div>
            <div class="music-list-item-information">
                <h3 class="music-list-item-name">音乐名称</h3>
                <div class="music-list-item-extra">张三</div>
            </div>
        </div>
        <div class="music-list-item">
            <div class="music-list-item-cover">
                <img src="/public/pic/cover.png" alt="music" />
            </div>
            <div class="music-list-item-information">
                <h3 class="music-list-item-name">音乐名称</h3>
                <div class="music-list-item-extra">张三</div>
            </div>
        </div>
        <div class="music-list-item">
            <div class="music-list-item-cover">
                <img src="/public/pic/cover.png" alt="music" />
            </div>
            <div class="music-list-item-information">
                <h3 class="music-list-item-name">音乐名称</h3>
                <div class="music-list-item-extra">张三</div>
            </div>
        </div>
        <div class="music-list-item">
            <div class="music-list-item-cover">
                <img src="/public/pic/cover.png" alt="music" />
            </div>
            <div class="music-list-item-information">
                <h3 class="music-list-item-name">音乐名称</h3>
                <div class="music-list-item-extra">张三</div>
            </div>
        </div>
        <div class="music-list-item">
            <div class="music-list-item-cover">
                <img src="/public/pic/cover.png" alt="music" />
            </div>
            <div class="music-list-item-information">
                <h3 class="music-list-item-name">音乐名称</h3>
                <div class="music-list-item-extra">张三</div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { ElInput, ElButton, ElCard, ElTag, ElMessage } from 'element-plus'
import request from '@/utils/request'

// 历史搜索
const input = ref('')
const searchHistory = ref([])
const max_History = 6
const tagTypes = ['primary', 'success', 'warning', 'purple', 'pink']
let nextType = 0

// 获取下一个颜色类型（按顺序分配）
const getNextType = () => {
  const type = tagTypes[nextType % tagTypes.length]
  nextType++
  return type
}

const loadHistory = () => {
  try {
    const raw = localStorage.getItem('searchHistory')
    if (raw) {
      const list = JSON.parse(raw)
      if (Array.isArray(list)) {
        searchHistory.value = list
        // 计算下一个颜色索引
        if (list.length > 0) {
          const lastType = list[0].type
          nextType = tagTypes.indexOf(lastType) + 1
          if (nextType >= tagTypes.length) {
            nextType = 0
          }
        }
      }
    }
  } catch {
    ElMessage.error('加载历史失败。')
  }
}

const saveHistory = () => {
  try {
    localStorage.setItem('searchHistory', JSON.stringify(searchHistory.value))
  } catch {
    ElMessage.error('保存到localStorage失败。')
  }
}

// 进行搜索
const performSearch = async () => {
  const term = (input.value || '').trim()
  if (!term) return

  // 检索词是否已存在
  const existingIndex = searchHistory.value.findIndex(item => item.term === term)

  if (existingIndex !== -1) {
    // 如果已存在，移到最前面（保持原有颜色）
    const existingItem = searchHistory.value.splice(existingIndex, 1)[0]
    searchHistory.value.unshift(existingItem)
  } else {
    // 如果不存在，创建新项并分配颜色
    const newItem = {
      term: term,
      type: getNextType()
    }
    searchHistory.value.unshift(newItem)

    // 保持最大数量
    if (searchHistory.value.length > max_History) {
      searchHistory.value.length = max_History
    }
  }
  saveHistory()

  try {
    const resp = await request.post('/search', { keyword: term })
    ElMessage.success(`已找到 ${Array.isArray(resp.data) ? resp.data.length : 0} 首歌曲`)
  } catch {
    ElMessage.error('搜索失败，请稍后重试。')
  }
}

// 移除标签
const removeTag = (tag) => {
  const id = searchHistory.value.findIndex(item => item.term === tag)
  if (id !== -1) {
    searchHistory.value.splice(id, 1)
    saveHistory()
  }
}

// 点击标签，填充搜索框并搜索
const handleTagClick = (term) => {
  input.value = term
  performSearch()
}
onMounted(loadHistory)

</script>

<style>

:deep(.el-tag--purple) {
  --el-tag-bg-color: #faf5ff;
  --el-tag-border-color: #e9d5ff;
  --el-tag-hover-color: #a855f7;
  --el-tag-text-color: #a855f7;
}

:deep(.el-tag--pink) {
  --el-tag-bg-color: #fdf2f8;
  --el-tag-border-color: #fbcfe8;
  --el-tag-hover-color: #ec4899;
  --el-tag-text-color: #ec4899;
}

:deep(.search-input .el-input__wrapper) {
  border: 1px solid var(--el-color-primary);
  border-radius: 4px;
}

.search-bar {
  margin-bottom: 1rem;
  margin-right: 1rem;
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.search-bar-input-group {
  display: flex;
  align-items: center;
}

.search-bar-input-group .search-input {
  flex: 1;
}

@media screen and (max-width: 768px) {
    .search-bar {
        width: calc(100vw - 2rem - 2rem);
    }
}

@media screen and (min-width: 768px) {
    .search-bar {
        width: calc((100vw - 2rem - 2rem * 2) / 2);
    }
}

@media screen and (min-width: 992px) {
    .search-bar {
        width: calc((100vw - 2rem - 2rem * 3) / 3);
    }
}

/* 原有的 */
.music-list {
    display: flex;
    flex-flow: row wrap;
    align-items: flex-start;
    justify-content: flex-start;

    margin: 0rem -1rem;
}

.music-list-item {
    background: #eeeeee;
    margin: 1rem;
}

.music-list-item-cover {
    display: flex;
    flex-flow: row nowrap;
    align-items: center;
    justify-content: center;

    height: 10rem;
    overflow: hidden;
    width: 100%;
}

.music-list-item-cover img {
    object-fit: cover;
    max-width: 100%;
}

.music-list-item-information {
    padding: 1rem;
}

.music-list-item-name {
    color: var(--font-color-normal);
    font-size: var(--font-size-large);
    font-weight: var(--font-weight);
    margin: 0rem;
}

.music-list-item-extra {
    color: var(--font-color-light);
    line-height: var(--line-height-normal);
    margin-top: 0.5rem;
}

@media screen and (max-width: 768px) {
    .music-list-item {
        width: calc(100vw - 2rem - 2rem);
    }
}

@media screen and (min-width: 768px) {
    .music-list-item {
        width: calc((100vw - 2rem - 2rem * 2) / 2);
    }
}

@media screen and (min-width: 992px) {
    .music-list-item {
        width: calc((100vw - 2rem - 2rem * 3) / 3);
    }
}
</style>
