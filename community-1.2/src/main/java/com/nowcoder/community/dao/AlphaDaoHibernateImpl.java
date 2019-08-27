package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("AlphaHibernate")
//被这个注解标识，spring容器会自动扫描这个类到容器中
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
