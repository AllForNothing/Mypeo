package product.dao;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import cn.tedu.ttms.attachement.dao.AttachementDao;
import cn.tedu.ttms.attachement.entity.Attachement;
import common.dao.TestBaseDao;

public class TestAttachementDao extends TestBaseDao{

	@Test
	public void testInsertObject(){
		AttachementDao dao=(AttachementDao)ctx.getBean("attachementDao");
		Attachement t=new Attachement();
		
		t.setTitle("title-B");
		t.setFileName("b.png");//真实的文件
		t.setFilePath("/upload/2017/07/21/ABCDE.png");
		t.setContentType("images/png");
		
		String fileContent="helloworld";//假设这是文件内容
		String digest=DigestUtils.md5Hex(fileContent.getBytes());
		
		t.setFileDisgest(digest);//文件摘要
		t.setCreatedUser("admin");
		t.setModifiedUser("admin");
		
		int rows=dao.insertObject(t);
		Assert.assertEquals(1, rows);
	}
}