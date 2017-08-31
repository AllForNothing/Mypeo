package cn.tedu.ttms.attachement.dao;

import java.io.File;
import java.util.List;

import cn.tedu.ttms.attachement.entity.Attachement;
import cn.tedu.ttms.common.dao.BaseDao;

public interface AttachementDao extends BaseDao<Attachement>{

	List<Attachement> findObjects();
	
	/**根据摘要信息判定文件是否已经存在*/
	int findObjectByDisgest(String fileDisgest);
	
	Attachement findObjectById(Integer id);
	
}