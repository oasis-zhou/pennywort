package insurance.fd.conf;

import akka.actor.Actor;
import akka.actor.Extension;
import akka.actor.IndirectActorProducer;
import akka.actor.Props;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringExtension implements Extension {

    private ApplicationContext applicationContext;

    /**
     * Used to initHandler the Spring application context for the extension.
     */
    public void initialize(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Create a Props for the specified actorBeanName using the
     * SpringActorNamedProducer class.
     */
    public Props props(String actorBeanName) {
        return Props.create(NamedProducer.class, applicationContext, actorBeanName);
    }

    /**
     * Create a Props for the specified actorClass using the
     * SpringActorTypedProducer class.
     */
    public Props props(Class<? extends Actor> actorClass) {
        return Props.create(TypedProducer.class, applicationContext, actorClass);
    }

    /**
     * An actor producer that lets Spring create the Actor instances by type.
     */
    private static class TypedProducer implements IndirectActorProducer {

        private final ApplicationContext applicationContext;
        private final Class<? extends Actor> actorClass;

        public TypedProducer(ApplicationContext applicationContext, Class<? extends Actor> actorClass) {
            this.applicationContext = applicationContext;
            this.actorClass = actorClass;
        }

        @Override
        public Actor produce() {
            return applicationContext.getBean(actorClass);
        }

        @Override
        public Class<? extends Actor> actorClass() {
            return actorClass;
        }
    }

    /**
     * An actor producer that lets Spring create the Actor instances by name.
     */
    private static class NamedProducer implements IndirectActorProducer {

        private final ApplicationContext applicationContext;
        private final String actorBeanName;

        public NamedProducer(ApplicationContext applicationContext, String actorBeanName) {
            this.applicationContext = applicationContext;
            this.actorBeanName = actorBeanName;
        }

        @Override
        public Actor produce() {
            return (Actor) applicationContext.getBean(actorBeanName);
        }

        @Override
        public Class<? extends Actor> actorClass() {
            return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
        }
    }
}
