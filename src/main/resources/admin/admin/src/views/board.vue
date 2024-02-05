<template>
<div class="content box6" :style='{"alignContent":"flex-start","minHeight":"100vh","flexWrap":"wrap","background":"#180312","display":"flex","width":"100%","position":"relative","height":"auto"}'>
	<!-- 标题 -->
	<div :style='{"margin":"0 0 20px 0","color":"#fff","textAlign":"center","background":"rgba(255,255,255,.1)","width":"100%","lineHeight":"64px","fontSize":"28px","height":"64px"}'>欢迎使用 {{this.$project.projectName}}</div>
	<!-- 时间 -->
	<div :style='{"top":"0","color":"#666","display":"inline-block","lineHeight":"64px","fontSize":"16px","position":"absolute","right":"20px","height":"64px"}' class="times">{{ dates }}</div>
	<!-- 系统简介 -->
	<div :style='{"padding":"20px","margin":"0 1% 20px 3%","flexWrap":"wrap","background":"rgba(255,255,255,.1)","display":"flex","width":"66%","height":"200px"}'>
		<el-carousel :style='{"width":"300px","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="160px" autoplay="false" interval="3000" loop="true">
			<el-carousel-item :style='{"borderRadius":"10px","width":"100%","height":"100%"}'>
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture1" :src="$base.url+ systemIntroductionDetail.picture1" fit="cover"></el-image>
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture2" :src="$base.url+ systemIntroductionDetail.picture2" fit="cover"></el-image>
				<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' v-if="systemIntroductionDetail.picture3" :src="$base.url+ systemIntroductionDetail.picture3" fit="cover"></el-image>
			</el-carousel-item>
		</el-carousel>
		<div :style='{"margin":"0 0 0 20px","lineHeight":"1.5","fontSize":"16px","color":"#fff","flex":1}' v-html="systemIntroductionDetail.content"></div>
	</div>
	<!-- 统计 -->
	<div :style='{"alignContent":"flex-start","padding":"20px","margin":"0 3% 20px 1%","flexWrap":"wrap","background":"rgba(255,255,255,.1)","display":"flex","width":"26%","height":"200px"}'>

		<div :style='{"width":"100%","alignItems":"center","background":"rgba(255,255,255,.1)","justifyContent":"center","display":"flex"}'>
			<div :style='{"width":"32px","background":"red","height":"32px"}'></div>
			<div :style='{"padding":"0 20px","alignItems":"center","flex":"1","justifyContent":"space-between","display":"flex"}'>
				<div :style='{"lineHeight":"32px","fontSize":"16px","color":"#fff","height":"32px"}'>会员总数</div>
				<div :style='{"lineHeight":"32px","fontSize":"20px","color":"#fff","fontWeight":"bold","height":"32px"}'>{{huiyuanCount}}</div>
			</div>
		</div>


		<div :style='{"width":"100%","alignItems":"center","background":"rgba(255,255,255,.2)","justifyContent":"center","display":"flex"}'>
			<div :style='{"width":"32px","background":"yellow","height":"32px"}'></div>
			<div :style='{"padding":"0 20px","alignItems":"center","flex":"1","justifyContent":"space-between","display":"flex"}'>
				<div :style='{"lineHeight":"32px","fontSize":"16px","color":"#fff","height":"32px"}'>员工总数</div>
				<div :style='{"lineHeight":"32px","fontSize":"20px","color":"#fff","fontWeight":"bold","height":"32px"}'>{{yuangongCount}}</div>
			</div>
		</div>


		<div :style='{"width":"100%","alignItems":"center","background":"rgba(255,255,255,.1)","justifyContent":"center","display":"flex"}'>
			<div :style='{"width":"32px","background":"red","height":"32px"}'></div>
			<div :style='{"padding":"0 20px","alignItems":"center","flex":"1","justifyContent":"space-between","display":"flex"}'>
				<div :style='{"lineHeight":"32px","fontSize":"16px","color":"#fff","height":"32px"}'>客房信息总数</div>
				<div :style='{"lineHeight":"32px","fontSize":"20px","color":"#fff","fontWeight":"bold","height":"32px"}'>{{kefangxinxiCount}}</div>
			</div>
		</div>


		<div :style='{"width":"100%","alignItems":"center","background":"rgba(255,255,255,.2)","justifyContent":"center","display":"flex"}'>
			<div :style='{"width":"32px","background":"yellow","height":"32px"}'></div>
			<div :style='{"padding":"0 20px","alignItems":"center","flex":"1","justifyContent":"space-between","display":"flex"}'>
				<div :style='{"lineHeight":"32px","fontSize":"16px","color":"#fff","height":"32px"}'>客房预订总数</div>
				<div :style='{"lineHeight":"32px","fontSize":"20px","color":"#fff","fontWeight":"bold","height":"32px"}'>{{kefangyudingCount}}</div>
			</div>
		</div>


		<div :style='{"width":"100%","alignItems":"center","background":"rgba(255,255,255,.1)","justifyContent":"center","display":"flex"}'>
			<div :style='{"width":"32px","background":"red","height":"32px"}'></div>
			<div :style='{"padding":"0 20px","alignItems":"center","flex":"1","justifyContent":"space-between","display":"flex"}'>
				<div :style='{"lineHeight":"32px","fontSize":"16px","color":"#fff","height":"32px"}'>餐饮预定总数</div>
				<div :style='{"lineHeight":"32px","fontSize":"20px","color":"#fff","fontWeight":"bold","height":"32px"}'>{{canyinyudingCount}}</div>
			</div>
		</div>

	</div>

            <div class="echarts1">
                <div id="huiyuanChart1" style="width:100%;height:100%;"></div>
            </div>
            <div class="echarts2">
                <div id="yuangongChart2" style="width:100%;height:100%;"></div>
            </div>
            <div class="echarts3">
                <div id="kefangxinxiChart3" style="width:100%;height:100%;"></div>
            </div>
            <div class="echarts4">
                <div id="kefangxinxiChart4" style="width:100%;height:100%;"></div>
            </div>
            <div class="echarts5">
                <div id="kefangyudingChart5" style="width:100%;height:100%;"></div>
            </div>
            <div class="echarts6">
                <div id="canyinyudingChart6" style="width:100%;height:100%;"></div>
            </div>
</div>


</template>
<script>
import * as echarts from 'echarts'
//5
//6
import router from '@/router/router-static'
export default {
	data() {
		return {
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#ccc","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"rgb(255,255,255)","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"symbol":"emptyCircle","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"showSymbol":true,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"","shadowBlur":0,"width":2,"type":"solid","opacity":1,"shadowColor":"#000"},"symbolSize":4},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#ccc","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#fff","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00ff00","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"rgb(255,255,255)","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"}},
			pie: {"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#fff","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#fff","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#fff","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#fff","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
            systemIntroductionDetail: {},
			dates: '',
            huiyuanCount: 0,
            yuangongCount: 0,
            kefangxinxiCount: 0,
            kefangyudingCount: 0,
            canyinyudingCount: 0,
		};
	},
  mounted(){
    this.init();
    this.gethuiyuanCount();
    this.huiyuanChat1();
    this.getyuangongCount();
    this.yuangongChat2();
    this.getkefangxinxiCount();
    this.kefangxinxiChat3();
    this.kefangxinxiChat4();
    this.getkefangyudingCount();
    this.kefangyudingChat5();
    this.getcanyinyudingCount();
    this.canyinyudingChat6();
  },
  created() {
    this.$nextTick(()=>{
		this.times()
	})
  },
  methods:{
    getTimeStrToDay(game_over_timestamp) {
        if (game_over_timestamp == 0)
            return "";
        var date = new Date(parseInt(game_over_timestamp));
        var now = new Date();
        var hours = date.getHours() >= 10 ? date.getHours().toString() : "0" + date.getHours();
        var minutes = date.getMinutes() >= 10 ? date.getMinutes().toString() : "0" + date.getMinutes();
        var seconds = date.getSeconds() >= 10 ? date.getSeconds().toString() : "0" + date.getSeconds();
        let arr = ["日", "一", "二", "三", "四", "五", "六"];
        let d = arr[date.getDay()]
        return date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + '日' + ' ' + ' ' + '星期' + d  + ' ' + "  " + hours + ":" + minutes + ":" + seconds
    },
	times() {
		setInterval(()=>{
            let date = new Date().getTime()
            this.dates = this.getTimeStrToDay(date)
		}, 1000)
	},
	filterTime(time) {
	  const date = new Date(time)
	  const Y = date.getFullYear()
	  const M = date.getMonth() + 1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1 
	  const D = date.getDate() < 10 ? '0' + date.getDate() : date.getDate()
	  
	  const H = date.getHours() < 10 ? '0' + date.getHours() : date.getHours() // 小时
	  const I = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes() // 分钟
	  const S = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds() // 秒
	  
	  return `${Y}-${M}-${D} ${H}:${I}:${S}`
	},
    getSystemIntroduction() {
        this.$http({
            url: `systemintro/detail/1`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.systemIntroductionDetail = data.data
            }
        })
    },
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
        this.getSystemIntroduction();
    },
    gethuiyuanCount() {
        this.$http({
            url: `huiyuan/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.huiyuanCount = data.data
            }
        })
    },

//统计接口1
    huiyuanChat1() {
      this.$nextTick(()=>{

        var huiyuanChart1 = echarts.init(document.getElementById("huiyuanChart1"),'macarons');
        this.$http({
            url: "huiyuan/group/xingbie",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].xingbie);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xingbie
                    })
                }
                var option = {};
				let titleObj = this.bar.title
				titleObj.text = '会员人数'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'category'
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
                        data: yAxis,
                        type: 'bar'
                    }
				seriesObj = Object.assign(seriesObj , this.bar.series)

                option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
                    title: titleObj,
					legend: legendObj,
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
                    },
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                huiyuanChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    huiyuanChart1.resize();
                };
            }
        });
      })
    },










    getyuangongCount() {
        this.$http({
            url: `yuangong/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.yuangongCount = data.data
            }
        })
    },

//统计接口1
    yuangongChat2() {
      this.$nextTick(()=>{

        var yuangongChart2 = echarts.init(document.getElementById("yuangongChart2"),'macarons');
        this.$http({
            url: "yuangong/group/xingbie",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].xingbie);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xingbie
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '员工人数'
				
				const legendObj = this.pie.legend
				
				let seriesObj = {
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				
                option = {
					backgroundColor: this.pie.backgroundColor,
					color: this.pie.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c} ({d}%)'
					},
					series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                yuangongChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    yuangongChart2.resize();
                };
            }
        });
      })
    },










    getkefangxinxiCount() {
        this.$http({
            url: `kefangxinxi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.kefangxinxiCount = data.data
            }
        })
    },

//统计接口1
    kefangxinxiChat3() {
      this.$nextTick(()=>{
        // kefanghao kefanghao
        //  jiage

        var kefangxinxiChart3 = echarts.init(document.getElementById("kefangxinxiChart3"),'macarons');
        this.$http({
            url: `kefangxinxi/value/kefanghao/jiage`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].kefanghao);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].kefanghao
                    })
                }
                var option = {};
				let titleObj = this.line.title
				titleObj.text = '客房价格'
				
				const legendObj = this.line.legend
				
				let xAxisObj = this.line.xAxis
				xAxisObj.type = 'category'
				xAxisObj.boundaryGap = false
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.line.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
					data: yAxis,
					type: 'line',
					areaStyle: {},
					smooth: true
				}
				seriesObj = Object.assign(seriesObj , this.line.series)
				
                option = {
					backgroundColor: this.line.backgroundColor,
					color: this.line.color,
                    title: titleObj,
					legend: legendObj,
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
                    },
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                kefangxinxiChart3.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    kefangxinxiChart3.resize();
                };
            }
        });
      })
    },

//统计接口2
    kefangxinxiChat4() {
      this.$nextTick(()=>{

        var kefangxinxiChart4 = echarts.init(document.getElementById("kefangxinxiChart4"),'macarons');
        this.$http({
            url: "kefangxinxi/group/kefangleixing",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].kefangleixing);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].kefangleixing
                    })
                }
                var option = {};
                let titleObj = this.bar.title
				titleObj.text = '客房类型'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'value'
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'category'
				yAxisObj.data = xAxis
				
				let seriesObj = {
						data: yAxis,
						type: 'bar'
					}
				seriesObj = Object.assign(seriesObj , this.bar.series)

				option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
					title: titleObj,
					legend: legendObj,
					tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
					},
					xAxis: xAxisObj,
					yAxis: yAxisObj,
					series: [seriesObj]
				};
                // 使用刚指定的配置项和数据显示图表。
                kefangxinxiChart4.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    kefangxinxiChart4.resize();
                };
            }
        });
      })
    },




















    getkefangyudingCount() {
        this.$http({
            url: `kefangyuding/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.kefangyudingCount = data.data
            }
        })
    },

//统计接口1
    kefangyudingChat5() {
      this.$nextTick(()=>{
        //  zongjia
        // yudingshijian yudingshijian

        var kefangyudingChart5 = echarts.init(document.getElementById("kefangyudingChart5"),'macarons');
        this.$http({
            url: `kefangyuding/value/yudingshijian/zongjia/日`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].yudingshijian);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].yudingshijian
                    })
                }
                var option = {};
				let titleObj = this.bar.title
				titleObj.text = '客房日销额'
				
				const legendObj = this.bar.legend
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'category'
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
                        data: yAxis,
                        type: 'bar'
                    }
				seriesObj = Object.assign(seriesObj , this.bar.series)

                option = {
					backgroundColor: this.bar.backgroundColor,
					color: this.bar.color,
                    title: titleObj,
					legend: legendObj,
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
                    },
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                kefangyudingChart5.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    kefangyudingChart5.resize();
                };
            }
        });
      })
    },










    getcanyinyudingCount() {
        this.$http({
            url: `canyinyuding/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.canyinyudingCount = data.data
            }
        })
    },

//统计接口1
    canyinyudingChat6() {
      this.$nextTick(()=>{
        //  zongjia
        // xiadanshijian xiadanshijian

        var canyinyudingChart6 = echarts.init(document.getElementById("canyinyudingChart6"),'macarons');
        this.$http({
            url: `canyinyuding/value/xiadanshijian/zongjia/日`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].xiadanshijian);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xiadanshijian
                    })
                }
                var option = {};
				let titleObj = this.line.title
				titleObj.text = '餐饮日销额'
				
				const legendObj = this.line.legend
				
				let xAxisObj = this.line.xAxis
				xAxisObj.type = 'category'
				xAxisObj.boundaryGap = false
				xAxisObj.data = xAxis
                xAxisObj.axisLabel.rotate=70
				
				let yAxisObj = this.line.yAxis
				yAxisObj.type = 'value'
				
				let seriesObj = {
					data: yAxis,
					type: 'line',
					areaStyle: {}
				}
				seriesObj = Object.assign(seriesObj , this.line.series)
				
                option = {
					backgroundColor: this.line.backgroundColor,
					color: this.line.color,
                    title: titleObj,
					legend: legendObj,
                    tooltip: {
						trigger: 'item',
						formatter: '{b} : {c}'
                    },
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                canyinyudingChart6.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    canyinyudingChart6.resize();
                };
            }
        });
      })
    },























































































  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	

	.box6 .echarts1 {
				padding: 20px;
				margin: 0 1% 20px 3%;
				background: rgba(255,255,255,.1);
				width: 30%;
				transition: 0.3s;
				height: 294px;
			}
	.box6 .echarts2 {
				padding: 20px;
				margin: 0 1% 20px 1%;
				background: rgba(255,255,255,.1);
				width: 30%;
				transition: 0.3s;
				height: 294px;
			}
	.box6 .echarts3 {
				padding: 20px;
				margin: 0 3% 20px 1%;
				background: rgba(255,255,255,.1);
				width: 30%;
				transition: 0.3s;
				height: 294px;
			}
	.box6 .echarts4 {
				padding: 20px;
				margin: 0 1% 20px 3%;
				background: rgba(255,255,255,.1);
				width: 30%;
				transition: 0.3s;
				height: 294px;
			}
	.box6 .echarts5 {
				padding: 20px;
				margin: 0 1% 20px 1%;
				background: rgba(255,255,255,.1);
				width: 30%;
				transition: 0.3s;
				height: 294px;
			}
	.box6 .echarts6 {
				padding: 20px;
				margin: 0 3% 20px 1%;
				background: rgba(255,255,255,.1);
				width: 30%;
				transition: 0.3s;
				height: 294px;
			}
	
	.box6 .echarts1:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 1% 20px 3%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 30%;
				position: relative;
				height: 294px;
			}
	.box6 .echarts2:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 1% 20px 1%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 30%;
				position: relative;
				height: 294px;
			}
	.box6 .echarts3:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 3% 20px 1%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 30%;
				position: relative;
				height: 294px;
			}
	.box6 .echarts4:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 1% 20px 3%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 30%;
				position: relative;
				height: 294px;
			}
	.box6 .echarts5:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 1% 20px 1%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 30%;
				position: relative;
				height: 294px;
			}
	.box6 .echarts6:hover {
				border-radius: 8px;
				padding: 20px;
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				margin: 0 3% 20px 1%;
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
				width: 30%;
				position: relative;
				height: 294px;
			}




</style>
