package com.nowcoder.community.dao;

<<<<<<< HEAD
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public MysqlxDatatypes.Scalar.String select() {
=======
import org.springframework.stereotype.Repository;

@Repository("AlphaHibernate")
//被这个注解标识，spring容器会自动扫描这个类到容器中
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
        return "Hibernate";
    }
}
