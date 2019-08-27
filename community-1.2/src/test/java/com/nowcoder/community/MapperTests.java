package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//这个注解表示接下来运行的这个类的代码都是以这个类作为配置类，同时这个类也被@SpringBootApplication标识
@ContextConfiguration(classes=CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser(){
        User user =userMapper.selectById(101);
        System.out.println(user);
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user=userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list=discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost i:list){
            System.out.println(i);
        }
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
        rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
