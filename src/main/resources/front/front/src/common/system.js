export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"会员","menuJump":"列表","tableName":"huiyuan"}],"menu":"会员管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"员工","menuJump":"列表","tableName":"yuangong"}],"menu":"员工管理"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["查看","修改","删除"],"menu":"客房信息","menuJump":"列表","tableName":"kefangxinxi"}],"menu":"客房信息管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","修改"],"menu":"酒店餐饮","menuJump":"列表","tableName":"jiudiancanyin"}],"menu":"酒店餐饮管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除"],"menu":"客房预订","menuJump":"列表","tableName":"kefangyuding"}],"menu":"客房预订管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","删除"],"menu":"餐饮预定","menuJump":"列表","tableName":"canyinyuding"}],"menu":"餐饮预定管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","删除"],"menu":"入住登记","menuJump":"列表","tableName":"ruzhudengji"}],"menu":"入住登记管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","删除"],"menu":"退房登记","menuJump":"列表","tableName":"tuifangdengji"}],"menu":"退房登记管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"酒店资讯","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["查看","修改","删除"],"menu":"在线咨询","tableName":"chat"},{"appFrontIcon":"cuIcon-list","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","客房预订"],"menu":"客房信息列表","menuJump":"列表","tableName":"kefangxinxi"}],"menu":"客房信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","用户点餐","餐饮预定"],"menu":"酒店餐饮列表","menuJump":"列表","tableName":"jiudiancanyin"}],"menu":"酒店餐饮模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除","支付"],"menu":"客房预订","menuJump":"列表","tableName":"kefangyuding"}],"menu":"客房预订管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","删除","支付"],"menu":"餐饮预定","menuJump":"列表","tableName":"canyinyuding"}],"menu":"餐饮预定管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看"],"menu":"入住登记","menuJump":"列表","tableName":"ruzhudengji"}],"menu":"入住登记管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看"],"menu":"退房登记","menuJump":"列表","tableName":"tuifangdengji"}],"menu":"退房登记管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","客房预订"],"menu":"客房信息列表","menuJump":"列表","tableName":"kefangxinxi"}],"menu":"客房信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","用户点餐","餐饮预定"],"menu":"酒店餐饮列表","menuJump":"列表","tableName":"jiudiancanyin"}],"menu":"酒店餐饮模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"会员","tableName":"huiyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除"],"menu":"客房信息","menuJump":"列表","tableName":"kefangxinxi"}],"menu":"客房信息管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除"],"menu":"酒店餐饮","menuJump":"列表","tableName":"jiudiancanyin"}],"menu":"酒店餐饮管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除","审核","入住登记"],"menu":"客房预订","menuJump":"列表","tableName":"kefangyuding"}],"menu":"客房预订管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","删除"],"menu":"餐饮预定","menuJump":"列表","tableName":"canyinyuding"}],"menu":"餐饮预定管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["查看","修改","删除","退房登记"],"menu":"入住登记","menuJump":"列表","tableName":"ruzhudengji"}],"menu":"入住登记管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","修改","删除"],"menu":"退房登记","menuJump":"列表","tableName":"tuifangdengji"}],"menu":"退房登记管理"},{"child":[{"appFrontIcon":"cuIcon-service","buttons":["新增","查看","修改","删除"],"menu":"在线咨询","tableName":"chat"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","客房预订"],"menu":"客房信息列表","menuJump":"列表","tableName":"kefangxinxi"}],"menu":"客房信息模块"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看","用户点餐","餐饮预定"],"menu":"酒店餐饮列表","menuJump":"列表","tableName":"jiudiancanyin"}],"menu":"酒店餐饮模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"员工","tableName":"yuangong"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
