package com.briup.demo.service;

import java.util.List;

import com.briup.demo.bean.Article;
import com.briup.demo.utils.CustomerException;

public interface IArticalService {
	/**
	 * 添加和修改文章
	 */
	public void saveOrUpdateArtical(Article article) throws CustomerException;
	
	/**
	 * 根据id删除文章
	 */
	public void deleteArticleById(int id) throws CustomerException;
	
	/**
	 * 查询文章
	 */
	public List<Article> findArticleByCondition(String keyStr,String condition) throws CustomerException;
	
	/**
	 * 根据id查询文章
	 */
	public Article findArticleById(int id) throws CustomerException;
	
}
