package com.briup.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.demo.bean.Link;
import com.briup.demo.service.ILinkService;
import com.briup.demo.utils.Message;
import com.briup.demo.utils.MessageUtil;
import com.briup.demo.utils.StatusCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 与链接和全段交互的web层
 * @author JT
 *
 */
@RestController
@Api(description="链接相关接口")
public class LinkController {
	@Autowired
	public ILinkService linkService;
	
	@PostMapping("/addLink")
	@ApiOperation("新增链接")
	public Message<String> saveLink(Link link){
		 try {
			 linkService.saveLink(link);
			return MessageUtil.success();
		} catch (Exception e) {
			return MessageUtil.error(StatusCodeUtil.ERROE_CODE, "系统错误:"+e.getMessage());
		}
	}
	
	@PostMapping("/updateLink")
	@ApiOperation("修改链接信息")
	public Message<String> updateLink(Link link){
		linkService.saveLink(link);
		return MessageUtil.success();
	}
	
	@GetMapping("/selectLinks")
	@ApiOperation("查询所有的链接")
	public Message<List<Link>> selectLinks(){
		List<Link> list = linkService.findAllLinks();
		return  MessageUtil.success(list);
	}
	
	@GetMapping("/deleteLinkById")
	@ApiOperation("根据id删除链接")
	public  Message<String> deleteLinkByid(int id){
		linkService.deleteLinkByid(id);
		return MessageUtil.success();
	}
	
	@GetMapping("/selectLinkName")
	@ApiOperation("根据链接名查询")
	public Message<List<Link>> slectLinkByName(String name){
		List<Link> list = linkService.findLinkByName(name);
		return MessageUtil.success(list);
	}
}
