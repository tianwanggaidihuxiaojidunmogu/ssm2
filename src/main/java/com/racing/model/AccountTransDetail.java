package com.racing.model;

import java.util.Date;

public class AccountTransDetail {
    private String applicationId;

    private String caseNumber;

    private String caseType;

    private String emergencyLevel;

    private String subjectType;

    private String bankId;

    private String bankName;

    private String accountName;

    private String cardNumber;

    private String inquiryMode;

    private String inquiryPeriodStart;

    private String inquiryPeriodEnd;

    private String reason;

    private String remark;

    private String applicationTime;

    private String applicationOrgId;

    private String applicationOrgName;

    private String operatorIdType;

    private String operatorIdNumber;

    private String operatorName;

    private String operatorPhoneNumber;

    private String investigatorIdType;

    private String investigatorIdNumber;

    private String investigatorName;

    private String txCode;

    private String fromTGOrganizationId;

    private String messageFrom;

    private String transSerialNumber;

    private Date createTime;

    private Date lastUpdateTime;

    private String type;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId == null ? null : applicationId.trim();
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber == null ? null : caseNumber.trim();
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    public String getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(String emergencyLevel) {
        this.emergencyLevel = emergencyLevel == null ? null : emergencyLevel.trim();
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId == null ? null : bankId.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getInquiryMode() {
        return inquiryMode;
    }

    public void setInquiryMode(String inquiryMode) {
        this.inquiryMode = inquiryMode == null ? null : inquiryMode.trim();
    }

    public String getInquiryPeriodStart() {
        return inquiryPeriodStart;
    }

    public void setInquiryPeriodStart(String inquiryPeriodStart) {
        this.inquiryPeriodStart = inquiryPeriodStart == null ? null : inquiryPeriodStart.trim();
    }

    public String getInquiryPeriodEnd() {
        return inquiryPeriodEnd;
    }

    public void setInquiryPeriodEnd(String inquiryPeriodEnd) {
        this.inquiryPeriodEnd = inquiryPeriodEnd == null ? null : inquiryPeriodEnd.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime == null ? null : applicationTime.trim();
    }

    public String getApplicationOrgId() {
        return applicationOrgId;
    }

    public void setApplicationOrgId(String applicationOrgId) {
        this.applicationOrgId = applicationOrgId == null ? null : applicationOrgId.trim();
    }

    public String getApplicationOrgName() {
        return applicationOrgName;
    }

    public void setApplicationOrgName(String applicationOrgName) {
        this.applicationOrgName = applicationOrgName == null ? null : applicationOrgName.trim();
    }

    public String getOperatorIdType() {
        return operatorIdType;
    }

    public void setOperatorIdType(String operatorIdType) {
        this.operatorIdType = operatorIdType == null ? null : operatorIdType.trim();
    }

    public String getOperatorIdNumber() {
        return operatorIdNumber;
    }

    public void setOperatorIdNumber(String operatorIdNumber) {
        this.operatorIdNumber = operatorIdNumber == null ? null : operatorIdNumber.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatorPhoneNumber() {
        return operatorPhoneNumber;
    }

    public void setOperatorPhoneNumber(String operatorPhoneNumber) {
        this.operatorPhoneNumber = operatorPhoneNumber == null ? null : operatorPhoneNumber.trim();
    }

    public String getInvestigatorIdType() {
        return investigatorIdType;
    }

    public void setInvestigatorIdType(String investigatorIdType) {
        this.investigatorIdType = investigatorIdType == null ? null : investigatorIdType.trim();
    }

    public String getInvestigatorIdNumber() {
        return investigatorIdNumber;
    }

    public void setInvestigatorIdNumber(String investigatorIdNumber) {
        this.investigatorIdNumber = investigatorIdNumber == null ? null : investigatorIdNumber.trim();
    }

    public String getInvestigatorName() {
        return investigatorName;
    }

    public void setInvestigatorName(String investigatorName) {
        this.investigatorName = investigatorName == null ? null : investigatorName.trim();
    }

    public String getTxCode() {
        return txCode;
    }

    public void setTxCode(String txCode) {
        this.txCode = txCode == null ? null : txCode.trim();
    }

    public String getFromTGOrganizationId() {
        return fromTGOrganizationId;
    }

    public void setFromTGOrganizationId(String fromTGOrganizationId) {
        this.fromTGOrganizationId = fromTGOrganizationId == null ? null : fromTGOrganizationId.trim();
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom == null ? null : messageFrom.trim();
    }

    public String getTransSerialNumber() {
        return transSerialNumber;
    }

    public void setTransSerialNumber(String transSerialNumber) {
        this.transSerialNumber = transSerialNumber == null ? null : transSerialNumber.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}