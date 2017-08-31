package cn.tedu.ttms.product.service;

import java.util.List;
import java.util.Map;

import cn.tedu.ttms.product.entity.ProductType;

public interface ProductTypeService {
	/**查询产品分类一级相关子分类,并在treeGrid中进行显示*/	
	List<Map<String,Object>> findObjects();
	
	/**查询分类信息在zTree中进行数据呈现*/
	List<Map<String,Object>> findTreeNodes();
	
	void saveObject(ProductType type);
	
	Map<String,Object> findObjectById(Integer id);
	
	void updateObject(ProductType type);
	
	/**根据id删除对象*/
	void deleteObject(Integer id);
	
    
}