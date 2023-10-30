package com.joeun.dreamair.user;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Users;

@Mapper
public interface UserMapper {
    
     public Users login(String username);
}
