package com.bsb.security.browser.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserMapper {

    @Select("SELECT password FROM user_table WHERE username = #{username}")
    String getLoginPassword(@Param("username") String username);
}
