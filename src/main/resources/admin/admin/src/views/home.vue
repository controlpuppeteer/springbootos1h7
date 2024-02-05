<template>
<div class="content">
	<div class="text" :style='{"margin":"50px auto","fontSize":"34px","color":"#012c7a","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"0 0 20px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"border":"1px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('huiyuan','首页总数')">
				<div :style='{"width":"160px","borderRadius":"5px 0px 0px 5px","background":"#1b5a90","height":"120px"}'></div>
				<div :style='{"width":"180px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#333","fontWeight":"bold","height":"24px"}'>{{huiyuanCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>会员总数</div>
				</div>
			</div>
			<div :style='{"border":"1px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('yuangong','首页总数')">
				<div :style='{"width":"160px","borderRadius":"5px 0px 0px 5px","background":"#1b5a90","height":"120px"}'></div>
				<div :style='{"width":"180px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#333","fontWeight":"bold","height":"24px"}'>{{yuangongCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>员工总数</div>
				</div>
			</div>
			<div :style='{"border":"1px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('kefangxinxi','首页总数')">
				<div :style='{"width":"160px","borderRadius":"5px 0px 0px 5px","background":"#1b5a90","height":"120px"}'></div>
				<div :style='{"width":"180px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#333","fontWeight":"bold","height":"24px"}'>{{kefangxinxiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>客房信息总数</div>
				</div>
			</div>
			<div :style='{"border":"1px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('kefangyuding','首页总数')">
				<div :style='{"width":"160px","borderRadius":"5px 0px 0px 5px","background":"#1b5a90","height":"120px"}'></div>
				<div :style='{"width":"180px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#333","fontWeight":"bold","height":"24px"}'>{{kefangyudingCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>客房预订总数</div>
				</div>
			</div>
			<div :style='{"border":"1px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('canyinyuding','首页总数')">
				<div :style='{"width":"160px","borderRadius":"5px 0px 0px 5px","background":"#1b5a90","height":"120px"}'></div>
				<div :style='{"width":"180px","alignItems":"center","flexDirection":"column","justifyContent":"center","display":"flex"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#333","fontWeight":"bold","height":"24px"}'>{{canyinyudingCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>餐饮预定总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: ;margin: 0 10px;" v-if="isAuth('huiyuan','首页统计')">
                <div id="huiyuanChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: ;margin: 0 10px;" v-if="isAuth('yuangong','首页统计')">
                <div id="yuangongChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: ;margin: 0 10px;" v-if="isAuth('kefangxinxi','首页统计')">
                <div id="kefangxinxiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: ;margin: 0 10px;" v-if="isAuth('kefangxinxi','首页统计')">
                <div id="kefangxinxiChart2" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: ;margin: 0 10px;" v-if="isAuth('kefangyuding','首页统计')">
                <div id="kefangyudingChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: ;margin: 0 10px;" v-if="isAuth('canyinyuding','首页统计')">
                <div id="canyinyudingChart1" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//6
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
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
    this.yuangongChat1();
    this.getkefangxinxiCount();
    this.kefangxinxiChat1();
    this.kefangxinxiChat2();
    this.getkefangyudingCount();
    this.kefangyudingChat1();
    this.getcanyinyudingCount();
    this.canyinyudingChat1();
  },
  methods:{
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
                option = {
                    title: {
                        text: '会员人数',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
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

    yuangongChat1() {
      this.$nextTick(()=>{

        var yuangongChart1 = echarts.init(document.getElementById("yuangongChart1"),'macarons');
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
                option = {
                        title: {
                            text: '员工人数',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
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
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                yuangongChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    yuangongChart1.resize();
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

    kefangxinxiChat1() {
      this.$nextTick(()=>{
        // kefanghao kefanghao
        //  jiage

        var kefangxinxiChart1 = echarts.init(document.getElementById("kefangxinxiChart1"),'macarons');
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
                option = {
                    title: {
                        text: '客房价格',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                        areaStyle: {},
                        smooth: true
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                kefangxinxiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    kefangxinxiChart1.resize();
                };
            }
        });
      })
    },

    kefangxinxiChat2() {
      this.$nextTick(()=>{

        var kefangxinxiChart2 = echarts.init(document.getElementById("kefangxinxiChart2"),'macarons');
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
                option = {
                    title: {
                        text: '客房类型',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'value'
                    },
                    yAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                kefangxinxiChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    kefangxinxiChart2.resize();
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

    kefangyudingChat1() {
      this.$nextTick(()=>{
        //  zongjia
        // yudingshijian yudingshijian

        var kefangyudingChart1 = echarts.init(document.getElementById("kefangyudingChart1"),'macarons');
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
                option = {
                    title: {
                        text: '客房日销额',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                kefangyudingChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    kefangyudingChart1.resize();
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

    canyinyudingChat1() {
      this.$nextTick(()=>{
        //  zongjia
        // xiadanshijian xiadanshijian

        var canyinyudingChart1 = echarts.init(document.getElementById("canyinyudingChart1"),'macarons');
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
                option = {
                    title: {
                        text: '餐饮日销额',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                        areaStyle: {}
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                canyinyudingChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    canyinyudingChart1.resize();
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
</style>
