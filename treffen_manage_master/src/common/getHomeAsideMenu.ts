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
        name: "历史任务",
        path: "historyTask"
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
        name: "删除职员",
        path: "deleteEmployee"
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
        path: "historyTask"
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
  }
];



export default function getHomeAsideMenu() {
  return menus;
}