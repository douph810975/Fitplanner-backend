package com.example.backend.Dao;


import com.example.backend.entity.Pyq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PyqDao {
    @Insert("insert into pyq_table (userid, content, imgUrl, deleted, createTime)  values (#{userid}, #{content}, #{imgUrl}, #{deleted}, #{createTime})")
    public int insertPyq(Pyq pyq);
}
