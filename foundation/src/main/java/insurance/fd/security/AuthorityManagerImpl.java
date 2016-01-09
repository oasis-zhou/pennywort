package insurance.fd.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorityManagerImpl implements AuthorityManager {

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public boolean hasRole(String role) {
		if (getAuthentication() == null)
			return false;
        return getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority(role));
	}

	@Override
	public String currentUserName() {
		return getAuthentication().getName();
	}
	
	public SystemUser getSystemUser() {
		if(getAuthentication()!=null && getAuthentication().getPrincipal() instanceof SystemUser) {
			return (SystemUser)getAuthentication().getPrincipal();
		}
		return null;
	}

	@Override
	public String getOrganization() {
		if(getSystemUser()!=null)
			return getSystemUser().getOrganization();
		return "_UNKNOWN";
	}

}
