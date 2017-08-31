package cn.tedu.ttms.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.exception.SaveRuntimeException;
import cn.tedu.ttms.common.exception.UpdateRuntimeException;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;
/**
 * 项目管理service对象
 * 项目中所有与业务相关的事情一般都要放在service中,例如
 * 1)判定参数是否符合业务要求
 * 2)判定dao返回的数据是否是我们需要的结果
 * 3)执行一些日志的记录
 * 4)执行一些事务的处理
 */
@Service
public class ProjectServiceImpl implements ProjectService{
	@Resource
	private ProjectDao projectDao;
	
	/**获得多条的项目信息*/
	@Override
	public List<Project> findObjects() {
		
		return projectDao.findObjects();
	}
	/**
	 * @param pageObject 用于接收控制层传递过来的分页信息
	 * 1)此参数中应包含startIndex
	 * 2)此参数中应包含pageSize
	 */
	@Override
	public Map<String, Object> 
	findPageObjects(Project project,PageObject pageObject) {
		//1.获得页面表格中要显示的数据
		List<Project> list=projectDao.findPageObjects(project,pageObject);
		
		//2.获得表中记录数并计算页数
		int rowCount=projectDao.getRowCount(project);
		pageObject.setRowCount(rowCount);
		
		//3.构建map对象封装从dao层获得的数据
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);//记录信息
		map.put("pageObject", pageObject);//分页数据
		return map;
	}
	
	@Override
	public void validById(String checkedIds, Integer valid) {
		//判定参数checkedIds
	    if(checkedIds==null||checkedIds.length()==0)
	    throw new NullPointerException(""+ "必须有选中的id值");
	    
	    if(valid!=1&&valid!=0)
	    throw new IllegalArgumentException(""+ "无效valid值");
	    
		//解析字符串(1,2,3,4,5);
		String ids[]=checkedIds.split(",");
		
		//访问dao层方法执行启用禁用的更新操作
		int rows=projectDao.validById(ids,valid);
		if(rows==-1)throw new RuntimeException("更新失败");
	}
	
	@Override
	public void saveObject(Project project) {
		int rows=projectDao.insertObject(project);
	    if(rows==-1)throw new RuntimeException("save error");
	}
	
	@Override
	public Project findObjectById(Integer id) {
		if(id==null)throw new NullPointerException("id can not be null");
		Project pro=projectDao.findObjectById(id);
		if(pro==null)throw new SaveRuntimeException("project does not exists");
		return pro;
	}
	
	@Override
	public void updateObject(Project project) {
		int rows=projectDao.updateObject(project);
		if(rows==-1)//正常情况下应该是1
		//说明在service中写的自定义异常一般都继承RuntimeException
		throw new UpdateRuntimeException("update error");
	}
}





