package cn.tedu.ttms.team.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.team.entity.Team;
import cn.tedu.ttms.team.service.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {
	@Resource
    private TeamService teamService;
	
	@RequestMapping("/editUI")
	public String editUI(){
		return "team/team_edit";
	}
	
	@RequestMapping("/listUI")
	public String listUI(){
	   return "team/team_list";
	}
	
	@RequestMapping("/doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String projectName,
			Integer valid,
			Integer pageCurrent){
		        System.out.println("pageCurrent="+pageCurrent);
		        Map<String,Object> map=teamService.findPageObjects(projectName, valid,pageCurrent);		
		return new JsonResult(map);
	}
	
	/**保存团信息*/
	@RequestMapping("/doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Team team){
		teamService.saveObject(team);
		return new JsonResult();
	}
	
	/**查询项目id和名字*/
	@RequestMapping("/doFindPrjIdNames")
	@ResponseBody
	public JsonResult doFindProjectIdAndNames(){
		List<Map<String,Object>> map=teamService.findProjectIdAndNames();
		return new JsonResult(map);
	}
}







