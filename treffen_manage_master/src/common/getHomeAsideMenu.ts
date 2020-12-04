const menus = [
  {
    name: "个人中心",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "当前任务",
        path: "/currentTask",
        icon: "el-icon-user-solid"
      },
      {
        name: "历史任务",
        path: "/historyTask",
        icon: "el-icon-user-solid"
      },
      {
        name: "周报",
        path: "/weekSummary",
        icon: "el-icon-user-solid"
      },
      {
        name: "个人资料",
        path: "/personal",
        icon: "el-icon-user-solid"
      },
      {
        name: "统计",
        path: "/myStat",
        icon: "el-icon-user-solid"
      }
    ]
  },
  {
    name: "人员管理",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "录入职员",
        path: "/addEmployee",
        icon: "el-icon-user-solid"
      },
      {
        name: "删除职员",
        path: "/deleteEmployee",
        icon: "el-icon-user-solid"
      },
      {
        name: "修改职员信息",
        path: "/updateEmployee",
        icon: "el-icon-user-solid"
      }
    ]
  },
  {
    name: "搜索资料",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "搜索职员",
        path: "/searchEmployee",
        icon: "el-icon-user-solid"
      },
      {
        name: "搜索周报",
        path: "/searchWeekSummary",
        icon: "el-icon-user-solid"
      },
      {
        name: "搜索会议",
        path: "/searchMeeting",
        icon: "el-icon-user-solid"
      },
      {
        name: "搜索任务",
        path: "/searchTask",
        icon: "el-icon-user-solid"
      }
    ]
  },
  {
    name: "任务系统",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "分组管理",
        path: "/groupManageGroup",
        icon: "el-icon-user-solid"
      },
      {
        name: "任务管理",
        path: "/TasksManage",
        icon: "el-icon-user-solid"
      },
      {
        name: "职员任务",
        path: "/employeeTask",
        icon: "el-icon-user-solid"
      },
      {
        name: "历史任务",
        path: "/historyTask",
        icon: "el-icon-user-solid"
      }
    ]
  },
  {
    name: "会议管理",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "创建会议",
        path: "/createMeeting",
        icon: "el-icon-user-solid"
      },
      {
        name: "修改会议",
        path: "/updateMeeting",
        icon: "el-icon-user-solid"
      },
      {
        name: "审核会议",
        path: "/checkMeeting",
        icon: "el-icon-user-solid"
      },
      {
        name: "历史会议",
        path: "/historyMeeting",
        icon: "el-icon-user-solid"
      }
    ]
  },
  {
    name: "通知系统",
    icon: "el-icon-user-solid",
    subMenus: [
      {
        name: "发起通知",
        path: "/createMessage",
        icon: "el-icon-user-solid"
      },
      {
        name: "历史通知",
        path: "/historyMessage",
        icon: "el-icon-user-solid"
      }
    ]
  }
];


// 因为是根据权限的动态菜单，所以需要一个设计模式来组织菜单和子菜单，这里使用 “组合模式”（CompositePattern）
abstract class SubMenuComponent {
  public name: string;
  public icon: string;
  public path: string;
  constructor(name: string, icon: string, path: string) {
    this.name = name;
    this.icon = icon;
    this.path = path;
  }

  public abstract add(c: SubMenuComponent): void;
  public abstract remove(c: SubMenuComponent): void;
  public abstract display():
    | { name: string; icon: string; path: string }
    | Array<SubMenuComponent>;
}

class SubMenuLeaf extends SubMenuComponent {
  public add(c: SubMenuComponent): void {
    console.error("Cannot add to a leaf");
  }
  public remove(c: SubMenuComponent): void {
    console.error("Cannot remove to a leaf");
  }
  public display(): { name: string; icon: string; path: string } {
    return {
      name: this.name,
      icon: this.icon,
      path: this.path
    };
  }
}

class SubMenuComposite extends SubMenuComponent {
  private components: Array<SubMenuComponent> = [];

  public add(c: SubMenuComponent): void {
    this.components.push(c);
  }
  public remove(c: SubMenuComponent): void {
    // ts 里面没有 Remove 方法，所以需要使用 Filter 代替
    this.components.filter(item => item !== c);
  }
  public display(): Array<SubMenuComponent> {
    return this.components;
  }
}

