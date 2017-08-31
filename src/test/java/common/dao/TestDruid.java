package common.dao;



import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDruid {
	
	@Test
	public void testDruid(){
		//1.获得ApplicationContext对象
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-pool.xml");
		
		//2.获得DataSource对象
		DataSource dataSource=(DataSource)ctx.getBean("dataSource");
	    System.out.println("dataSource="+dataSource);
	    
		//3.测试数据源对象是否为空
	    Assert.assertNotEquals(null, dataSource);
	}
}



