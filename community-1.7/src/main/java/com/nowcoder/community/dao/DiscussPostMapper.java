package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
<<<<<<< HEAD

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);

=======
@Mapper
public interface DiscussPostMapper {
    //这里主要是用于写分页的查询方法
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    int selectDiscussPostRows(@Param("userId") int userId);
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
}
