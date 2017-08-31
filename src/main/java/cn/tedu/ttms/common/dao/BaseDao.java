package cn.tedu.ttms.common.dao;
/**类上定义的泛型用于约束类中方法的
 * 参数类型,方法的返回值类型或属性类型*/
public interface BaseDao<T> {
	int insertObject(T t);
	int updateObject(T t);
	
}