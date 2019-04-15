package edu.autocar.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.autocar.domain.Avata;

//xml을 사용하지 않고 Mybatis mapper @을 통해 SQL 작성
public interface AvataDao {
	@Select("SELECT * FROM avata WHERE user_id=#{userId}")
	Avata findById(String userId) throws Exception;
	@Insert("INSERT INTO avata (user_id, image) values(#{userId}, #{image})")
	int insert(Avata avata) throws Exception;
	@Update("UPDATE SET imaga=#{image} where user_id=#{userId}")
	int update(Avata avata) throws Exception;
	@Delete("DELETE FROM avata WHERE user_id=#{userId}")
	int delete(String userId) throws Exception;
}
