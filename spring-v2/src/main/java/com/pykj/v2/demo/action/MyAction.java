package com.pykj.v2.demo.action;

import com.pykj.v2.demo.service.IModifyService;
import com.pykj.v2.demo.service.IQueryService;
import com.pykj.v2.spring.framework.annotation.PYAutowired;
import com.pykj.v2.spring.framework.annotation.PYController;
import com.pykj.v2.spring.framework.annotation.PYRequestMapping;
import com.pykj.v2.spring.framework.annotation.PYRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公布接口url
 * @author Tom
 *
 */
@PYController
@PYRequestMapping("/web")
public class MyAction {

	@PYAutowired
	IQueryService queryService;
	@PYAutowired
	IModifyService modifyService;

	@PYRequestMapping("/query.json")
	public void query(HttpServletRequest request, HttpServletResponse response,
								@PYRequestParam("name") String name){
		String result = queryService.query(name);
		out(response,result);
	}
	
	@PYRequestMapping("/add*.json")
	public void add(HttpServletRequest request,HttpServletResponse response,
			   @PYRequestParam("name") String name,@PYRequestParam("addr") String addr){
		String result = modifyService.add(name,addr);
		out(response,result);
	}
	
	@PYRequestMapping("/remove.json")
	public void remove(HttpServletRequest request,HttpServletResponse response,
		   @PYRequestParam("id") Integer id){
		String result = modifyService.remove(id);
		out(response,result);
	}
	
	@PYRequestMapping("/edit.json")
	public void edit(HttpServletRequest request,HttpServletResponse response,
			@PYRequestParam("id") Integer id,
			@PYRequestParam("name") String name){
		String result = modifyService.edit(id,name);
		out(response,result);
	}
	
	
	
	private void out(HttpServletResponse resp,String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
