/**
 * 前端发送请求公共方法工具类
 * @author zhenghong 2018-01-27 22:01:23
 * @version 1.0
 */

/**
 * 发送请求：向后端发送页面请求
 * @param url 请求地址
 * @param async 同步或者异步  默认异步
 * @param callBack 回调方法
 */
function sendRequest1(url, async, callBack) {
    return sendRequest("POST", "application/json", url, [], "json", async, callBack);
}

/**
 * 发送请求：向后端发送页面请求
 * @param url 请求地址
 * @param data 请求报文
 * @param async 同步或者异步  默认异步
 * @param callBack 回调方法
 */
function sendRequest2(url, data, async, callBack) {
    return sendRequest("POST", "application/json", url, data, "json", async, callBack);
}

/**
 * 发送请求：向后端发送页面请求
 * @param type  请求类型（GET,POST,DELETE等）
 * @param contentType   内容类型（网络文件类型和网页编码）
 * @param url   请求地址
 * @param data  请求报文
 * @param dataType  返回报文类型（xml,json等）
 * @param async 是否采用异步通信模式
 */
function sendRequest(type, contentType, url, data, dataType, async, callBack) {
    $.ajax({
        type: type,
        contentType: contentType,//指定返回类型
        url: url,//请求地址
        data: data,
        cache: false,  //禁用缓存
        dataType: dataType,//预期返回数据类型
        async: async,
        success: function (responseData) {
            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
            callBack(responseData);
        },
        error: function () {
            toastr.error("服务器没有返回数据，可能服务器忙，请重试！");
        }
    });
}