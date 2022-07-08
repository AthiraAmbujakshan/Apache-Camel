package com.cognizant.test.containers;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;

@CsvRecord(separator = "," ,skipField =true,skipFirstLine = true)
public class Vendor  {

	private int id;
	private String PAYEE_NAME;
     private String EXTERNAL_ID;
     private String SETTLEMENT_ACCOUNT;
     private String ACTIVE;

	public Vendor() {

	}

	public Vendor(int id, String pAYEE_NAME, String eXTERNAL_ID, String sETTLEMENT_ACCOUNT, String aCTIVE) {
		super();
		this.id = id;
		PAYEE_NAME = pAYEE_NAME;
		EXTERNAL_ID = eXTERNAL_ID;
		SETTLEMENT_ACCOUNT = sETTLEMENT_ACCOUNT;
		ACTIVE = aCTIVE;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPAYEE_NAME() {
		return PAYEE_NAME;
	}

	public void setPAYEE_NAME(String pAYEE_NAME) {
		PAYEE_NAME = pAYEE_NAME;
	}

	public String getEXTERNAL_ID() {
		return EXTERNAL_ID;
	}

	public void setEXTERNAL_ID(String eXTERNAL_ID) {
		EXTERNAL_ID = eXTERNAL_ID;
	}

	public String getSETTLEMENT_ACCOUNT() {
		return SETTLEMENT_ACCOUNT;
	}

	public void setSETTLEMENT_ACCOUNT(String sETTLEMENT_ACCOUNT) {
		SETTLEMENT_ACCOUNT = sETTLEMENT_ACCOUNT;
	}

	public String getACTIVE() {
		return ACTIVE;
	}

	public void setACTIVE(String aCTIVE) {
		ACTIVE = aCTIVE;
	}

}