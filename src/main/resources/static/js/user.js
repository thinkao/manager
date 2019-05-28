$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#queryResult').bootstrapTable({
            url: '/userController/userInfor',   //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "account",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'account',
                title: '账号'
            }, {
                field: 'name',
                title: '姓名'
            }, {
                field: 'createdate',
                title: '创建时间'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            searchname: $("#txt_search_name").val()
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
        $("#btn_add").click(function () {
            $("#myModalLabel").text("新增");
            $("#myModal").find(".form-control").val("");
            $("#is_pwd_reset").hide();  //隐藏密码重置按钮
            $("#is_reset").attr('checked', true);
            $('#myModal').modal()
        });

        $("#btn_edit").click(function () {
            var arrselections = $("#queryResult").bootstrapTable('getSelections');
            if (arrselections.length > 1) {
                toastr.warning('只能选择一行进行编辑');
                return;
            }
            if (arrselections.length <= 0) {
                toastr.warning('请选择有效数据');
                return;
            }
            $("#myModalLabel").text("编辑");
            $("#txt_account").val(arrselections[0].account);
            $("#txt_account").attr('readonly', true);
            $("#txt_name").val(arrselections[0].name);
            $("#txt_pwd").attr('readonly', true);
            $("#is_pwd_reset").css('display', 'block'); //显示密码重置按钮
            $("#is_reset").attr('checked', false);
            $('#myModal').modal();
        });

        $("#btn_delete").click(function () {
            var arrselections = $("#queryResult").bootstrapTable('getSelections');
            if (arrselections.length <= 0) {
                toastr.warning('请选择有效数据');
                return;
            }
            bootbox.confirm("确认要删除选择的数据吗？", function (result) {
                $.ajax({
                    type: "post",
                    url: "/userController/userDelete",
                    data: {"postdata": JSON.stringify(arrselections)},
                    success: function (data) {
                        toastr.success('数据删除成功');
                        $("#queryResult").bootstrapTable('refresh');
                    },
                    error: function () {
                        toastr.error('Error');
                    }
                });
            });
        });

        //密码重置复选框事件
        $("#is_reset").click(function () {
            if ($('#is_reset').prop('checked')) {
                $("#txt_pwd").attr('readonly', false);
            } else {
                $("#txt_pwd").attr('readonly', true);
            }
        });
        //新增，编辑窗口的保存按钮事件
        $("#btn_submit").click(function () {
            postdata.account = $("#txt_account").val();
            postdata.name = $("#txt_name").val();
            postdata.pwd = $("#txt_pwd").val();
            if(postdata.account.length<6){
                bootbox.alert("账号长度不少于6位");
                return;
            }
            if(postdata.name.length<1){
                bootbox.alert("请输入姓名");
                return;
            }
            if ($('#is_reset').prop('checked')) {
                if (postdata.pwd.length < 8) {
                    bootbox.alert("密码长度不少于8位");
                    return;
                }
                //密码加密
                postdata.pwd = SHA1("ectl" + postdata.account + SHA1(postdata.pwd));
            }else{
                postdata.pwd="";
            }
            $.ajax({
                type: "post",
                url: "/userController/userSaveOrUpdate",
                data: {"postdata": JSON.stringify(postdata)},
                success: function (data) {
                    toastr.success('提交数据成功');
                    $("#queryResult").bootstrapTable('refresh');
                },
                error: function (data) {
                    toastr.error('Error');
                }
            });
        });
    };
    return oInit;
};