package com.example.tip.trackinsurancepolicy.Model;

public class Policy {

    public String policyID;
    public String policyNo;
    public String policyName;
    public String pCompany;
    public String pIssueDate;
    public String pLastDate;
    public String pPremAmt;
    public String pPayPeriod;
    public String pAge;
    public String pPremDueDate;
    public String pSumAssured;
    public String pClaim;
    public String pNomineeName;

    public Policy(){

    }

    public Policy(String policyID,String policyNo, String policyName, String pCompany, String pIssueDate, String pLastDate, String pPremAmt, String pPayPeriod, String pAge, String pPremDueDate, String pSumAssured,String pClaim, String pNomineeName) {
        this.policyID = policyID;
        this.policyNo=policyNo;
        this.policyName = policyName;
        this.pCompany = pCompany;
        this.pIssueDate = pIssueDate;
        this.pLastDate = pLastDate;
        this.pPremAmt = pPremAmt;
        this.pPayPeriod = pPayPeriod;
        this.pAge = pAge;
        this.pPremDueDate=pPremDueDate;

        this.pSumAssured = pSumAssured;
        this.pClaim=pClaim;
        this.pNomineeName = pNomineeName;
    }

    public String getPolicyID() {
        return policyID;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public String getPolicyName() {
        return policyName;
    }

    public String getpCompany() {
        return pCompany;
    }

    public String getpIssueDate() {
        return pIssueDate;
    }

    public String getpLastDate() {
        return pLastDate;
    }

    public String getpPremAmt() {
        return pPremAmt;
    }

    public String getpPayPeriod() {
        return pPayPeriod;
    }

    public String getpAge() {
        return pAge;
    }

    public String getpPremDueDate() {
        return pPremDueDate;
    }
    public String getpClaim() {
        return pClaim;
    }

    public String getpSumAssured() {
        return pSumAssured;
    }

    public String getpNomineeName() {
        return pNomineeName;
    }

    public void setPolicyID(String policyID) {
        this.policyID = policyID;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public void setpCompany(String pCompany) {
        this.pCompany = pCompany;
    }

    public void setpIssueDate(String pIssueDate) {
        this.pIssueDate = pIssueDate;
    }

    public void setpLastDate(String pLastDate) {
        this.pLastDate = pLastDate;
    }

    public void setpPremAmt(String pPremAmt) {
        this.pPremAmt = pPremAmt;
    }

    public void setpPayPeriod(String pPayPeriod) {
        this.pPayPeriod = pPayPeriod;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public void setpPremDueDate(String pPremDueDate) {
        this.pPremDueDate = pPremDueDate;
    }

    public void setpSumAssured(String pSumAssured) {
        this.pSumAssured = pSumAssured;
    }

    public void setpClaim(String pClaim) {
        this.pClaim = pClaim;
    }

    public void setpNomineeName(String pNomineeName) {
        this.pNomineeName = pNomineeName;
    }

}
