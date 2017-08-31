package common.dao;

import org.junit.Assert;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSessionFactory {
	
	@Test
	public void testSessionFty(){	
		ApplicationContext ctx=new ClassPathXmlApplicationContext(
									"spring-mvc.xml",
									"spring-pool.xml",
									"spring-mybatis.xml");		
		Object bean=ctx.getBean("sqlSessionFactory");		
		System.out.println(bean);		
		Assert.assertNotEquals(null, bean);		
	}
}