/**
 * js执行入口
 */


layui.use(["element", "layer"], function () {
    let demo = new Demo();
    demo.init();
});


import Constants from "./constants.js";
class Demo {
    constructor() {
        this.contextPath = this.getContextPath();
        this.url = this.contextPath + "/business/userList"
    }

    /**
     * 初始化
     */
    init() {
        this.bindClick4Button();
    }
    /**
     * 给按钮绑定点击事件
     */
    bindClick4Button() {
        $("#demo-button").on("click", () => {
            this.$ajax({
                url: this.url,
                type: "GET",
                data: {},
                success(data) {
                    let res = JSON.stringify(data);
                    $(".demo").text(res);
                    let router = Constants.ROUTER;
                    $(".demo").text(res + "--------" + JSON.stringify(router));
                }
            });

        });
    }


    /**
     * ajax定义
     *      可以只传路径或只传ajax参数配置
     * @param url 请求路径
     * @param options ajax参数配置
     */
    $ajax(url) {
        let _this = this;
        let options = {};
        if ( typeof url === "object" ) {
            options = url;
        }
        //设置默认值
        options.type = options.type || "GET";
        options.dataType = options.dataType || "json";
        options.success = options.success || function(data) {
            _this.showMessage(data);
        };
        //调用jq ajax
        return $.ajax(options);
    }

    /**
     * 获取应用上下文
     * @returns {string}
     */
    getContextPath(){
        let pathName = window.document.location.pathname;
        let contextPath = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        return contextPath;
    }
}