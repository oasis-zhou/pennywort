package insurance.fd.security;

import org.springframework.security.core.Authentication;


public interface AuthorityManager {
	
	public Authentication getAuthentication();
	
	public boolean hasRole(String role);
	
	public String currentUserName();
	
	public String getOrganization();
}
