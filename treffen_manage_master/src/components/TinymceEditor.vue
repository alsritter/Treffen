<template>
    <Editor id="tinymce" v-model="inputValue" :init="editorInit"></Editor>
</template>

<script lang="ts">
import { defineComponent, computed } from "vue";
import Editor from "@tinymce/tinymce-vue";
import tinymce from "tinymce/tinymce";
import "tinymce/themes/silver/theme";

export default defineComponent({
    components: {
        Editor
    },
    props: {
        value: String
    },
    setup(props, { emit }) {
        const inputValue = computed({
            get: () => props.value,
            set: value => emit("update:value", value)
        });

        tinymce.init({});
        const editorInit = {
            selector: "textarea",
            icons_url: "/tinymce/icons/default/icons.js",
            icons: "material",
            language_url: "/tinymce/langs/zh_CN.js",
            language: "zh_CN",
            skin_url: "/tinymce/skins/ui/oxide",
            width: 720,
            height: 500
        };
        return {
            editorInit,
            inputValue
        };
    }
});
</script>

<style lang="less" scoped></style>
