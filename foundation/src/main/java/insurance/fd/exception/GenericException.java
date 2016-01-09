package insurance.fd.exception;

import insurance.fd.context.AppContext;
import insurance.fd.local.LocalResourceBundleMessageSource;


public class GenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4214471812942123410L;
	private Long errCode;
	private String dynamicStr;
	private LocalResourceBundleMessageSource msgSource;

	public GenericException(Long errCode){
		this.errCode = errCode;
		this.msgSource = AppContext.getBean("messageSource",LocalResourceBundleMessageSource.class);
	}
	
	public GenericException(Long errCode,String dynamicStr){
		this.errCode = errCode;
		this.dynamicStr = dynamicStr;
		this.msgSource = AppContext.getBean("messageSource",LocalResourceBundleMessageSource.class);
	}

	public GenericException(Long errCode, Throwable cause) {
		super(cause);
		this.errCode = errCode;
	}

	public Long getErrorCode() {
		return errCode;
	}

	public String getMessage(){
		String msg = msgSource.getMessage(String.valueOf(this.errCode));
		msg.replace("$$", dynamicStr);
		return msg;
	}

}
