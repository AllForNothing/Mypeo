package cn.tedu.ttms.team.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ttms.common.exception.SaveRuntimeException;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.dao.ProjectDao;
import cn.tedu.ttms.team.dao.TeamDao;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

	@Resource
	private TeamDao teamDao;
	
	@Resource
	private ProjectDao projectDao;
	
	@Override
	public Map<String, Object> findPageObjects(
								String projectName,
								Integer valid, 
								Integer pageCurrent) {
		PageObject pageObject=new PageObject();
		
		//pageObject.setPageSize(3); 不写默认是2,我们在对象中定义的
		pageObject.setPageCurrent(pageCurrent);
		
		//根据startIndex及参数获得当前页数据
		List<Map<String,Object>> list=teamDao.findPageObjects(
								projectName,
								valid,pageObject.getStartIndex(),
								pageObject.getPageSize());
		
		//获得总页数
		int rowCount=teamDao.getRowCount(projectName, valid);
		System.out.println(rowCount);
		
		//设置记录数
		pageObject.setRowCount(rowCount);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		return map;
	}
	
	/**保存团信息*/
	@Override
	public void saveObject(Team team) {
		if(team==null)throw new SaveRuntimeException("保存的信息不能为空");		
		int rows=teamDao.insertObject(team);		
		if(rows==-1)throw new SaveRuntimeException("保存失败");
	}
	
	@Override
	public List<Map<String, Object>> findProjectIdAndNames() {
		return projectDao.findIdAndNames();
	}	
}