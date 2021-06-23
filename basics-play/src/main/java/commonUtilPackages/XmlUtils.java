package commonUtilPackages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* https://blog.csdn.net/weixin_39703170/article/details/79566794 */
public class XmlUtils {
    public static String regex(String xml, String label) {
        String context = "";
        //正则表达式
        String regex = "<" + label + ">(.*?)</" + label + ">";
        Pattern pattern = Pattern.compile(regex);// 匹配的模式
        Matcher m = pattern.matcher(xml);
        //匹配的有多个
        List<String> list = new ArrayList<String>();
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
            i++;
        }
        //只要匹配的第一个
        if (list.size() > 0) {
            context = list.get(0);
        }
        return context;
    }

    public static void main(String[] args) {

    }

    public static void matchTag() {
        String tag = "<\\s*\\w+?\\s*\\/>|<\\w+?><\\/\\w+?>";
        Pattern pattern = Pattern.compile(tag);// 匹配的模式

        Matcher m = pattern.matcher("");

    }
}
