<template>
    <div id="app">
        <HistoryMeetingList />
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import HistoryMeetingList from "@/components/meeting/HistoryMeetingList.vue";

export default defineComponent({
    components: {
        HistoryMeetingList
    },
    setup() {
        return {};
    }
});
</script>

<style lang="less" scoped></style>
