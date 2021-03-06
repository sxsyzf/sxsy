/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.sayee.sxsy.modules.machine.dao;

import com.sayee.sxsy.common.persistence.CrudDao;
import com.sayee.sxsy.common.persistence.annotation.MyBatisDao;
import com.sayee.sxsy.modules.machine.entity.MachineAccount;

/**
 * 台账信息展示DAO接口
 * @author zhangfan
 * @version 2019-05-17
 */
@MyBatisDao
public interface MachineAccountDao extends CrudDao<MachineAccount> {
	
}