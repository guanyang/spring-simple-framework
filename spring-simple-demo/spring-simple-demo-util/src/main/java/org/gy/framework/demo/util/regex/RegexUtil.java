package org.gy.framework.demo.util.regex;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * 功能描述：正则工具类
 *
 * @author gy
 * @version 1.0.0
 */
public class RegexUtil {

    /**
     * 社会信用代码正则
     */
    public static final String CREDIT_CODE_REGEX = "^([^_IOZSVa-z\\W]{2}\\d{6}[^_IOZSVa-z\\W]{10}|[1-9]\\d{14})$";
    /**
     * 手机号正则
     */
    public static final String MOBILE_PHONE_REGEX = "^1[3456789]\\d{9}$";
    /**
     * 短信验证码正则
     */
    public static final String VERIFY_CODE_REGEX = "^\\d{6}$";
    /**
     * 邮件正则
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * http协议正则
     */
    public static final String HTTP_REGEX = "^(http|https)://.*$";

    private RegexUtil() {
    }


    public static boolean match(String source, String regex) {
        if (StringUtils.isBlank(source) || StringUtils.isBlank(regex)) {
            return false;
        }
        return Pattern.matches(regex, source);
    }

}
