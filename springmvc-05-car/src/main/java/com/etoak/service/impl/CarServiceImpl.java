
package com.etoak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarServiceImpl implements CarService{
	
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public int addCar(Car car) {
		
		return carMapper.addCar(car);
	}

	@Override
	public PageVo<CarVo> queryList(int pageName, int pageSize, CarVo carVo) {
		
		// 设置分页条件
		PageHelper.startPage(pageName,pageSize);
		
		// 查询列表
		List<CarVo> carList = carMapper.queryList(carVo);
		
		// 创建PageInfo对象，用于获取分页数据
		PageInfo<CarVo> pageInfo = new PageInfo(carList);
		
		return new PageVo<CarVo>(
				// 当前页
				pageInfo.getPageNum(),
				// 当前页的数量
				pageInfo.getPageSize(),
				// 查询列表
				carList,
				// 总记录数
				pageInfo.getTotal(),
				// 总页数
				pageInfo.getPages(),
				// 第一页
				pageInfo.isIsFirstPage(),
				// 最后一页
				pageInfo.isIsLastPage());
	}

	@Override
	public List<String> getAllBrand() {
		return carMapper.getAllBrand();
	}

	@Override
	public List<String> getSeriesByBrand(String brand) {
		return carMapper.getSeriesByBrand(brand);
	}
}
