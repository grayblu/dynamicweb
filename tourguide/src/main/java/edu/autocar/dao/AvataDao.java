package edu.autocar.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.autocar.domain.Avata;

public interface AvataDao {

	@Select("select * from avata where user_id=#{userId}")
	Avata findById(String userId) throws Exception;

	@Insert("insert into avata (user_id, image) values(#{userId}, #{image})")
	int insert(Avata avata) throws Exception;

	@Update("update avata set image = #{image} where user_id = #{userId}")
	int update(Avata avata) throws Exception;

	@Delete("delete from avata where user_id = #{userId}")
	int delete(String userId) throws Exception;
}
