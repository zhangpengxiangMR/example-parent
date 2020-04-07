package com.pykj.v2.demo.service.impl;

import com.pykj.v2.demo.service.IModifyService;
import com.pykj.v2.spring.framework.annotation.PYService;

/**
 * 增删改业务
 * @author Tom
 *
 */
@PYService
public class ModifyService implements IModifyService {

	/**
	 * 增加
	 */
	public String add(String name,String addr) {
		return "modifyService add,name=" + name + ",addr=" + addr;
	}

	/**
	 * 修改
	 */
	public String edit(Integer id,String name) {
		return "modifyService edit,id=" + id + ",name=" + name;
	}

	/**
	 * 删除
	 */
	public String remove(Integer id) {
		return "modifyService id=" + id;
	}
	
}
