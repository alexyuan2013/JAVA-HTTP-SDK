package com.cmiot.onenet.pojo;

public class CmdStatus {
	private String errno;
	private String error;
	private CmdData data;
	public String getErrno() {
		return errno;
	}
	public void setErrno(String errno) {
		this.errno = errno;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public CmdData getData() {
		return data;
	}
	public void setData(CmdData data) {
		this.data = data;
	}

}
