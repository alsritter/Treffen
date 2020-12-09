<template>
    <div id="app">
        <CreateMeetingForm />
    </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import CreateMeetingForm from "@/components/meeting/CreateMeetingForm.vue";

export default defineComponent({
    components: {
        CreateMeetingForm
    },
    setup() {
        return {};
    }
});
</script>

<style lang="less" scoped></style>
