package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DiscussPostMapper {
    //这里主要是用于写分页的查询方法
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    int selectDiscussPostRows(@Param("userId") int userId);
}
