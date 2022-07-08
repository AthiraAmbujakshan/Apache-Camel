package com.example.demo.Router;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "," ,skipField =true,skipFirstLine = true)
public class Vendor  implements Serializable{

	@DataField(pos=1)
	private String id;
	@DataField(pos=2)
	private String PAYEE_NAME;
	@DataField(pos=3)
     private String EXTERNAL_ID;
	@DataField(pos=4)
     private String SETTLEMENT_ACCOUNT;
	@DataField(pos=5)
     private String ACTIVE;

	public Vendor() {

	}

	public Vendor(String id, String pAYEE_NAME, String eXTERNAL_ID, String sETTLEMENT_ACCOUNT, String aCTIVE) {
		super();
		this.id = id;
		PAYEE_NAME = pAYEE_NAME;
		EXTERNAL_ID = eXTERNAL_ID;
		SETTLEMENT_ACCOUNT = sETTLEMENT_ACCOUNT;
		ACTIVE = aCTIVE;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

