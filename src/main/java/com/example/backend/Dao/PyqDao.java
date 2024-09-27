package com.example.backend.Dao;


import com.example.backend.entity.Pyq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface PyqDao {
    @Insert("insert into pyq_table (userid, content, imgUrl, deleted, createTime)  values (#{userid}, #{content}, #{imgUrl}, #{deleted}, #{createTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "uuid")
    public int insertPyq(Pyq pyq);
}
