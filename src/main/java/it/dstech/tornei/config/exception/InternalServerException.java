package it.dstech.tornei.config.exception;

public class InternalServerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public InternalServerException(String code, String message) {
		super(message);
		this.code = code;
	}

}
