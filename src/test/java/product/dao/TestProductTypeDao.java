package product.dao;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.tedu.ttms.product.dao.ProductTypeDao;
import cn.tedu.ttms.product.entity.ProductType;
import common.dao.TestBaseDao;

public class TestProductTypeDao extends TestBaseDao{

	@Test
	public void testFindObjects(){
		ProductTypeDao typeDao=(ProductTypeDao)ctx.getBean("productTypeDao");
		List<Map<String,Object>> list=typeDao.findObjects();
		System.out.println(list);
		Assert.assertNotEquals(null, list);
	}
	
	@Test
	public void testInsertObject(){
		ProductTypeDao typeDao=(ProductTypeDao)ctx.getBean("productTypeDao");
		ProductType t1=new ProductType();
		
		t1.setName("快乐游学");
		t1.setSort(3);
		t1.setParentId(136);
		t1.setNote("快乐游学....");
		t1.setCreatedUser("admin");
		t1.setModifiedUser("admin");
		
		int rows=typeDao.insertObject(t1);
		Assert.assertEquals(1, rows);
	}
	
	@Test
	public void testUpdateObject(){
		ProductTypeDao typeDao=(ProductTypeDao)ctx.getBean("productTypeDao");
		Map<String,Object> map=typeDao.findObjectById(142);		
		ProductType type=new ProductType();
		type.setId((Integer)map.get("id"));
		
		type.setName("华北地区");
		type.setNote("华北地区.....");
		
		type.setParentId(141);//必须在id这一列存在
		int rows=typeDao.updateObject(type);
	    Assert.assertEquals(1, rows);
	}	
}