package com.suresh.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercise")
public class Exercise {
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "code_list")
	private String codeList;
	
	@Id
	@Column(name = "code")
	private String code;
	
	@Column(name = "display_value")
	private String displayValue;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "from_date")
	private String fromDate;
	
	@Column(name = "to_date")
	private String toDate;
	
	@Column(name = "sorting_priority")
	private String sortingPriority;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCodeList() {
		return codeList;
	}

	public void setCodeList(String codeList) {
		this.codeList = codeList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getSortingPriority() {
		return sortingPriority;
	}

	public void setSortingPriority(String sortingPriority) {
		this.sortingPriority = sortingPriority;
	}

	@Override
	public String toString() {
		return "Exercise [source=" + source + ", codeList=" + codeList + ", code=" + code
				+ ", displayValue=" + displayValue + ", discription=" + discription + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", sortingPriority=" + sortingPriority + "]";
	}

	public Exercise(String source, String codeList, String code, String displayValue, String discription,
			String fromDate, String toDate, String sortingPriority) {
		super();
		this.source = source;
		this.codeList = codeList;
		this.code = code;
		this.displayValue = displayValue;
		this.discription = discription;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.sortingPriority = sortingPriority;
	}
	
	public Exercise() {
		
	}
	
	

}
