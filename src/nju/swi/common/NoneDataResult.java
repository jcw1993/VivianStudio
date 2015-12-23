package nju.swi.common;

public class NoneDataResult {
	private int code;
	private String message;
	
	public NoneDataResult() {
		this.code = ResultCode.OK;
	}
	
	public NoneDataResult(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public NoneDataResult setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public NoneDataResult setMessage(String message) {
		this.message = message;
		return this;
	}
	
}
