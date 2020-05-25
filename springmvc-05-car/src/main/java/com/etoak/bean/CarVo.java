package com.etoak.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car{
	
	// 级别名称
	private String levelName;
	
	// 变速箱名称
	private String gearboxName;
	
	// 排量
	private String outputVolumeName;
	
}
