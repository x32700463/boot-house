package com.etoak.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.etoak.bean.Email;
import com.etoak.bean.User;
import com.etoak.execption.ParamException;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;

import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public int addUser(User user) {
        String password = user.getPassword();
        password= DigestUtils.md5Hex(password);
        user.setPassword(password);
        int addResult= userMapper.addUser(user);
        log.info("add User result id -{}",user.getId());
       /* jmsTemplate.send("email",session -> {
            Email email = new Email();
            email.setSubject("用户及或邮件");
            email.setReceiver(user.getEmail());
            email.setContent("请点击激活:http://localhost:8000/boot/user/active/"+ user.getId());

            return session.createTextMessage(JSONObject.toJSONString(email));
        });*/
        return addResult;
    }

    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }


}
