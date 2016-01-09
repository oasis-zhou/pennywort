package insurance.fd.security;

import insurance.fd.security.dao.UserDao;
import insurance.fd.security.dao.pojo.TUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class SystemUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		TUser userPojo = userDao.findByUsername(username);

		User userdetails = new SystemUser(userPojo.getUsername(),
				userPojo.getPassword(),
				getAuthorities(userPojo.getAuthorities()),
				userPojo.getOrganization()
				);

		return userdetails;
	}

	public List<GrantedAuthority> getAuthorities(String authorities) {	    
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		String[] roles = authorities.split(",");
		for(String role : roles){
			authList.add(new SimpleGrantedAuthority(role));
		}

		return authList;
	}

}
