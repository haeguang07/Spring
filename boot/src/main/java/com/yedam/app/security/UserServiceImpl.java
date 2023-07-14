package com.yedam.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserVO getEmpInfo(String id) {
		return userMapper.selectUserInfo(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO vo = userMapper.selectUserInfo(username);
		
		if(vo==null) {
			throw new UsernameNotFoundException("no User");
		}
		vo.setRoleName(userMapper.selectRole(vo.getId()));
		
		return vo;
	}

}
