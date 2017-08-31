package cn.tedu.ttms.product.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.ttms.common.web.JsonResult;
import cn.tedu.ttms.product.entity.ProductType;
import cn.tedu.ttms.product.service.ProductTypeService;

@Controller
@RequestMapping("/productType")
public class ProductTypeController{
	@Resource
	private ProductTypeService productTypeService;
	
	@RequestMapping("/editUI")
	public String editUI(){
		return "product/type_edit";
	}
	
	@RequestMapping("/listUI")
	public String listUI(){
		return "product/type_list";
	}
	
    @RequestMapping("/doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<Map<String,Object>> list=productTypeService.findObjects();
		System.out.println("list=="+list);
		return new JsonResult(list);	
    }
    
    @RequestMapping("/doFindTreeNodes")
	@ResponseBody
    public JsonResult doFindTreeNodes(){
    	List<Map<String,Object>> list=productTypeService.findTreeNodes();
    	return new JsonResult(list);   
    }
    
    @RequestMapping("/doSaveObject")
   	@ResponseBody
    public JsonResult doSaveObject(ProductType type){
    	productTypeService.saveObject(type);
    	return new JsonResult();
    }
    @RequestMapping("/doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
    	Map<String,Object> map=productTypeService.findObjectById(id);
    	return new JsonResult(map);
    }
    
    @RequestMapping("/doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(ProductType type){
    	productTypeService.updateObject(type);
    	return new JsonResult();
    }
   
    @RequestMapping("/doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
    	productTypeService.deleteObject(id);
    	return new JsonResult();
    }
}









