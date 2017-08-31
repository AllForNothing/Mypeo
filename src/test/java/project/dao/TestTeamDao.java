package project.dao;


import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.team.dao.TeamDao;
import cn.tedu.ttms.team.entity.Team;
import common.dao.TestBaseDao;

public class TestTeamDao extends TestBaseDao{
	@Test
	public void testFindPageObjects(){
		TeamDao dao=(TeamDao)ctx.getBean("teamDao");
		String projectName="北京马拉松";
		Integer valid=1;
		int startIndex=0;
		int pageSize=2;
		List<Map<String,Object>> list=dao.findPageObjects(
							projectName,
							valid,
							startIndex,
							pageSize);
		System.out.println("list="+list);
		Assert.assertNotEquals(null, list);
		System.out.println("list.size="+list.size());
		
		//根据条件获得记录数,然后计算总页数
		int rowCount=dao.getRowCount(projectName, valid);
		PageObject pageObject=new PageObject();
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);		
		Assert.assertEquals(1,pageObject.getPageCount());//当前我的数据库中就1页数据		
		System.out.println("pageCount="+pageObject.getPageCount());
	}
	
	@Test
	public void testInsertObject(){
		TeamDao dao=(TeamDao)ctx.getBean("teamDao");
		Team t1=new Team();
		
		t1.setName("北京马拉松6日团");
		t1.setProjectId(15);//必须是项目表中有的一个id
		t1.setValid(1);
		t1.setNote("北京马拉松6日团....");
		t1.setCreatedUser("admin");
        t1.setModifiedUser("admin");	
        
		int rows=dao.insertObject(t1);
		Assert.assertEquals(1, rows);
	}
}