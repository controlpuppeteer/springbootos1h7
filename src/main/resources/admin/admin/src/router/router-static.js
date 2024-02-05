import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Board from '@/views/board'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import yuangong from '@/views/modules/yuangong/list'
    import kefangyuding from '@/views/modules/kefangyuding/list'
    import aboutus from '@/views/modules/aboutus/list'
    import ruzhudengji from '@/views/modules/ruzhudengji/list'
    import kefangxinxi from '@/views/modules/kefangxinxi/list'
    import jiudiancanyin from '@/views/modules/jiudiancanyin/list'
    import huiyuan from '@/views/modules/huiyuan/list'
    import canyinyuding from '@/views/modules/canyinyuding/list'
    import tuifangdengji from '@/views/modules/tuifangdengji/list'
    import systemintro from '@/views/modules/systemintro/list'
    import chat from '@/views/modules/chat/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '酒店资讯',
        component: news
      }
      ,{
	path: '/yuangong',
        name: '员工',
        component: yuangong
      }
      ,{
	path: '/kefangyuding',
        name: '客房预订',
        component: kefangyuding
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/ruzhudengji',
        name: '入住登记',
        component: ruzhudengji
      }
      ,{
	path: '/kefangxinxi',
        name: '客房信息',
        component: kefangxinxi
      }
      ,{
	path: '/jiudiancanyin',
        name: '酒店餐饮',
        component: jiudiancanyin
      }
      ,{
	path: '/huiyuan',
        name: '会员',
        component: huiyuan
      }
      ,{
	path: '/canyinyuding',
        name: '餐饮预定',
        component: canyinyuding
      }
      ,{
	path: '/tuifangdengji',
        name: '退房登记',
        component: tuifangdengji
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/chat',
        name: '在线咨询',
        component: chat
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/board',
    name: 'board',
    component: Board,
    meta: {icon:'', title:'board'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
