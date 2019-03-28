package it.dstech.tornei.config.exception;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1L;

	public String code;

	public BadRequestException(String code, String message) {
		super(message);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
