<template>
    <div>
        <RecordDescPage v-model:value="dialogVisible" :message="message" />
        <el-table :data="meetings">
            <el-table-column type="expand">
                <template #default="props">
                    <el-form label-position="left" inline class="table-expand">
                        <el-form-item label="会议编号">
                            <span>{{ props.row.meetingId }}</span>
                        </el-form-item>
                        <el-form-item label="会议主题">
                            <span>{{ props.row.recordType }}</span>
                        </el-form-item>
                        <el-form-item label="发布人工号">
                            <span>{{ props.row.userEId }}</span>
                        </el-form-item>
                        <el-form-item label="发布人">
                            <span>{{ props.row.userName }}</span>
                        </el-form-item>
                        <el-form-item label="开始时间">
                            <span>{{ props.row.startTime }}</span>
                        </el-form-item>

                        <el-form-item label="发布人邮箱">
                            <span>{{ props.row.email }}</span>
                        </el-form-item>
                        <el-form-item label="发布人手机">
                            <span>{{ props.row.phone }}</span>
                        </el-form-item>
                        <el-form-item label="发布人职务">
                            <span>{{ props.row.job }}</span>
                        </el-form-item>
                        <el-form-item label="所在部门">
                            <span>{{ props.row.deptName }}</span>
                        </el-form-item>
                        <el-form-item label="部门地址">
                            <span>{{ props.row.deptLocation }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column prop="meetingId" label="会议编号" width="100">
            </el-table-column>
            <el-table-column prop="startTime" label="开始时间">
            </el-table-column>

            <el-table-column prop="recordType" label="会议主题">
            </el-table-column>
            <el-table-column prop="userName" label="发布人"> </el-table-column>
            <el-table-column
                prop="deptName"
                label="所在部门"
                width="100"
                filter-placement="bottom-end"
            >
                <template #default="scope">
                    <el-tag disable-transitions>{{
                        scope.row.deptName
                    }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column fixed="right" label="查看会议内容" width="120">
                <template #default="scope">
                    <el-button
                        size="small"
                        @click="showRow(scope.row.meetingId)"
                    >
                        查看详情
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref } from "vue";
import request from "@/common/utils/request";
import RecordDescPage from "@/components/meeting/RecordDescPage.vue";

interface Meeting {
    userName: string;
    userEId: string;
    job: string;
    phone: string;
    deptName: string /* 所在部门 */;
    deptLocation: string;
    email: string;
    startTime: Date;
    endTime: Date;
    recordType: string;
    meetingId: number;
}

interface Filter {
    text: string;
    value: string;
}

export default defineComponent({
    components: {
        RecordDescPage
    },
    setup() {
        const meetings = reactive<Meeting[]>([]);
        const dialogVisible = ref(false);
        const message = ref("");

        // 先获取 List
        request
            .get("/api/meeting/getAllStartMeeting")
            .then(res => {
                for (const iterator of res.data.data) {
                    meetings.push(iterator);
                }
            })
            .catch(error => {
                console.error(error);
            });

        function showRow(meetingId: number) {
            console.log(meetingId);
            request
                .get(`/api/meeting/getMeeting/${meetingId}`)
                .then(res => {
                    message.value = res.data.data.recordDesc;
                    dialogVisible.value = true;
                })
                .catch(error => {
                    console.error(error);
                });
        }

        return { meetings, showRow, dialogVisible, message };
    }
});
</script>

<style lang="less" scoped>
.table-expand {
    font-size: 0;

    .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }

    /deep/ label {
        width: 90px;
        color: #99a9bf;
    }
}

/deep/ .el-table td,
.el-table th.is-leaf {
    border-bottom: none !important;
}

/deep/ .el-table__row {
    background-color: #ddffd4 !important;
}
</style>
