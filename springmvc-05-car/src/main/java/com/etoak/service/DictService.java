package com.etoak.service;

import java.util.List;

import com.etoak.bean.Dict;

public interface DictService {
	
	// 根据groupId查询字典表
	List<Dict> queryList(String groupId); 
}
