import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import huiyuanList from '../pages/huiyuan/list'
import huiyuanDetail from '../pages/huiyuan/detail'
import huiyuanAdd from '../pages/huiyuan/add'
import yuangongList from '../pages/yuangong/list'
import yuangongDetail from '../pages/yuangong/detail'
import yuangongAdd from '../pages/yuangong/add'
import kefangxinxiList from '../pages/kefangxinxi/list'
import kefangxinxiDetail from '../pages/kefangxinxi/detail'
import kefangxinxiAdd from '../pages/kefangxinxi/add'
import jiudiancanyinList from '../pages/jiudiancanyin/list'
import jiudiancanyinDetail from '../pages/jiudiancanyin/detail'
import jiudiancanyinAdd from '../pages/jiudiancanyin/add'
import kefangyudingList from '../pages/kefangyuding/list'
import kefangyudingDetail from '../pages/kefangyuding/detail'
import kefangyudingAdd from '../pages/kefangyuding/add'
import canyinyudingList from '../pages/canyinyuding/list'
import canyinyudingDetail from '../pages/canyinyuding/detail'
import canyinyudingAdd from '../pages/canyinyuding/add'
import ruzhudengjiList from '../pages/ruzhudengji/list'
import ruzhudengjiDetail from '../pages/ruzhudengji/detail'
import ruzhudengjiAdd from '../pages/ruzhudengji/add'
import tuifangdengjiList from '../pages/tuifangdengji/list'
import tuifangdengjiDetail from '../pages/tuifangdengji/detail'
import tuifangdengjiAdd from '../pages/tuifangdengji/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'huiyuan',
					component: huiyuanList
				},
				{
					path: 'huiyuanDetail',
					component: huiyuanDetail
				},
				{
					path: 'huiyuanAdd',
					component: huiyuanAdd
				},
				{
					path: 'yuangong',
					component: yuangongList
				},
				{
					path: 'yuangongDetail',
					component: yuangongDetail
				},
				{
					path: 'yuangongAdd',
					component: yuangongAdd
				},
				{
					path: 'kefangxinxi',
					component: kefangxinxiList
				},
				{
					path: 'kefangxinxiDetail',
					component: kefangxinxiDetail
				},
				{
					path: 'kefangxinxiAdd',
					component: kefangxinxiAdd
				},
				{
					path: 'jiudiancanyin',
					component: jiudiancanyinList
				},
				{
					path: 'jiudiancanyinDetail',
					component: jiudiancanyinDetail
				},
				{
					path: 'jiudiancanyinAdd',
					component: jiudiancanyinAdd
				},
				{
					path: 'kefangyuding',
					component: kefangyudingList
				},
				{
					path: 'kefangyudingDetail',
					component: kefangyudingDetail
				},
				{
					path: 'kefangyudingAdd',
					component: kefangyudingAdd
				},
				{
					path: 'canyinyuding',
					component: canyinyudingList
				},
				{
					path: 'canyinyudingDetail',
					component: canyinyudingDetail
				},
				{
					path: 'canyinyudingAdd',
					component: canyinyudingAdd
				},
				{
					path: 'ruzhudengji',
					component: ruzhudengjiList
				},
				{
					path: 'ruzhudengjiDetail',
					component: ruzhudengjiDetail
				},
				{
					path: 'ruzhudengjiAdd',
					component: ruzhudengjiAdd
				},
				{
					path: 'tuifangdengji',
					component: tuifangdengjiList
				},
				{
					path: 'tuifangdengjiDetail',
					component: tuifangdengjiDetail
				},
				{
					path: 'tuifangdengjiAdd',
					component: tuifangdengjiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
