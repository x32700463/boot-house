package com.etoak.bean;

import lombok.Data;

@Data
public class Email {
   //邮件主题
    private String subject;
    //收件人
    private String receiver;
    //邮箱
    private String content;
}
