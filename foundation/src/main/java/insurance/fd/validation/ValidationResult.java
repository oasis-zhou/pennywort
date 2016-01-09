package insurance.fd.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class ValidationResult implements Serializable {
	private static final long serialVersionUID = 1L;
	private boolean isFailed;
	private List<String> messages = new ArrayList<String>();

	private Map additonalInformations = new HashMap();

	public boolean isFailed() {
		return isFailed;
	}

	public void setFailed(boolean isFailed) {
		this.isFailed = isFailed;
	}

	/**
	 * Add an error message to the result.
	 * @param error The error message to be added.
	 */
	public void addMessage(String error) {
		messages.add(error);
	}

	/**
	 * Get the errors list.
	 * @return The errors list.
	 */
	public List<String> getMessages() {
		return messages;
	}
	
	public String getMergedMessage(){
		StringBuffer result = new StringBuffer("");
		List<String> msgs = this.getMessages();
		
		for(String str : msgs){
			result.append(str).append("\r\n");
		}
		
		return result.toString();
	}

	/**
	 * Get the additional Informations.
	 * @return The additional Informations.
	 */
	@SuppressWarnings("rawtypes")
	public Map getAdditionalInformations() {
		return additonalInformations;
	}

	/**
	 * Add an addtional information to the result.
	 * @param key Key
	 * @param value Value
	 */
	@SuppressWarnings("unchecked")
	public void addAdditionalInformation(Object key, Object value) {
		additonalInformations.put(key, value);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Errors:\r\n");
		for (String error : messages) {
			buffer.append(error);
			buffer.append("\r\n");
		}
	
		buffer.append("Additonal:\r\n");
		for (Object addObj : additonalInformations.values()) {
			buffer.append(addObj);
			buffer.append("\r\n");
		}
		return buffer.toString();
	}
}