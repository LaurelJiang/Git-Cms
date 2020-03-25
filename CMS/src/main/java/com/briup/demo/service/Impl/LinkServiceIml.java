package com.briup.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.demo.bean.Link;
import com.briup.demo.bean.LinkExample;
import com.briup.demo.bean.LinkExample.Criteria;
import com.briup.demo.mapper.LinkMapper;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.CustomerException;
import com.briup.demo.utils.StatusCodeUtil;

@Service
public class LinkServiceIml implements ILinkService {
	@Autowired
	private LinkMapper linkMapper;
	
	@Override
	public void saveLink(Link link) throws CustomerException {
		if(link==null) {
			throw new CustomerException(StatusCodeUtil.ERROE_CODE
					, "参数为空！");
		}
		linkMapper.insert(link);
	}

	@Override
	public List<Link> findAllLinks() throws CustomerException {
		LinkExample example = new LinkExample();
		List<Link> list = linkMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteLinkByid(int id) throws CustomerException {
		linkMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Link> findLinkByName(String name) throws CustomerException {
		name=  name==null ? "":name.trim();
		LinkExample example = new LinkExample();
		if ("".equals(name) ){
			//如果搜索条件没写，则返回所有数据
			return linkMapper.selectByExample(example);
		}else {
			//如果搜索条件不为null，则返回满足条件的数据
			Criteria criteria = example.createCriteria();
			criteria.andNameLike("%"+name+"%");
			return linkMapper.selectByExample(example);
		}
		
	}
	
}
