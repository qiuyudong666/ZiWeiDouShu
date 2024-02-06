<template>
  <div >
    <ul>
      <li v-for="item in list" :key="item.id">
        {{item.name}}
      </li>
    </ul>
  </div>
</template>

<script lang="ts" setup name="Person">
import {defineProps} from 'vue'
const props = defineProps(['list'])

console.log(props)
</script>
