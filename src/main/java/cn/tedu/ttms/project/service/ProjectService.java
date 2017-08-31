package cn.tedu.ttms.project.service;
import java.util.List;
import java.util.Map;

import cn.tedu.ttms.common.web.PageObject;
import cn.tedu.ttms.project.entity.Project;
public interface ProjectService {
  List<Project> findObjects();
  /**返回分页记录
   * 1)记录信息
   * 2)分页信息
   */
  Map<String,Object> findPageObjects(Project project,PageObject pageObject);
  
  /**
   * 启用禁用记录
   * @param checkedIds
   * @param valid
   */
  void  validById(String checkedIds,Integer valid);
  
  void  saveObject(Project project);
  
  /**根据id查找project对象*/
  Project findObjectById(Integer id);
  
  /**修改项目信息*/
  void updateObject(Project project);
  
}




