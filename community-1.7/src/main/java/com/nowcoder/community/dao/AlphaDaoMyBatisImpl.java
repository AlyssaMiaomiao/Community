package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "MyBatis";
=======
@Repository("AlphaMybatis")
//@Primary
//被这个注解标识的类可以被优先调用，如果和其他类由歧义的时候
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "Mybatis";
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
    }
}
