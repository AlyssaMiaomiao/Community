package com.nowcoder.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUnit {
    //生成随机字符串
    //使用UUID生成一个随机的字符串，但是字符串会包含数组，字母和-，所以将所有的-替换成空串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
    //对字符串进行MD5加密
    public static String md5(String key){
        if(StringUtils.isBlank(key)) {//如果字符串为null，空串，空格，都判断为空
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());//加密之后返回一个16字符的字符串，但是要求参数是byte类型的
    }
}
