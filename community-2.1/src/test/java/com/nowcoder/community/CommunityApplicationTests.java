package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
//这个注解表示接下来运行的这个类的代码都是以这个类作为配置类，同时这个类也被@SpringBootApplication标识
@ContextConfiguration(classes=CommunityApplication.class)
//如果这个类实现了ApplicationContextAware接口，就表示这个类可以得到spring容器
public class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	//实现这类的方法，spring容器会检测到，当程序运行的时候，spring容器会将自身传进来，这样后面的代码就可以用了
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);
		//这个bean被@Repository标识，这样就可以在启动的时候被spring容器加载到容器中
		// 同时spring容器又被这个类加载进来了，所以可以直接得到这个bean
		//通过类型获取bean的方式不好，因为如果下次想换一个该接口的实现类就要去该类中该代码了
		//AlphaDao alphaDao=applicationContext.getBean(AlphaDao.class);
		//表示得到这个接口实现类中名为AlphaMybatis的类
		AlphaDao alphaDao =applicationContext.getBean("AlphaMybatis",AlphaDao.class);
		System.out.println(alphaDao.select());//这里实现了向上转型，接口调用实现接口类重写的方法
	}
	@Test
	public void testBeanManagement(){
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}
	@Test
    public void testBeanConfig(){
        SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
        System .out.println(simpleDateFormat.format(new Date()));
    }
    //使用这个注解标识，表示将这个类注入到这个属性中
    @Autowired
    private AlphaService alphaService;
	//表示spring容器将AlphaService这个类注入到alphaService这个属性中
	@Autowired
    @Qualifier("AlphaMybatis")
    //因为实现了AlphaDao的接口的类有两个，所以有歧义
    //用Qualifier标识具体是使用哪个类
    private AlphaDao alphaDao;
	@Autowired
    private SimpleDateFormat simpleDateFormat;
	@Test
	public void testDI(){
	    System.out.println(alphaService);
	    System.out.println(alphaDao);
	    System.out.println(simpleDateFormat);
    }
}
