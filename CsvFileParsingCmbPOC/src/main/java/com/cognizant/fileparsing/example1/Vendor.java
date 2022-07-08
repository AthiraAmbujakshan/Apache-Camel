package com.cognizant.fileparsing.example1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@Entity   
@CsvRecord(separator = "," ,skipFirstLine = true)
@Table(name ="vendor")
public class Vendor implements Serializable {

@Id
@Column(name="id")
@DataField(pos = 1)
private int id;

   @DataField(pos = 2)
   private String PAYEE_NAME;

    @DataField(pos = 3)
    @Column(name="EXTERNAL_ID")
 private String EXTERNAL_ID;

      @DataField(pos = 4)
      @Column(name="SETTLEMENT_ACCOUNT")
   private String SETTLEMENT_ACCOUNT;

      

      @DataField(pos = 5)
      @Column(name="ACTIVE")
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