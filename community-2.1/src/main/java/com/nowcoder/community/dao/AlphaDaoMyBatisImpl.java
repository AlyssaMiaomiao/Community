package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("AlphaMybatis")
//@Primary
//被这个注解标识的类可以被优先调用，如果和其他类由歧义的时候
public class AlphaDaoMyBatisImpl implements AlphaDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
