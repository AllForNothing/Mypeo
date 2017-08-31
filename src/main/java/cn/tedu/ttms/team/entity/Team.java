package cn.tedu.ttms.team.entity;

import java.io.Serializable;
import java.util.Date;
/**团(一个项目下可以创建多个团)
 * 例如 环球游项目下有50日团,60日团
 * */
public class Team implements Serializable{
	private static final long serialVersionUID = -7472876548624961187L;//tms_teams
	private Integer id;
	private String name;
	private Integer projectId;
	private Integer valid;
	private String note;
	/**项目的创建时间*/
	private Date createdTime;
	/**项目的修改时间*/
	private Date modifiedTime;
	/**项目的创建人*/
	private String createdUser;
	/**项目的修改*/
    private String modifiedUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getValid() {
		return valid;
	}
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
    
    
	
	

}