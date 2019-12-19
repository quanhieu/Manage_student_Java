package student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.UnsupportedOperationException;
import person.*;
/**
 *
 * @author Soi Lan Tron
 */
public class Student extends persons {
      private String stdId;
//	private String stdName;
//	private String stdEmail;
	private String stdAddress;
	private String stdBatch;
	private String stdDob;
	private String stdPhone;
	
	public Student(){
		stdId = "unknow";
//		stdName = "unknow";
//		stdEmail = "unknow";
		stdAddress = "unknow";
		stdBatch = "unknow";
		stdDob = "unknow";
		stdPhone = "unknow";
	}
	
	
	public Student(String Name, String Email, String stdId, String stdAddress,
			String stdBatch, String stdDob, String stdPhone) {
		super(Name, Email);
		this.stdId = stdId;
		this.stdAddress = stdAddress;
		this.stdBatch = stdBatch;
		this.stdDob = stdDob;
		this.stdPhone = stdPhone;
	}
    

	public String getStdId() {
		return stdId;
	}

	public void setStdId(String stdId) {
		this.stdId = stdId;
	}

	public String getStdAddress() {
		return stdAddress;
	}

	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}

	public String getStdBatch() {
		return stdBatch;
	}

	public void setStdBatch(String stdBatch) {
		this.stdBatch = stdBatch;
	}

	public String getStdDob() {
		return stdDob;
	}

	public void setStdDob(String stdDob) {
		this.stdDob = stdDob;
	}

	public String getStdPhone() {
		return stdPhone;
	}

	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
}
