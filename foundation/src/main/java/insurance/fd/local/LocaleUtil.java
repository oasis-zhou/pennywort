package insurance.fd.local;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleUtil {
	
    public static Locale getLocale()   
    {  
    	Locale locale = LocaleContextHolder.getLocale();
    	if (locale == null)
    		return Locale.SIMPLIFIED_CHINESE;
    	else
    		return locale;
    }
    
}
