package nett.formacion.aaa.module4.soap.songs.exceptions;

import javax.xml.ws.WebFault;

@WebFault
public class SongException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7256660911504707950L;
	
	private String errorCode;
	private String errorText;
	
	public SongException() 
	{
		super();
	}
	
	public SongException(String errorCode, String errorText)
	{
		super();
		this.errorCode = errorCode;
		this.errorText = errorText;
	}
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
}
