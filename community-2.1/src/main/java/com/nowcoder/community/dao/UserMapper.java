package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //根据id查询用户信息
    User selectById(int id);
    //根据用户名查用户信息
    User selectByName(String username);
    //根据邮箱查用户信息
    User selectByEmail(String email);
    //插入用户
    int insertUser(User user);
    //更新用户信息
    int updateUser(User user);
    //更新用户状态
    int updateStatus(int id,int status);
    //更新用户头像
    int updateHeader(int id,String headerUrl);
    //修改用户密码
    int updatePassword(int id,String password);

}
