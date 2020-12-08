/**
 * 这里只是备份一下菜单的内容
 */
const menus = [
  {
    name: "个人中心",
    icon: "el-icon-s-home",
    subMenus: [
      {
        name: "当前任务",
        path: "currentTask"
      },
      {
        name: "用户历史任务",
        path: "userHistoryTask"
      },
      {
        name: "周报",
        path: "weekSummary"
      },
      {
        name: "个人资料",
        path: "personal"
      },
      {
        name: "统计",
        path: "myStat"
      }
    ]
  },
  {
    name: "人员管理",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "录入职员",
        path: "addEmployee"
      },
      {
        name: "修改职员信息",
        path: "updateEmployee"
      }
    ]
  },
  {
    name: "搜索资料",
    icon: "el-icon-search",
    subMenus: [
      {
        name: "搜索职员",
        path: "searchEmployee"
      },
      {
        name: "搜索周报",
        path: "searchWeekSummary"
      },
      {
        name: "搜索会议",
        path: "searchMeeting"
      },
      {
        name: "搜索任务",
        path: "searchTask"
      }
    ]
  },
  {
    name: "任务系统",
    icon: "el-icon-s-claim",
    subMenus: [
      {
        name: "分组管理",
        path: "groupManageGroup"
      },
      {
        name: "任务管理",
        path: "tasksManage"
      },
      {
        name: "职员任务",
        path: "employeeTask"
      },
      {
        name: "历史任务",
        path: "allHistoryTask"
      }
    ]
  },
  {
    name: "会议管理",
    icon: "el-icon-data-analysis",
    subMenus: [
      {
        name: "创建会议",
        path: "createMeeting"
      },
      {
        name: "修改会议",
        path: "updateMeeting"
      },
      {
        name: "审核会议",
        path: "checkMeeting"
      },
      {
        name: "历史会议",
        path: "historyMeeting"
      }
    ]
  },
  {
    name: "通知系统",
    icon: "el-icon-message-solid",
    subMenus: [
      {
        name: "发起通知",
        path: "createMessage"
      },
      {
        name: "历史通知",
        path: "historyMessage"
      }
    ]
  },
  {
    name: "删除信息",
    icon: "el-icon-delete-solid",
    subMenus: [
      {
        name: "删除通知",
        path: "deletedMessage"
      },
      {
        name: "删除会议",
        path: "deletedMeeting"
      },
      {
        name: "删除任务",
        path: "deletedTask"
      },
      {
        name: "删除职员",
        path: "deleteEmployee"
      },
    ]
  }
];

import request from "@/common/utils/request"

/**
 * 取得菜单内容
 */
export default async function getHomeAsideMenu() {
  // 因为存进去的是 json
  let menus = localStorage.getItem("menus");
  if(menus != null) {
    return JSON.parse(menus);
  }
  
  await request
  .get("/api/menu/getMenu")
  .then(res => {
    console.log(res.data.data);
    menus = res.data.data;
    localStorage.setItem("menus", JSON.stringify(menus))
  })
  .catch(error => {
      console.log(error);
  });

  return menus;
}