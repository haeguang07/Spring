package com.yedam.app.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.aop.mapper.AaaMapper;

@Service("aService")
public class AaaServiceImpl implements AaaService {
	
	@Autowired
	AaaMapper aaaMapper;
	
	
	@Transactional
	@Override
	public void insert() {
		aaaMapper.insert("103");
		aaaMapper.insert("104");
		
	}

}
