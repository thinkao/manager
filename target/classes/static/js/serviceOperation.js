$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    // 2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#serviceOperation').bootstrapTable({
            url: '/reportController/operationQuery',   //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",//post请求的话就加上这个句话
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            //uniqueId: "tradTime",              //每一行的唯一标识，一般为主键列
            showToggle: false,                  //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表

            showExport: true,  //是否显示导出按钮
            exportTypes: ['excel'],  //导出文件类型
            exportDataType: "all",              //basic', 'all', 'selected'.
            exportOptions: {
                fileName: '服务运行情况表',  //文件名称设置
                tableName: '服务运行情况表'
            },
            columns: [
                {
                    field: 'tradTime',
                    title: '交易日期'
                }, {
                    field: 'tradNum',
                    title: '交易笔数'
                }, {
                    field: 'succNum',
                    title: '交易成功笔数'
                }, {
                    field: 'failNum',
                    title: '交易失败笔数'
                }, {
                    field: 'avgTime',
                    title: '平均响应时间(ms)'
                },{
                    field: 'avgNum',
                    title: '平均并发数'
                },{
                    field: 'maxNum',
                    title: '最大并发数'
                },{
                    field: 'maxTime',
                    title: '单笔交易最大耗时'
                },{
                    field: 'allTime',
                    title: '交易总时间'
                }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            startDate: $("#startDate_input").val(),
            endDate: $("#endDate_input").val()
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
        $("#btn_operationQuery").click(function () {
            var startDate = $("#startDate_input").val();
            if (startDate == null || startDate.length == 0) {
                toastr.warning('起始时间不能为空！');
                return;
            }
            var endDate = $("#endDate_input").val();
            if (endDate == null || endDate.length == 0) {
                toastr.warning('终止时间不能为空！');
                return;
            }
            $("#serviceOperation").bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 10});
        });
    };
    return oInit;
};