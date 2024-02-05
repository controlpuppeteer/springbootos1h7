const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootos1h7/",
            name: "springbootos1h7",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootos1h7/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于spark的酒店管理系统"
        } 
    }
}
export default base
