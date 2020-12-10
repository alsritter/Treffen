import request from "@/common/utils/request"

/**
 * 取得菜单内容
 */
export default async function getHomeAsideMenu() {
  // 因为存进去的是 json
  let menus = localStorage.getItem("menus");
  if(menus != null) {
    return Promise.resolve(JSON.parse(menus));
  }
  
  await request
  .get("/api/utils/getMenu")
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