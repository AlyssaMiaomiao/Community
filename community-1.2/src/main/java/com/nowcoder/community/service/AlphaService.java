package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype")
//spring中，默认被spring容器管理的bean是单例的，就是@Scope("Singleton")
// 如果不想单例，就设置成@Scope("prototype")，这样每次运行就会创建一个新的
public class AlphaService {
    @Autowired
    @Qualifier("AlphaMybatis")
    private AlphaDao alphaDao; //因为通常代码中业务层依赖于dao层，所以将dao层注入到业务层
    public AlphaService(){
        System.out.println("实例化AlphaService");
    }
    @PostConstruct
    //被这个注解标识表示这个方法在构造方法之后执行
    public void init(){
        System.out.println("初始化AlphaService");
    }
    @PreDestroy
    //被这个注解标识表示在这个类销毁之前执行
    public void destory(){
        System.out.println("销毁AlphaService");
    }
    public String find(){
        return alphaDao.select();
    }
}
