package com.pibigstar.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibigstar.domain.User;
import com.pibigstar.domain.result.MyResponse;
import com.pibigstar.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;

	@ApiOperation("根据id查询")
	@GetMapping("get/{id}")
	public MyResponse get(Long id) {
		User user = userService.get(id);
		return success(user);
	}
	
	@ApiOperation("查询全部用户")
	@GetMapping("list")
	public MyResponse list() {
		List<User> users = userService.findAll();
		return success(users);
	}
	
	@ApiOperation("添加用户")
	@PostMapping("add")
	public MyResponse add(User user) {
		int result = userService.add(user);
		return success("添加成功！",result);
	}
	
	@ApiOperation("更新用户")
	@PutMapping("update")
	public MyResponse update(User user) {
		int result = userService.add(user);
		return success("更新成功！",result);
	}
	
	@ApiOperation("删除用户")
	@DeleteMapping("delete")
	public MyResponse delete(Long id) {
		int result = userService.delete(id);
		return success("删除成功！",result);
	}
	
}
