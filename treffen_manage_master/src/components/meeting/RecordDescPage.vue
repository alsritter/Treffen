<template>
    <el-dialog title="会议内容" v-model="dialogVisible">
        <div v-html="message"></div>
    </el-dialog>
</template>

<script lang="ts">
import { defineComponent, computed } from "vue";

export default defineComponent({
    props: {
        value: Boolean,
        message: String
    },
    setup(props, { emit }) {
        const dialogVisible = computed({
            get: () => props.value,
            set: value => emit("update:value", value)
        });

        return {
            dialogVisible
        };
    }
});
</script>

<style lang="less" scoped></style>
