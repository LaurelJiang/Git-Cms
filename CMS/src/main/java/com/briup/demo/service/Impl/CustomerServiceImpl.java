package com.briup.demo.service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Customer;
import com.briup.demo.bean.CustomerExample;
import com.briup.demo.mapper.CustomerMapper;
import com.briup.demo.service.ICustomerService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class CustomerServiceImpl implements ICustomerService{
	//客户的dao
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public void save(Customer customer) throws CustomerException {
		if (customer==null) {
			throw new CustomerException(StatusCodeUtil.ERROE_CODE
					, "参数为空！");
		}
		customerMapper.insert(customer);
	}

	@Override
	public Customer FindCustomerById(int id) throws CustomerException {
		Customer selectByPrimaryKey = customerMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public List<Customer> FindAllCustomer() throws CustomerException {
		CustomerExample customerExample = new CustomerExample();
		List<Customer> selectByExample = customerMapper.selectByExample(customerExample);
		return selectByExample;
	}

//
//	@Override
//	public void log(String name, String password) throws CustomerException {
//		CustomerExample example = new CustomerExample();
//		example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(password);
//		List<Customer> customer = customerMapper.selectByExample(example);
//		if (name==null || password==null) {
//			throw new CustomerException(StatusCodeUtil.ERROE_CODE, "参数为空");
//		}
//		else if(name!=null || password!=null){
//			example.createCriteria().andUsernameEqualTo(customer.get(1).getUsername()).andPasswordEqualTo(customer.get(2).getPassword());
//		 }else{
//			 throw new CustomerException(StatusCodeUtil.ERROE_CODE, "参数不对");
//		 }
//		}

}
