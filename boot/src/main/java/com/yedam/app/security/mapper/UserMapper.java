package com.yedam.app.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.security.UserVO;

@Mapper
public interface UserMapper {
	public UserVO selectUserInfo(String id);
	public List<String> selectRole(String id);
}
