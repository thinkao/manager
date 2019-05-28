package com.wxy.pojo;

import java.util.Random;
import java.util.UUID;

public class UploadUtils {
    /**
     * 获取文件真实名称
     * 由于浏览器的不同获取的名称可能为:c:/upload/1.jpg或者1.jpg
     * 最终获取的为  1.jpg
     * @param name 上传上来的文件名称
     * @return 真实名称
     */
    public static String getRealName(String name) {
        //获取最后一个"/"
        int index = name.lastIndexOf("\\");
        return name.substring(index + 1);
    }

    /**
     * 获取随机名称
     *
     * @param realName 真实名称
     * @return uuid 随机名称
     */
    public static String getUUIDName(String realName) {
        //realname  可能是  1sfasdf.jpg   也可能是 1sfasdf 1
        //获取后缀名
        int index = realName.lastIndexOf(".");
        if (index == -1) {
            return UUID.randomUUID().toString().replace("-", "").toUpperCase();
        } else {
            return UUID.randomUUID().toString().replace("-", "").toUpperCase() + realName.substring(index);
        }
    }


    /**
     * 获取文件目录,可以获取256个随机目录
     * @return 随机目录
     */
    public static String getDir() {
        String s = "0123456789ABCDEF";
        Random r = new Random();
        // /A/A
        return "/" + s.charAt(r.nextInt(16)) + "/" + s.charAt(r.nextInt(16));
    }
}