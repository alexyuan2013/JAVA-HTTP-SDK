package com.cmiot.onenet.pojo;

public class BasicCmd {
	private Integer msgType;
	private Integer cmdType;
	private String SN;
	
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	public Integer getCmdType() {
		return cmdType;
	}
	public void setCmdType(Integer cmdType) {
		this.cmdType = cmdType;
	}
	public String getSN() {
		return SN;
	}
	public void setSN(String sN) {
		SN = sN;
	}
	
}
