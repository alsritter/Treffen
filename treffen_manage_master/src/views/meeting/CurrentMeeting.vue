<template>
    <div id="app">
        <CurrentMeetingList />
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import CurrentMeetingList from "@/components/meeting/CurrentMeetingList.vue";

export default defineComponent({
    components: {
        CurrentMeetingList
    },
    setup() {
        return {};
    }
});
</script>

<style lang="less" scoped></style>
