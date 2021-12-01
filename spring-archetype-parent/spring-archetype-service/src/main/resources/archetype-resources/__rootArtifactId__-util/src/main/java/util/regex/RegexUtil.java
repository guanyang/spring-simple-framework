#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util.regex;

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
    public static final String CREDIT_CODE_REGEX = "^([^_IOZSVa-z${symbol_escape}${symbol_escape}W]{2}${symbol_escape}${symbol_escape}d{6}[^_IOZSVa-z${symbol_escape}${symbol_escape}W]{10}|[1-9]${symbol_escape}${symbol_escape}d{14})${symbol_dollar}";
    /**
     * 手机号正则
     */
    public static final String MOBILE_PHONE_REGEX = "^1[3456789]${symbol_escape}${symbol_escape}d{9}${symbol_dollar}";
    /**
     * 短信验证码正则
     */
    public static final String VERIFY_CODE_REGEX = "^${symbol_escape}${symbol_escape}d{6}${symbol_dollar}";
    /**
     * 邮件正则
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(${symbol_escape}${symbol_escape}.[a-zA-Z0-9_-]+)+${symbol_dollar}";

    /**
     * http协议正则
     */
    public static final String HTTP_REGEX = "^(http|https)://.*${symbol_dollar}";

    private RegexUtil() {
    }


    public static boolean match(String source, String regex) {
        if (StringUtils.isBlank(source) || StringUtils.isBlank(regex)) {
            return false;
        }
        return Pattern.matches(regex, source);
    }

}
