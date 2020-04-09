/**
 * js执行入口
 */


layui.use(["element", "layer", "table"], function () {
    var element = layui.element;

    var table = layui.table;


    var tablere =table.render({
        // elem: '#tableinfo',
        height: 'full-50'
        ,msg:""
        ,url: '' //数据接口
        ,page: true //开启分页
        ,cols: [[
            {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'name', title: '物品名', width:200}
            ,{field: 'amount', title: '数量', width:200, sort: true}
            ,{field: 'date', title: '日期', width:200}
        ]]
        // ,parseData: function(){ //res 即为原始返回的数据
        //     return {
        //         // "id": res.inId, //解析接口状态
        //         // "name": res.inName, //解析提示文本
        //         // "amount": res.inNumber, //解析数据长度
        //         // "date": res.inDate //解析数据列表
        //         "id": "1", //解析接口状态
        //         "name": "2", //解析提示文本
        //         "amount": "3", //解析数据长度
        //         "date": "4" //解析数据列表
        //     };
        // }

    });


    $("#search-bt").on("click", () => {
        var searchTable = $("#searchType1").val();
        var searchType = $("#searchType2").val();
        var searchText = $("#searchText").val();
        let map = {
            "searchTable":searchTable,
            "searchType":searchType,
            "searchText":searchText
        }

        tablere.reload({
            elem: '#tableinfo',
            height: 'full-50',
            url: '/hw/business/search',
            where:{searchTable:searchTable,searchType:searchType,searchText:searchText},
            method:"post"
        });

        //console.log(map.get("searchTable"));
        // $.ajax({
        //     url: "/hw/business/search",
        //     type: "POST",
        //     data: map,
        //     success(data) {
        //         // tablere.reload({
        //         //     elem: '#tableinfo',
        //         //     url: ''
        //         //     ,method:"post"
        //         // });
        //     }
        // });

    });


    $('#in-add').on('click', function(){
        layer.open({
            type: 1,
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $("#add-in-form")
        });
    });

    $('#out-add').on('click', function(){
        layer.open({
            type: 1,
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: $("#add-out-form")
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
        this.urlsearch = this.contextPath + "/business/search"
    }

    /**
     * 初始化
     */
    init() {
        this.bindClick4Button();
        //this.bindSearchButton();
        this.bindAddInButton();
        this.bindAddOutButton();
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

    // bindSearchButton() {
    //
    //     $("#search-bt").on("click", () => {
    //         console.log("search");
    //         var searchType1 = $("#searchType1").val();
    //         var searchType2 = $("#searchType2").val();
    //         var searchText = $("#searchText").val();
    //         let map = {
    //             "searchType1":searchType1,
    //             "searchType2":searchType2,
    //             "searchText":searchText
    //         }
    //         this.$ajax({
    //             // url: "/hw/business/search",
    //             type: "POST",
    //             data: map,
    //             success(data) {
    //
    //                 var tbody = document.getElementById('tbody');
    //                 for(var i = 0 ;i < data.length; i++){
    //                     var row = document.createElement('tr');
    //                     var idCell = document.createElement('td'); //创建第一列id  
    //                     idCell.innerHTML = data[i].inId; //填充数据  
    //                     row.appendChild(idCell); //加入行  ，下面类似  
    //
    //                     var nameCell = document.createElement('td');//创建第二列name  
    //                     nameCell.innerHTML = data[i].inName;
    //                     row.appendChild(nameCell);
    //
    //                     var amountCell = document.createElement('td');//创建第三列job  
    //                     amountCell.innerHTML = data[i].inNumber;
    //                     row.appendChild(amountCell);
    //
    //                     var dateCell = document.createElement('td');//创建第三列job  
    //                     dateCell.innerHTML = data[i].inDate;
    //                     row.appendChild(dateCell);
    //                     tbody.appendChild(row);
    //                 }
    //                 // layer.open({
    //                 //     type: 1,
    //                 //     content: '添加成功！' //这里content是一个普通的String
    //                 // });
    //                 //alert("添加成功");
    //             }
    //         });
    //
    //     });
    // }

    bindAddInButton() {
        $("#add-in-bt").on("click", () => {
            var inName = $("#inName").val();
            var inNumber = $("#inNumber").val();
            var inDate = $("#inDate").val();
            let map = {
                "inName":inName,
                "inNumber":inNumber,
                "inDate":inDate
            }
            this.$ajax({
                url: "/hw/business/add_inProduct",
                type: "POST",
                data: map,
                success(data) {
                    console.log("success");
                }
            });

        });
    }
    bindAddOutButton() {
        $("#add-out-bt").on("click", () => {
            var outName = $("#outName").val();
            var outNumber = $("#outNumber").val();
            var outDate = $("#outDate").val();
            let map = {
                "outName":outName,
                "outNumber":outNumber,
                "outDate":outDate
            }
            this.$ajax({
                url: "/hw/business/add_outProduct",
                type: "POST",
                data: map,
                success(data) {
                    console.log("success");
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