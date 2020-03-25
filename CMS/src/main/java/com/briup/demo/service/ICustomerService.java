package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Customer;
import com.briup.demo.utils.CustomerException;

public interface ICustomerService  { 
	/**
	 * 保存用户注册保存的账号和密码
	 */
	void save(Customer customer) throws CustomerException;
	/**
	 * 判断用户输入的账号和密码是否正确
	 */
	Customer FindCustomerById(int id) throws CustomerException;
	/**
	 * 查询所有的用户
	 */
	List<Customer> FindAllCustomer() throws CustomerException;
}
