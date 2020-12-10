<template>
    <div>
        <RecordDescPage
            v-model:value="dialogVisible"
            :message="recordDescContent"
        />
        <el-dialog
            title="修改会议内容"
            v-model="editDialogVisible"
            width="760px"
            center
        >
            <TinymceEditor v-model:value="recordDesc" />
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="editDialogVisible = false"
                        >取 消</el-button
                    >
                    <el-button type="primary" @click="changeDesc()"
                        >确 定</el-button
                    >
                </span>
            </template>
        </el-dialog>
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
            <el-table-column fixed="right" label="操作" width="350">
                <template #default="scope">
                    <el-button
                        size="small"
                        @click="showRow(scope.row.meetingId)"
                    >
                        查看详情
                    </el-button>
                    <el-button
                        size="small"
                        type="warning"
                        @click="openChangeDialogVisible(scope.row.meetingId)"
                    >
                        修改会议内容
                    </el-button>
                    <el-button
                        size="small"
                        type="danger"
                        @click="endMeeting(scope.row.meetingId)"
                    >
                        结束会议
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, getCurrentInstance } from "vue";
import request from "@/common/utils/request";
import RecordDescPage from "@/components/meeting/RecordDescPage.vue";
import TinymceEditor from "@/components/TinymceEditor.vue";

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
        RecordDescPage,
        TinymceEditor
    },
    setup() {
        const message = getCurrentInstance()?.appContext.config.globalProperties
            .$message;
        const meetings = reactive<Meeting[]>([]);
        const dialogVisible = ref(false);
        const editDialogVisible = ref(false);
        const recordDescContent = ref("");
        const recordDesc = ref("");
        const currentMeetingId = ref(0);

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
            request
                .get(`/api/meeting/getMeeting/${meetingId}`)
                .then(res => {
                    recordDescContent.value = res.data.data.recordDesc;
                    dialogVisible.value = true;
                })
                .catch(error => {
                    console.error(error);
                });
        }

        function changeDesc() {
            console.log(currentMeetingId.value);
            request
                .put(`/api/meeting/updateMeeting/${currentMeetingId.value}`, {
                    recordDesc: recordDesc.value
                })
                .then(() => {
                    message.success("修改成功");
                    editDialogVisible.value = false;
                })
                .catch(error => {
                    message.error("创建失败");
                    console.error(error);
                    editDialogVisible.value = false;
                });
        }

        function openChangeDialogVisible(meetingId: number) {
            currentMeetingId.value = meetingId;
            editDialogVisible.value = true;
        }

        function endMeeting(meetingId: number) {
            request
                .put(`/api/meeting/endMeeting/${meetingId}`)
                .then(() => {
                    message.success("会议结束");
                    meetings.splice(0, meetings.length);
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
                })
                .catch(error => {
                    message.error("操作失败");
                    console.error(error);
                });
        }

        return {
            meetings,
            endMeeting,
            showRow,
            dialogVisible,
            recordDescContent,
            recordDesc,
            changeDesc,
            editDialogVisible,
            openChangeDialogVisible
        };
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
    background-color: #fafcff !important;
}
</style>
