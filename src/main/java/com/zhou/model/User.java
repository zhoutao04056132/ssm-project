package com.zhou.model;

public class User {
    private long id;
    private String name;
    private String mobile;
    private String realName;

    // 添加一个user表没有的属性，能正常查询，但查询返回时该字段值不会被自动注入，为null
    private String weChat;

    private User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", realName='" + realName + '\'' +
                ", weChat='" + weChat + '\'' +
                '}';
    }
}
