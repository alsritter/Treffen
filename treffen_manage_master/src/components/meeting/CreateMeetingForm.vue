<template>
    <el-form :model="state" :rules="rules" ref="formRef" label-width="150px">
        <el-form-item label="会议主题" prop="recordType">
            <el-select
                v-model="state.recordType"
                placeholder="请输入会议主题"
                allow-create
                filterable
                default-first-option
            >
                <el-option
                    v-for="item in meetingType"
                    :value="item"
                    :key="item"
                ></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="活动时间" required prop="startTime">
            <el-date-picker
                v-model="state.startTime"
                type="datetime"
                placeholder="选择日期时间"
            >
            </el-date-picker>
        </el-form-item>
        <el-form-item label="输入会议内容" prop="recordDesc">
            <TinymceEditor v-model:value="state.recordDesc" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm">创建</el-button>
            <el-button @click="resetForm">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, getCurrentInstance } from "vue";
import { ElForm } from "element-plus";
import TinymceEditor from "@/components/TinymceEditor.vue";
import request from "@/common/utils/request";

interface RecordState {
    recordType: string;
    recordDesc: string;
    startTime: Date;
}

export default defineComponent({
    components: {
        TinymceEditor
    },
    setup() {
        const message = getCurrentInstance()?.appContext.config.globalProperties
            .$message;
        const formRef = ref<InstanceType<typeof ElForm>>();
        const rules = {
            recordType: [
                { required: true, message: "请输入会议主题", trigger: "blur" },
                {
                    min: 3,
                    max: 5,
                    message: "长度在 3 到 45 个字符",
                    trigger: "blur"
                }
            ],
            startTime: [
                {
                    type: "date",
                    required: true,
                    message: "请选择日期",
                    trigger: "change"
                }
            ]
        };

        const meetingType = [
            "动员大会",
            "工作布置会",
            "经验交流会",
            "总结会",
            "联席会",
            "座谈会",
            "协调会",
            "招商会",
            "贸易洽谈会",
            "销售会议",
            "员工会议",
            "研讨会",
            "答辩会",
            "专题会",
            "庆祝会",
            "表彰会",
            "电话会议",
            "季度安委会会议"
        ];

        const state = reactive({
            recordType: "",
            recordDesc: "",
            startTime: new Date()
        }) as RecordState;

        function resetForm() {
            formRef.value?.resetFields();
        }

        function submitForm() {
            formRef.value?.validate(async valid => {
                if (!valid) {
                    return message.error("请填写好信息");
                }
                request
                    .post("/api/meeting/createMeeting", state)
                    .then(() => {
                        message.success("创建成功");
                    })
                    .catch(error => {
                        message.error("创建失败");
                        console.error(error);
                    });
            });
        }

        return { resetForm, submitForm, rules, formRef, state, meetingType };
    }
});
</script>

<style lang="less" scoped></style>
