package cn.tedu.ttms.attachement.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.tedu.ttms.attachement.entity.Attachement;

public interface AttachementService {
	
	List<Attachement> findObjects();
    /**
     * @param title 附件标题
     * @param athType 附件归属类型(例如产品附件)
     * @param belongId 附件归属id(例如具体的某个产品的id)
     * @param mFile 上传的文件对象
     */
	void saveObject(String title,Integer athType,Integer belongId,MultipartFile mFile,String serverPath);
	
	File findObjectById(Integer id);
}