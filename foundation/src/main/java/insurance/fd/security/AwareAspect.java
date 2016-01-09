package insurance.fd.security;

import insurance.fd.model.BaseEntity;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Aspect
@Component
public class AwareAspect {

	private static final String ALL_PERMITTED = "_ALL_PERMITTED";

	@Autowired
	private AuthorityManager authManager;

	@Pointcut("execution(public * find*(..))")
	public void publicFindMethod() {
	}

	@Pointcut("target(insurance.fd.security.OrganizationAware)")
	public void isOrganizationAware() {
	}

	@Pointcut("target(org.springframework.data.repository.CrudRepository)")
	public void isCrudDao() {
	}

	@Around(value = "publicFindMethod() && isCrudDao() && isOrganizationAware()")
	public Object companyAware(final ProceedingJoinPoint joinPoint)
			throws Throwable {
		Object retVal = joinPoint.proceed();
		if (retVal == null)
			return retVal;
		String currentUserOrganization = authManager.getOrganization();
		if (authManager.hasRole("ROLE_ADMIN"))
			return retVal;
		if (retVal instanceof List) {
			List<?> newRetVal = Lists.newArrayList((List<?>) retVal);
			for (Object it : (List<?>) retVal) {
				if (it instanceof BaseEntity) {
					boolean isAccessible = ((BaseEntity) it).getOrganization().equals(ALL_PERMITTED)
							|| currentUserOrganization.equals(((BaseEntity) it).getOrganization());
					if (!isAccessible)
						newRetVal.remove(it);
				}
			}
			retVal = newRetVal;
		} else if (retVal instanceof BaseEntity
				&& ((BaseEntity) retVal).getOrganization() != null) {
			boolean isAccessible = ((BaseEntity) retVal).getOrganization().equals(ALL_PERMITTED)
					|| currentUserOrganization.equals(((BaseEntity) retVal).getOrganization());
			if (!isAccessible)
				retVal = null;
		}
		return retVal;
	}

}
