package com.changhong.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Jack Wang
 * Date: 16-2-26
 * Time: 上午10:20
 */
public class CHValidationUtils {

    public static boolean isRightIPAddress(String ipAddress) {
        if (ipAddress.length() < 7 || ipAddress.length() > 15 || "".equals(ipAddress)) {
            return false;
        }
        /**
         * 判断IP格式和范围
         */
        String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pat = Pattern.compile(rexp);
        Matcher mat = pat.matcher(ipAddress);
        boolean ip = mat.find();
        return ip;
    }
}
