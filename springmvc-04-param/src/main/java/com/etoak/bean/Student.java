package com.etoak.bean;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@Setter
@Getter
@ToString*/
@Data
@AllArgsConstructor // 按照参数顺序构造有参构造方法
@NoArgsConstructor  // 无参构造方法
public class Student {
	
	private Integer id;
	
	private String name; 
	
	private Integer age;
	
	private List<String> hobbyList;
	
	// 存储id和name
	private Map<String,Object> stuMap;

}
