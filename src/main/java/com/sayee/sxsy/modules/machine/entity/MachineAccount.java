/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.sayee.sxsy.modules.machine.entity;

import com.sayee.sxsy.common.utils.excel.annotation.ExcelField;
import org.hibernate.validator.constraints.Length;

import com.sayee.sxsy.common.persistence.DataEntity;

/**
 * 台账信息展示Entity
 * @author zhangfan
 * @version 2019-05-17
 */
public class MachineAccount extends DataEntity<MachineAccount> {
	
	private static final long serialVersionUID = 1L;
	private String machineAccountId;		// machine_account_id
	private String reportingTime;		// 报案时间
	private String deptId;		// 部门主键
	private String mediatorId;		// 调解员ID，关联人员表主键
	private String patientName;		// 患者名称
	private String hospitalId;		// 医院名称。通过主键进行关联
	private String major;		// 重大
	private String insuranceCompany;		// 保险公司名称
	private String policyNumber;		// 保单号
	private String startInsuranceTime;		// 起保日期
	private String disputesTime;		// 纠纷发生日期
	private String riskTime;		// 出险日期
	private String summaryOfDisputes;		// 纠纷概要
	private String isMajor;		// 是否重大 1是 0否
	private String treatmentMode;		// 诊疗方式
	private String treatmentResult;		// 治疗结果
	private String patientsReflectFocus;		// 患方反映焦点
	private String relatedMajor;		// 相关专业
	private String assessTime;		// 评估时间
	private String assessNumber;		// 评估号
	private String dutyRatio;		// 责任比例
	private String feedbackTime;		// 反馈时间
	private String agreementNumber;		// 协议号
	private String ratifyAccord;		// 签署协议/判决时间
	private String agreementStampTime;		// 协议盖章时间
	private String agreementAmount;		// 协议金额
	private String insuranceAmount;		// 保险金额
	private String claimSettlementTime;		// 交理赔时间
	private String compensateTime;		// 赔付时间
	private String flowDays;		// 流转天数
	private String handOver;		// 移交人
	private String archiveTime;		// 归档时间
	private String fileNumber;		// 卷宗编号
	private String remark;		// 备注
	
	public MachineAccount() {
		super();
	}

	public MachineAccount(String id){
		super(id);
	}

	@Length(min=1, max=32, message="machine_account_id长度必须介于 1 和 32 之间")
	public String getMachineAccountId() {
		return machineAccountId;
	}

	public void setMachineAccountId(String machineAccountId) {
		this.machineAccountId = machineAccountId;
	}
	
	@Length(min=0, max=20, message="报案时间长度必须介于 0 和 20 之间")
	@ExcelField(title="报案时间", align=2, sort=25)
	public String getReportingTime() {
		return reportingTime;
	}

	public void setReportingTime(String reportingTime) {
		this.reportingTime = reportingTime;
	}
	
	@Length(min=0, max=32, message="部门主键长度必须介于 0 和 32 之间")
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	@Length(min=0, max=32, message="调解员ID，关联人员表主键长度必须介于 0 和 32 之间")
	public String getMediatorId() {
		return mediatorId;
	}

	public void setMediatorId(String mediatorId) {
		this.mediatorId = mediatorId;
	}
	
	@Length(min=0, max=10, message="患者名称长度必须介于 0 和 10 之间")
	@ExcelField(title="患者名称", align=2, sort=25)
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	@Length(min=0, max=32, message="医院名称。通过主键进行关联长度必须介于 0 和 32 之间")
	@ExcelField(title="医院名称", align=2, sort=25)
	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	@Length(min=0, max=50, message="重大长度必须介于 0 和 50 之间")
	@ExcelField(title="重大", align=2, sort=25)
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Length(min=0, max=100, message="保险公司名称长度必须介于 0 和 100 之间")
	@ExcelField(title="保险公司", align=2, sort=25)
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	
	@Length(min=0, max=50, message="保单号长度必须介于 0 和 50 之间")
	@ExcelField(title="保单号", align=2, sort=25)
	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	
	@Length(min=0, max=20, message="起保日期长度必须介于 0 和 20 之间")
	@ExcelField(title="起保日期", align=2, sort=25)
	public String getStartInsuranceTime() {
		return startInsuranceTime;
	}

	public void setStartInsuranceTime(String startInsuranceTime) {
		this.startInsuranceTime = startInsuranceTime;
	}
	
	@Length(min=0, max=20, message="纠纷发生日期长度必须介于 0 和 20 之间")
	@ExcelField(title="纠纷日期", align=2, sort=25)
	public String getDisputesTime() {
		return disputesTime;
	}

	public void setDisputesTime(String disputesTime) {
		this.disputesTime = disputesTime;
	}
	
	@Length(min=0, max=20, message="出险日期长度必须介于 0 和 20 之间")
	@ExcelField(title="出险日期", align=2, sort=25)
	public String getRiskTime() {
		return riskTime;
	}

	public void setRiskTime(String riskTime) {
		this.riskTime = riskTime;
	}
	
	@Length(min=0, max=500, message="纠纷概要长度必须介于 0 和 500 之间")
	@ExcelField(title="纠纷概要", align=2, sort=25)
	public String getSummaryOfDisputes() {
		return summaryOfDisputes;
	}

	public void setSummaryOfDisputes(String summaryOfDisputes) {
		this.summaryOfDisputes = summaryOfDisputes;
	}
	
	@Length(min=0, max=1, message="是否重大 1是 0否长度必须介于 0 和 1 之间")
	public String getIsMajor() {
		return isMajor;
	}

	public void setIsMajor(String isMajor) {
		this.isMajor = isMajor;
	}
	
	@Length(min=0, max=500, message="诊疗方式长度必须介于 0 和 500 之间")
	@ExcelField(title="诊疗方式", align=2, sort=25)
	public String getTreatmentMode() {
		return treatmentMode;
	}

	public void setTreatmentMode(String treatmentMode) {
		this.treatmentMode = treatmentMode;
	}
	
	@Length(min=0, max=500, message="治疗结果长度必须介于 0 和 500 之间")
	@ExcelField(title="治疗结果", align=2, sort=25)
	public String getTreatmentResult() {
		return treatmentResult;
	}

	public void setTreatmentResult(String treatmentResult) {
		this.treatmentResult = treatmentResult;
	}
	
	@Length(min=0, max=500, message="患方反映焦点长度必须介于 0 和 500 之间")
	@ExcelField(title="患方反映焦点", align=2, sort=25)
	public String getPatientsReflectFocus() {
		return patientsReflectFocus;
	}

	public void setPatientsReflectFocus(String patientsReflectFocus) {
		this.patientsReflectFocus = patientsReflectFocus;
	}
	
	@Length(min=0, max=255, message="相关专业长度必须介于 0 和 255 之间")
	@ExcelField(title="相关专业", align=2, sort=25)
	public String getRelatedMajor() {
		return relatedMajor;
	}

	public void setRelatedMajor(String relatedMajor) {
		this.relatedMajor = relatedMajor;
	}
	
	@Length(min=0, max=20, message="评估时间长度必须介于 0 和 20 之间")
	@ExcelField(title="评估时间", align=2, sort=25)
	public String getAssessTime() {
		return assessTime;
	}

	public void setAssessTime(String assessTime) {
		this.assessTime = assessTime;
	}
	
	@Length(min=0, max=20, message="评估号长度必须介于 0 和 20 之间")
	@ExcelField(title="评估号", align=2, sort=25)
	public String getAssessNumber() {
		return assessNumber;
	}

	public void setAssessNumber(String assessNumber) {
		this.assessNumber = assessNumber;
	}
	
	@Length(min=0, max=50, message="责任比例长度必须介于 0 和 50 之间")
	@ExcelField(title="责任比例", align=2, sort=25)
	public String getDutyRatio() {
		return dutyRatio;
	}

	public void setDutyRatio(String dutyRatio) {
		this.dutyRatio = dutyRatio;
	}
	
	@Length(min=0, max=20, message="反馈时间长度必须介于 0 和 20 之间")
	@ExcelField(title="反馈时间", align=2, sort=25)
	public String getFeedbackTime() {
		return feedbackTime;
	}

	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	
	@Length(min=0, max=20, message="协议号长度必须介于 0 和 20 之间")
	@ExcelField(title="协议号", align=2, sort=25)
	public String getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(String agreementNumber) {
		this.agreementNumber = agreementNumber;
	}
	
	@Length(min=0, max=20, message="签署协议/判决时间长度必须介于 0 和 20 之间")
	@ExcelField(title="签署协议/判决时间", align=2, sort=25)
	public String getRatifyAccord() {
		return ratifyAccord;
	}

	public void setRatifyAccord(String ratifyAccord) {
		this.ratifyAccord = ratifyAccord;
	}
	
	@Length(min=0, max=20, message="协议盖章时间长度必须介于 0 和 20 之间")
	@ExcelField(title="协议盖章", align=2, sort=25)
	public String getAgreementStampTime() {
		return agreementStampTime;
	}

	public void setAgreementStampTime(String agreementStampTime) {
		this.agreementStampTime = agreementStampTime;
	}
	
	public String getAgreementAmount() {
		return agreementAmount;
	}

	public void setAgreementAmount(String agreementAmount) {
		this.agreementAmount = agreementAmount;
	}
	
	public String getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(String insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	
	@Length(min=0, max=20, message="交理赔时间长度必须介于 0 和 20 之间")
	@ExcelField(title="交理赔时间", align=2, sort=25)
	public String getClaimSettlementTime() {
		return claimSettlementTime;
	}

	public void setClaimSettlementTime(String claimSettlementTime) {
		this.claimSettlementTime = claimSettlementTime;
	}
	
	@Length(min=0, max=20, message="赔付时间长度必须介于 0 和 20 之间")
	@ExcelField(title="赔付时间", align=2, sort=25)
	public String getCompensateTime() {
		return compensateTime;
	}

	public void setCompensateTime(String compensateTime) {
		this.compensateTime = compensateTime;
	}
	
	@Length(min=0, max=20, message="流转天数长度必须介于 0 和 20 之间")
	@ExcelField(title="流转天数", align=2, sort=25)
	public String getFlowDays() {
		return flowDays;
	}

	public void setFlowDays(String flowDays) {
		this.flowDays = flowDays;
	}
	
	@Length(min=0, max=20, message="移交人长度必须介于 0 和 20 之间")
	@ExcelField(title="移交人", align=2, sort=25)
	public String getHandOver() {
		return handOver;
	}

	public void setHandOver(String handOver) {
		this.handOver = handOver;
	}
	
	@Length(min=0, max=20, message="归档时间长度必须介于 0 和 20 之间")
	@ExcelField(title="归档日期", align=2, sort=25)
	public String getArchiveTime() {
		return archiveTime;
	}

	public void setArchiveTime(String archiveTime) {
		this.archiveTime = archiveTime;
	}
	
	@Length(min=0, max=20, message="卷宗编号长度必须介于 0 和 20 之间")
	@ExcelField(title="卷宗编号", align=2, sort=25)
	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}
	
	@Length(min=0, max=500, message="备注长度必须介于 0 和 500 之间")
	@ExcelField(title="备注", align=10, sort=500)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}