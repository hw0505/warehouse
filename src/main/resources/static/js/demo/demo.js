/**
 * js执行入口
 */


layui.use(["element", "layer", "table"], function () {
    var element = layui.element;

    var table = layui.table;

    //第一个实例
    table.render({
        elem: '#demo'
        ,height: 312
        ,url: '/hw/business/table' //数据接口
        ,page: true //开启分页
        ,cols: [[
            {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'name', title: '物品名', width:80}
            ,{field: 'number', title: '数量', width:80, sort: true}
            ,{field: 'date', title: '日期', width:80}
        ]]
    });

    $('#in-add').on('click', function(){
        layer.open({
            type: 1,
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: '\<\div style="padding:20px;"><form class="layui-form" action="">\n' +
                '  <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">货物名称</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入货物名称" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>\n' +
                '  <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">货物数量</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入货物数量" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>\n' +
                '  <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">日期</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入日期" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>\n' +
                '  <div class="layui-form-item">\n' +
                '    <div class="layui-input-block">\n' +
                '      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                '      <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                '    </div>\n' +
                '  </div>\n' +
                '</form>\<\/div>'
        });
    });

    $('#out-add').on('click', function(){
        layer.open({
            type: 1,
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: '\<\div style="padding:20px;"><form class="layui-form" action="">\n' +
                '  <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">货物名称</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入货物名称" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>\n' +
                '  <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">货物数量</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入货物数量" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>\n' +
                '  <div class="layui-form-item">\n' +
                '    <label class="layui-form-label">日期</label>\n' +
                '    <div class="layui-input-block">\n' +
                '      <input type="text" name="title" required  lay-verify="required" placeholder="请输入日期" autocomplete="off" class="layui-input">\n' +
                '    </div>\n' +
                '  </div>\n' +
                '  <div class="layui-form-item">\n' +
                '    <div class="layui-input-block">\n' +
                '      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>\n' +
                '      <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
                '    </div>\n' +
                '  </div>\n' +
                '</form>\<\/div>'
        });
    });
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

        this.testPost();
    }

    testPost() {
        debugger;
        let map = {
            "name": "test",
            "id": "test"
        };
        this.$ajax({
            url: "/hw/business/postTest",
            type: "POST",
            data: map,
            success(data) {
                let res = JSON.stringify(data);
                $(".demo").text(res);
                let router = Constants.ROUTER;
                $(".demo").text(res + "--------" + JSON.stringify(router));
            }
        });
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