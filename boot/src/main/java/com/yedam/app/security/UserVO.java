package com.yedam.app.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class UserVO implements UserDetails{
	private String id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	List<String> roleName;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		for(String role:roleName) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return roles;
	}
	@Override
	public String getUsername() {
		return loginId;
	}
	
	@Override
	public boolean isAccountNonExpired() { // 휴먼 계정, 패스 워드 변경
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() { //5회 비번 입력 에러 
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isEnabled() { //로그인 불가
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
