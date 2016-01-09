package insurance.fd.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SystemUser extends User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8970353108650420310L;

	private final String organization;

	public SystemUser(String username, String password,Collection<? extends GrantedAuthority> authorities, 
			String organization) {
		super(username, password, true, true, true, true, authorities);
	
		this.organization = organization;
	}

	public String getOrganization() {
		return organization;
	}

}
