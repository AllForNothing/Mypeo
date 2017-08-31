package cn.tedu.ttms.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;
import cn.tedu.ttms.project.service.ProjectService;
/**
 * 产品项目管理控制器对象
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Resource
	private ProjectService projectService;
	
	@RequestMapping("/listUI")
	public String listUI(){
		return "project/project_list";
	}
	
	@RequestMapping("/editUI")
	public String editUI(){
		return "project/project_edit";
	}
	
	@RequestMapping("/findPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Project project,PageObject pageObject){
		Map<String,Object> map= projectService.findPageObjects(project,pageObject);
	    return new JsonResult(map);
	}
	
	/**启用禁用*/
	@RequestMapping("/doValidById")
	@ResponseBody
	public JsonResult doValidById(String checkedIds,Integer valid){
		projectService.validById(checkedIds, valid);
		return new JsonResult();
	}
	
	/**保存项目信息*/
	@RequestMapping("/doSaveProject")
	@ResponseBody
	public JsonResult doSaveProject(Project project){
		projectService.saveObject(project);
		return new JsonResult();
	}
	
	/**查找项目信息*/
	@RequestMapping("/doFindById")
	@ResponseBody
	public JsonResult doFindProjectById(Integer id){
	    Project project=projectService.findObjectById(id);
		return new JsonResult(project);
	}
	
	/**修改项目信息*/
	@RequestMapping("/doUpdateProject")
	@ResponseBody
	public JsonResult doUpdateProject(Project project){
		projectService.updateObject(project);
		return new JsonResult();
	}
}



