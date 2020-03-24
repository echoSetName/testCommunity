package com.example.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"为选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录，请登录后重试"),
    SYSTEM_ERROR(2004, "服务冒烟了，要不你等下试试！"),
    TYPE_PARAW_WRONG(2005,"评论类型错误或者不存在"),
    COMMENT_NOT_FOUND(2006, "你回复的评论不存在了，要不换一个试试？"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空"),
    READ_NOTFICATION_FAIL(2008, "兄弟，你这是读别人信息呢？"),
    NOTFICATION_NOT_FOUND(2009, "信息莫非是不翼而飞了？");

    @Override
    public String getMessage() {
        return message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
