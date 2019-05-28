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
            url: '/appController/getAppInfo',   //请求后台的URL（*）
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
                field: 'appNameEn',
                title: '应用英文名'
            }, {
                field: 'appNameCn',
                title: '应用中文名'
            }, {
                field: 'appGroup',
                title: '应用分组'
            }, {
                field: 'appStatus',
                title: '应用状态',formatter:function(value,row,index){
                	if (value == '0'){
                		return '初始';
                	}
                	if (value == '1'){
                		return '运行';
                	}
                	if (value == '2'){
                		return '停止';
                	}
                	if (value == '3'){
                		return '运行';
                	}
                	if (value == '9'){
                		return '已删除';
                	}
                	return '状态未定义';
                }
            }, {
                field: 'serverIP',
                title: '服务器IP'
            }, {
                field: 'serverPort',
                title: '服务器端口'
            }, {
                field: 'serverUser',
                title: '脚本执行用户'
            }, {
                field: 'updateDate',
                title: '更新日期'
            }, {
                field: 'remark',
                title: '备注'
            },
            {
                field: 'operate',
                title: '脚本',
                events:operateEvents,
                formatter:AddFunctionAlty
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
            $("#appModalLabel").text("新增应用");
            $("#appModal").find(".form-control").val("");
            $("#div_isUpdateFlag").hide();
            $("#div_serverPassword").css('display', 'block');
            $("#txt_appNameEn").attr('readonly', false);
            $("#appModal").modal({backdrop: 'static', keyboard: false});
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
            $("#appModalLabel").text("编辑");
            $("#txt_appNameEn").val(arrselections[0].appNameEn);
            $("#txt_appNameEn").attr('readonly', true);
            $("#txt_appNameCn").val(arrselections[0].appNameCn);
            $("#txt_appStatus").val(arrselections[0].appStatus);
            $("#txt_appGroup").val(arrselections[0].appGroup);
            $("#txt_remark").val(arrselections[0].remark);
            $("#txt_serverIP").val(arrselections[0].serverIP);
            $("#txt_serverPort").val(arrselections[0].serverPort);
            $("#txt_serverUser").val(arrselections[0].serverUser);
//            $("#txt_serverPassword").hide();
//            $("#txt_serverPassword").val("");
//            $("#txt_serverPassword").attr('placeholder', '默认不修改密码');
//            $("#txt_serverPassword").attr('disabled', true);
            $("#div_isUpdateFlag").css('display', 'block');
            $("#div_serverPassword").hide();
            $("#isUpdateFlag").attr('checked', false);
            $("#appModal").modal({backdrop: 'static', keyboard: false})
        });
        $("#btn_delete").click(function () {
            var arrselections = $("#queryResult").bootstrapTable('getSelections');
            if (arrselections.length <= 0) {
                toastr.warning('请选择有效数据');
                return;
            }
            var appNameEns = '';
            for (var i = 0; i < arrselections.length; i++) {
            	appNameEns = appNameEns +","+arrselections[i].appNameEn;
            }

            bootbox.confirm("确认要删除选择的数据吗？", function (result) {
                if(result == true) {
                    // bootbox.alert("OK");
                    $.ajax({
                        type: "post",
                        url: "/appController/deleteAppInfo",
                        data: {"appNameEns": appNameEns},
                        success: function (data) {
                            var dataObj = JSON.parse(data);
                            var resultFlag = dataObj.success;
                            if (resultFlag) {
                                toastr.success('数据删除成功');
                                $("#appModal").modal('hide');
                                $("#queryResult").bootstrapTable('refresh');
                            } else {
                                toastr.error(dataObj.msg);
                            }
                        },
                        error: function () {
                            toastr.error('Error');
                        }
                    });
                }
                else{
                    // bootbox.alert("cancel");
				}
            });
        });
        //新增，编辑窗口的保存按钮事件
        $("#btn_submit").click(function (qualifiedName) {
        	var appParam = {};
        	var submitFlag = true;
        	appParam.appNameEn = document.getElementById("txt_appNameEn").value;
        	if(appParam.appNameEn.length<1){
        		 toastr.warning("请输入应用英文名");
        		 submitFlag = false;
            }
        	appParam.appNameCn = document.getElementById("txt_appNameCn").value;
        	appParam.appGroup = document.getElementById("txt_appGroup").value;
        	appParam.remark = document.getElementById("txt_remark").value;
        	appParam.serverIP = document.getElementById("txt_serverIP").value;
        	if(appParam.serverIP.length<1){
        		toastr.warning("请输入服务器IP");
        		submitFlag = false;
            }
        	appParam.serverPort = document.getElementById("txt_serverPort").value;
        	appParam.serverUser = document.getElementById("txt_serverUser").value;
        	if(appParam.serverUser.length<1){
        		toastr.warning("请输入执行脚本用户");
        		submitFlag = false;
            }
        	appParam.serverPassword = document.getElementById("txt_serverPassword").value;
        	if(appParam.serverPassword.length<1){
        		toastr.warning("请输入执行脚本用户对应密码");
        		submitFlag = false;
            }
            appParam.isUpdateFlag = document.getElementById("isUpdateFlag").value;
        	/*var f = document.getElementById("txt_appNameEn").getAttribute('readonly');
        	alert(f);*/
        	if (submitFlag){
        		var flag = document.getElementById("txt_appNameEn").getAttribute('readonly');
        		if (flag){
		            $.ajax({
		                type: "post",
		                url: "/appController/updateAppInfo",
		                data: {"appParam": JSON.stringify(appParam)},
		                success: function (data) {
		                	var dataObj = JSON.parse(data);
		                	var resultFlag = dataObj.success;
		                	if (resultFlag){
		                		 toastr.success('修改数据成功');
		                		 $("#appModal").modal('hide'); 
		                         $("#queryResult").bootstrapTable('refresh');
		                	}else{
		                		toastr.error(dataObj.msg);
		                	}
		                },
		                error: function (data) {
		                    toastr.error('请求服务失败');
		                }
		            });
                    document.getElementById("txt_appNameEn").setAttribute(" ");
        		}else{
        			 $.ajax({
 		                type: "post",
 		                url: "/appController/addAppInfo",
 		                data: {"appParam": JSON.stringify(appParam)},
 		                success: function (data) {
 		                	var dataObj = JSON.parse(data);
 		                	var resultFlag = dataObj.success;
 		                	if (resultFlag){
 		                		 toastr.success('新增数据成功');
 		                		 $("#appModal").modal('hide'); 
 		                         $("#queryResult").bootstrapTable('refresh');
 		                	}else{
 		                		toastr.error(dataObj.msg);
 		                	}
 		                },
 		                error: function (data) {
 		                    toastr.error('请求服务失败');
 		                }
 		            });
        		}
        	}
        });
    };
    return oInit;
};

function clickPasswdUpdateFlag(checkbox){
	if (checkbox.checked == true){
		$("#div_serverPassword").css('display', 'block');
	}else{
		$("#div_serverPassword").hide();
	 
	}
	 
};

function AddFunctionAlty(value,row,index){
	return[
		'<button id="scriptEdit" type="button" class="btn btn-default">设置</button>'
	].join("")
};
//脚本-新增一行
$('#btn_add_script').click(function(){
    var data = { "appNameEn": $("#script_appNameEn").val(), "scriptType": "","scriptPath": "path" };
    console.log(data);
    $('#scriptTable').bootstrapTable('append',data);    
});

//脚本-编辑
function EditScriptFunction(value,row,index){
	return[
		'<button id="btn_edit_script" type="button" class="glyphicon glyphicon-ok"/>'
	].join("")
};
window.editScriptEvents={
	"click #btn_edit_script":function(e,value,row,index){
//		console.log("click #btn_edit_script");
			$.ajax({
				type: "post",
                url: "/scriptController/editScript",
                data: {"appNameEn": row.appNameEn,"scriptType":row.scriptType,"scriptPath":row.scriptPath},
                success: function (data) {
                	var dataObj = JSON.parse(data);
		            var resultFlag = dataObj.success;
		            if (resultFlag){
		                toastr.success('编辑脚本成功');
//		                $("#scriptModal").modal('hide'); 
		                $("#scriptTable").bootstrapTable('refresh');
		            }else{
		                toastr.error(dataObj.msg);
		            }
                },
		        error: function (data) {
		            toastr.error('请求服务失败');
		        }
          });
	}
}

//脚本-删除
function DeleteScriptFunction(value,row,index){
//	console.log(JSON.stringify(row));
	return[
		'<button id="btn_delete_script" type="button" '+
//		'onclick="deleteScriptEvents(\''+index+'\')" '+
		'class="glyphicon glyphicon-remove"/>'
	].join("")
};

window.deleteScriptEvents={
		"click #btn_delete_script":function(e,value,row,index){
//function deleteScriptEvents(index){
//			console.log("click #btn_delete_script");
//	console.log(row.scriptType);
			toastr.success(row.scriptType);
			
	bootbox.confirm("确认要删除选择的数据吗？", function (result) {
		if(result == true){
		$.ajax({
	    type: "post",
	    url: "/scriptController/deleteScript",
	    data: {"appNameEn": row.appNameEn,"scriptType":row.scriptType},
	    success: function (data) {
 		                	var dataObj = JSON.parse(data);
 		                	var resultFlag = dataObj.success;
 		                	if (resultFlag){
 		                		 toastr.success('删除脚本成功');
// 		                		 $("#scriptModal").modal('hide'); 
 		                         $("#scriptTable").bootstrapTable('refresh');
 		                         $("#scriptTable").bootstrapTable('refresh');
 		                	}else{
 		                		toastr.error(dataObj.msg);
 		                	}
 		                },
 		                error: function (data) {
 		                    toastr.error('请求服务失败');
 		                }
	                })};
	            });
		}
}

window.operateEvents={
		"click #scriptEdit":function(e,value,row,index){
            $("#scriptModalLabel").text("执行脚本");
            $("#scriptModal").find(".form-control").val("");
            $("#script_appNameEn").val(row.appNameEn);
            $("#scriptModal").modal({backdrop: 'static', keyboard: false});
            //每次点击重新生成表格
            $("#scriptTable").bootstrapTable('destroy'); 
            $('#scriptTable').bootstrapTable({
        	    url:"/scriptController/getScriptInfo",//请求数据url
        	    queryParams: function (params) {
//        	    	console.log($("#script_appNameEn").val());
        	        return {
        	        	appNameEn:$("#script_appNameEn").val()
        	        };
        	    },
        	    clickToSelect: true,
        	    sortName : 'scriptType',
        	    sortOrder : 'asc',
        	    uniqueId: 'rowNum',
        	    columns: [
        	    	{
        	            checkbox: true,
        	            width : '5%',
        	        },
        	        {
        	            field: 'rowNum',//域值
        	            title: '行号',//标题
        	            formatter: function (value, row, index) {
                            return index;
                        },
        	            visible: false,//false表示不显示
        	        },
        	    	{
        	            field: 'appNameEn',//域值
        	            title: '应用名称',//标题
        	            visible: false,//false表示不显示
        	        },
        	        {
        	            field: 'scriptType',//域值
        	            title: '类型',//内容
//        	            editable:true,
//        	            sortable: true,//启用排序
        	            editable:{
            	            type:'select',//下拉框
//            	            url:'./index.php?r=dictionary/dictionaryInfo&type='+"run",
            	            source:[{value:'start',text:'启动'},{value:'stop',text:'停止'}
                                , {value:'detectPort',text:'探测端口'}, {value:'detectProcess',text:'探测进程'}
            	            // , {value:'restart',text:'重启'},{value:'onDetect',text:'开启探测'},
            	            // 	{value:'offDetect',text:'关闭探测'}
            	            	],
            	            disabled: false,  //是否禁用编辑
            	            emptytext: "请选择",
//            	            onSelect:function(val,rec){
//            	            	console.log(val,rec);
//            	            	val=rec;
//            	            }
        	            },
        	            width : '25%',
        	        },
        	        {
        	            field: 'scriptPath',//域值
        	            title: '脚本',//内容
        	            editable:true,
        	            visible: true,//false表示不显示
        	            width : '50%',
        	        },
        	        {
                        field: 'scriptEdit',
                        title: '确认',
                        events:editScriptEvents,
                        formatter:EditScriptFunction,
                        width : '10%',
                    },
        	        {
                        field: 'scriptDelete',
                        title: '删除',
                        events:deleteScriptEvents,
                        formatter:DeleteScriptFunction,
                        width : '10%',
                    }
        	    ],
//        	    onEditableSave:function (field, row, oldValue, $el) {
//        			        $table = $('#scriptTable').bootstrapTable({});
//        			        console.log(field);
//        			        console.log(row);
//        			        console.log(oldValue);
//        			        $table.bootstrapTable('updateRow', {index: row.rowId, row: row});
//        				}
        		});
        }
};

