package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Customer;
import com.briup.demo.bean.CustomerExample;
import com.briup.demo.mapper.CustomerMapper;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户存储账号和密码的controller
 * @author JT
 *
 */

@RestController
@Api(description="新增用户接口")
public class CustomerController {
	@Autowired
	public ICustomerService customerService;
	@Autowired
	public CustomerMapper customerMapper;
	
	@PostMapping("/customerLink")
	@ApiOperation("新增用户")
	public Message<String> save(Customer customer){
		try {
			customerService.save(customer);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROE_CODE, "系统错误:"+e.getMessage());
		}
		
	}
	
	@GetMapping("/log")
	@ApiOperation("登录")
	public Message<String> login(int id){
		try {
			customerService.FindCustomerById(id);
			return MessageUtil.success();
		} catch (CustomerException e) {
			return MessageUtil.error(StatusCodeUtil.ERROE_CODE, "系统错误");
		}
	}
}
