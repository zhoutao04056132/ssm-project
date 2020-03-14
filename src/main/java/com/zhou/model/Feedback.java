package com.zhou.model;

public class Feedback {
    private Integer id;
    private Integer userId;
    private String content;
    private Byte isDeleted;

    public Feedback() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
