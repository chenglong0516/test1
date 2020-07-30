package com.chenglong.test1.exception;


/**
 * @description 自定义异常
 * @param
 * @author wrx
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 8697649909241391892L;

	/**
	 * 特殊意义的编码
	 */
	private String code;
	/**
	 * 消息
	 */
	private String msg;

	public BusinessException(String code, String msg, Throwable cause) {
		super(cause);
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(String msg, Throwable cause) {
		super(cause);
		this.msg = msg;
	}

	public BusinessException(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
