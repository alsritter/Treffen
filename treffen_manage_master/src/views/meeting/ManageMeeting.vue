<template>
    <div id="app">
        <ManageMeetingList />
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import ManageMeetingList from "@/components/meeting/ManageMeetingList.vue";

export default defineComponent({
    components: {
        ManageMeetingList
    },
    setup() {
        return {};
    }
});
</script>

<style lang="less" scoped></style>
