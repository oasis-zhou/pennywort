package insurance.fd.conf;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import akka.actor.ActorSystem;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

@Configuration
@Lazy
public class ApplicationConfiguration {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected SpringExtension springExtension;

    protected String actorSystemName;

    @PostConstruct
    protected void initialize() {
    	actorSystemName = config().getString("system-name");
        
        springExtension.initialize(applicationContext);
    }

    @Bean
    protected ActorSystem actorSystem() {
        return ActorSystem.create(actorSystemName, config());
    }

    /**
     * load configuration from application.conf file
     */
    @Bean
    protected Config config() {
        return ConfigFactory.load();
    }

  
}
