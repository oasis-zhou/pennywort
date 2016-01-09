package insurance.fd.conf;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:system.properties")
public class SystemConfig {
	@Autowired
	private Environment env;

	public Environment env(){
		return this.env;
	}

	public SimpleDateFormat getSysDateFormat(){
		String dateFormatStr = this.env.getProperty("date.format");
		SimpleDateFormat format = new SimpleDateFormat(dateFormatStr);
		return format;
	}
}
