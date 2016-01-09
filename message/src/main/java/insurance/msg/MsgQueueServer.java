package insurance.msg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@ImportResource({"classpath*:META-INF/amqp-beans.xml"})
public class MsgQueueServer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MsgQueueServer.class, args);
    }

}
