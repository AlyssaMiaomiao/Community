package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.util.CommunityConstant;
import com.nowcoder.community.util.CommunityUnit;
import com.nowcoder.community.util.MailClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class UserService implements CommunityConstant {
    @Autowired
    private UserMapper userMapper;
    //因为要给用户发送邮件激活账户，所以要注入发邮件要用的类
    @Autowired
    private MailClient mailClient;
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${community.path.domain}")
    private String domain;

    public User findUserById(int id){
        return userMapper.selectById(id);
    }

    public Map<String,Object> register(User user){
        Map<String,Object> map=new HashMap<>();
        if(user==null){
            throw new IllegalArgumentException("参数不能为空");
        }
        if(StringUtils.isBlank(user.getUsername())){
            map.put("usernameMsg","账号不能为空");
            return map;
        }
        if(StringUtils.isBlank(user.getPassword())){
            map.put("passwordMsg","密码不能为空");
            return map;
        }
        if(StringUtils.isBlank(user.getEmail())){
            map.put("emailMsg","邮箱不能为空");
            return map;
        }
        User u=userMapper.selectByName(user.getUsername());
        if(u!=null){
            map.put("usernameMsg","该账号已存在");
            return map;
        }
        u=userMapper.selectByEmail(user.getEmail());
        if(u!=null){
            map.put("emailMsg","该邮箱已经被注册");
            return map;
        }
        //如果上面的都验证之后，就可以注册用户了
        user.setSalt(CommunityUnit.generateUUID().toString().substring(0,5));
        //对密码和salt加密
        user.setPassword(CommunityUnit.md5(user.getPassword()+user.getSalt()));
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(CommunityUnit.generateUUID());
        user.setHeaderUrl(String.format("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)));
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        //用户注册成功之后，要给用户发邮件，让用户激活账户
        Context context =new Context();
        context.setVariable("email",user.getEmail());
        //设置激活的路径的格式
        //http://localhost:8080/community/activation/101/code
        String url=domain+contextPath+"/activation/"+user.getId()+"/"+user.getActivationCode();
        //System.out.println(url);
        context.setVariable("url",url);
        String content=templateEngine.process("/mail/activation",context);
        mailClient.sendMail(user.getEmail(),"激活账户",content);
        return map;
    }
    //这个方法给用户激活
    public int activation(int userId,String code){
        //首先判断用户是否存在
        User user=userMapper.selectById(userId);
        if(user.getStatus()==1){
            return ACTIVATION_REPEAT;//重复激活
            //判断激活码是否正确
        }else if(user.getActivationCode().equals(code)){
            userMapper.updateStatus(userId,1);//根据用户id修改用户的status=1，表示用户激活了
            return ACTIVATION_SUCCESS;
        }else{
            return ACTIVATION_FAILURE;
        }

    }
}


