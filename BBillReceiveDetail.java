package com.courierService.bin;

public class BBillReceiveDetail {

	private String billReceiveDetailId;
	private String billReceiveInvoiceNumber;
	private String billReceiveCustomerId;
	private String billReceiveOfficeId;
	private String billReceiveManagerId;
	private String billReceiveDate;
	private String billReceiveRemark;
	private String billReceiveAmount;
	
	


	/*getters*/
	
	public String getBillReceiveDetailId() {
		return billReceiveDetailId;
	}
	
	public String getBillReceiveInvoiceNumber() {
		return billReceiveInvoiceNumber;
	}
	
	public String getBillReceiveOfficeId() {
		return billReceiveOfficeId;
	}
	
	public String getBillReceiveCustomerId() {
		return billReceiveCustomerId;
	}
	
	public String getBillReceiveManagerId() {
		return billReceiveManagerId;
	}
	
	public String getBillReceiveDate() {
		return billReceiveDate;
	}
	
	public String getBillReceiveRemark() {
		return billReceiveRemark;
	}
	
	public String getBillReceiveAmount() {
		return billReceiveAmount;
	}

	/*setters*/

	
	public void setBillReceiveDetailId(String billReceiveDetailId) {
		this.billReceiveDetailId = billReceiveDetailId;
	}
	
	public void setBillReceiveInvoiceNumber(String billReceiveInvoiceNumber) {
		this.billReceiveInvoiceNumber = billReceiveInvoiceNumber;
	}
	
	public void setBillReceiveCustomerId(String billReceiveCustomerId) {
		this.billReceiveCustomerId = billReceiveCustomerId;
	}
	
	public void setBillReceiveManagerId(String billReceiveManagerId) {
		this.billReceiveManagerId = billReceiveManagerId;
	}
	
	public void setBillReceiveOfficeId(String billReceiveOfficeId) {
		this.billReceiveOfficeId = billReceiveOfficeId;
	}
	
	public void setBillReceiveDate(String billReceiveDate) {
		this.billReceiveDate = billReceiveDate;
	}
	
	public void setBillReceiveRemark(String billReceiveRemark) {
		this.billReceiveRemark = billReceiveRemark;
	}
	
	public void setBillReceiveAmount(String billReceiveAmount) {
		this.billReceiveAmount = billReceiveAmount;
	}
}
