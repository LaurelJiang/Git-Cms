package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Link;
import com.briup.demo.utils.CustomerException;

/**
 * 关于链接的相关操作
 * @author JT
 *
 */
public interface ILinkService {
	/**
	 * 保存链接信息
	 * @param link
	 */
	void saveLink(Link link) throws CustomerException;
	
	/**
	 * 查询所有的链接信息
	 */
	List<Link> findAllLinks() throws CustomerException;
	/**
	 * 根据id删除对应链接
	 * 
	 */
	void deleteLinkByid(int id) throws CustomerException;
	
	/**
	 * 根据链接名字查询链接
	 */
	List<Link> findLinkByName(String name) throws CustomerException;
	
}
