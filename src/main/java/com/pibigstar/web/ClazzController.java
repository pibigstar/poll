package com.pibigstar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibigstar.domain.Clazz;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.ClazzService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clazz")
@Api(tags="班级管理Controller")
public class ClazzController extends BaseController{
	@Autowired
	private ClazzService clazzService;
	
	@ApiOperation("根据id查询")
	@GetMapping("get/{id}")
	public MyResponse get(@PathVariable Long id) {
		Clazz clazz = clazzService.getOneById(id);
		return success(clazz);
	}
	
	@ApiOperation("查询全部班级")
	@GetMapping("list")
	public MyResponse list() {
		List<Clazz> clazzs = clazzService.list();
		return success(clazzs);
	}

	@ApiOperation("添加班级")
	@PostMapping("add")
	public MyResponse add(Clazz clazz) {
		int result = clazzService.add(clazz);
		return success("添加成功！",result);
	}
	
	@ApiOperation("删除班级")
	@DeleteMapping("delete/{id}")
	public MyResponse delete(@PathVariable Long id) {
		int result = clazzService.delete(id);
		return success("删除成功！",result);
	}
	
	@ApiOperation("更新班级")
	@PutMapping("update")
	public MyResponse update(Clazz clazz) {
		int result = clazzService.update(clazz);
		return success("更新成功！",result);
	}
	
}
