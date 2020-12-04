
// 因为是根据权限的动态菜单，所以需要一个设计模式来组织菜单和子菜单，这里使用 “组合模式”（CompositePattern）
export abstract class SubMenuComponent {
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

export class SubMenuLeaf extends SubMenuComponent {
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

export class SubMenuComposite extends SubMenuComponent {
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

