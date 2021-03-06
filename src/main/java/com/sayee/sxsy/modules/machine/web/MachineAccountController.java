/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.sayee.sxsy.modules.machine.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.google.common.collect.Lists;
import com.sayee.sxsy.common.beanvalidator.BeanValidators;
import com.sayee.sxsy.common.utils.excel.ExportExcel;
import com.sayee.sxsy.common.utils.excel.ImportExcel;
import com.sayee.sxsy.modules.sys.entity.User;
import com.sayee.sxsy.modules.sys.service.SystemService;
import com.sayee.sxsy.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sayee.sxsy.common.config.Global;
import com.sayee.sxsy.common.persistence.Page;
import com.sayee.sxsy.common.web.BaseController;
import com.sayee.sxsy.common.utils.StringUtils;
import com.sayee.sxsy.modules.machine.entity.MachineAccount;
import com.sayee.sxsy.modules.machine.service.MachineAccountService;

import java.util.List;

/**
 * 台账信息展示Controller
 * @author zhangfan
 * @version 2019-05-17
 */
@Controller
@RequestMapping(value = "${adminPath}/machine/machineAccount")
public class MachineAccountController extends BaseController {

	@Autowired
	private MachineAccountService machineAccountService;
	
	@ModelAttribute
	public MachineAccount get(@RequestParam(required=false) String id) {
		MachineAccount entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = machineAccountService.get(id);
		}
		if (entity == null){
			entity = new MachineAccount();
		}
		return entity;
	}
	
	@RequiresPermissions("machine:machineAccount:view")
	@RequestMapping(value = {"list", ""})
	public String list(MachineAccount machineAccount, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<MachineAccount> page = machineAccountService.findPage(new Page<MachineAccount>(request, response), machineAccount); 
		model.addAttribute("page", page);
		return "modules/machine/machineAccountList";
	}

	@RequiresPermissions("machine:machineAccount:view")
	@RequestMapping(value = "form")
	public String form(MachineAccount machineAccount, Model model) {
		model.addAttribute("machineAccount", machineAccount);
		return "modules/machine/machineAccountForm";
	}

	@RequiresPermissions("machine:machineAccount:edit")
	@RequestMapping(value = "save")
	public String save(MachineAccount machineAccount, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, machineAccount)){
			return form(machineAccount, model);
		}
		machineAccountService.save(machineAccount);
		addMessage(redirectAttributes, "保存台账信息展示成功");
		return "redirect:"+Global.getAdminPath()+"/machine/machineAccount/?repage";
	}
	
	@RequiresPermissions("machine:machineAccount:edit")
	@RequestMapping(value = "delete")
	public String delete(MachineAccount machineAccount, RedirectAttributes redirectAttributes) {
		machineAccountService.delete(machineAccount);
		addMessage(redirectAttributes, "删除台账信息展示成功");
		return "redirect:"+Global.getAdminPath()+"/machine/machineAccount/?repage";
	}


	/**
	 * 导入用户数据
	 * @param file
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("machine:machineAccount:edit")
	@RequestMapping(value = "import", method= RequestMethod.POST)
	public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/user/list?repage";
		}
		try {
			int successNum = 0;
			int failureNum = 0;
			StringBuilder failureMsg = new StringBuilder();
			ImportExcel ei = new ImportExcel(file, 1, 0);
			List<MachineAccount> list = ei.getDataList(MachineAccount.class);
			for (MachineAccount machineAccount : list){
				try{
					if (StringUtils.isNotBlank(machineAccount.getFileNumber())) {
//					if ("true".equals(machineAccount.getAgreementAmount())){
						machineAccount.preInsert();
						machineAccount.setMachineAccountId(machineAccount.getId());
						machineAccount.setIsNewRecord(true);
						machineAccountService.save(machineAccount);
						successNum++;
					}else{
						failureMsg.append("<br/>卷宗编号 "+machineAccount.getFileNumber()+" 已存在; ");
						failureNum++;
					}
				}catch(ConstraintViolationException ex){
					failureMsg.append("<br/>卷宗编号 "+machineAccount.getFileNumber()+" 导入失败：");
					List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
					for (String message : messageList){
						failureMsg.append(message+"; ");
						failureNum++;
					}
				}catch (Exception ex) {
					failureMsg.append("<br/>卷宗编号 "+machineAccount.getFileNumber()+" 导入失败："+ex.getMessage());
				}
			}
			if (failureNum>0){
				failureMsg.insert(0, "，失败 "+failureNum+" 条台账，导入信息如下：");
			}
			addMessage(redirectAttributes, "已成功导入 "+successNum+" 条台账信息"+failureMsg);
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入台账失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/machine/machineAccount/list?repage";
	}

	/**
	 * 下载导入用户数据模板
	 * @param response
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("machine:machineAccount:view")
	@RequestMapping(value = "import/template")
	public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String fileName = "台账信息导入模板.xlsx";
			List<User> list = Lists.newArrayList(); list.add(UserUtils.getUser());
			new ExportExcel("台账信息", MachineAccount.class, 2).setDataList(list).write(response, fileName).dispose();
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息："+e.getMessage());
		}
		return "redirect:" + adminPath + "/machine/machineAccount/list?repage";
	}
}