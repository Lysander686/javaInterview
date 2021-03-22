package commonUtilPackages;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 使用FastJson将实体对象转换成Json字符串测试类
 */
public class FastJsonApplication {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("张三");
        user.setPassword("");
        user.setMobile(null);

        /**
         * 忽略值为null的属性
         */
        String jsonUser = JSONObject.toJSONString(user, true);
        System.out.println(jsonUser);

        /**
         * 忽略值为null的属性
         */
        jsonUser = JSONObject.toJSONString(user, SerializerFeature.PrettyFormat);
        System.out.println(jsonUser);

        /**
         * 包括值为null的属性
         */
        jsonUser = JSONObject.toJSONString(user, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonUser);
    }

    /**
     * 用户实体类
     */
    public static class User {
        private Long id;
        private String username;
        private String password;
        private String mobile;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

    }

}
