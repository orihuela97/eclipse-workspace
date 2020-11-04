package tidw.jms20.tema4jms.recursos;

import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;

@JMSDestinationDefinitions({
    @JMSDestinationDefinition(
        name = Resources.CLASSIC_QUEUE,
        resourceAdapter = "jmsra",
        interfaceName = "javax.jms.Queue",
        destinationName = "classicQueue",
        description = "My Sync Queue"),
    @JMSDestinationDefinition(name = Resources.ASYNC_QUEUE,
        resourceAdapter = "jmsra",
        interfaceName = "javax.jms.Queue",
        destinationName = "asyncQueue",
        description = "My Async Queue"),
    @JMSDestinationDefinition(name = Resources.SYNC_APP_MANAGED_QUEUE,
        resourceAdapter = "jmsra",
        interfaceName = "javax.jms.Queue",
        destinationName = "syncAppQueue",
        description = "My Sync Queue for App-managed JMSContext"),
    @JMSDestinationDefinition(name = Resources.SYNC_CONTAINER_MANAGED_QUEUE,
        resourceAdapter = "jmsra",
        interfaceName = "javax.jms.Queue",
        destinationName = "syncContainerQueue",
        description = "My Sync Queue for Container-managed JMSContext")
})

@JMSConnectionFactoryDefinition(
		name=Resources.CLASSIC_CONNECTION_FACTORY,
		resourceAdapter = "jmsra",
	    interfaceName = "javax.jms.ConnectionFactory",
	    description = "My Sync Queue"	
)


public class Resources {
	
    public static final String SYNC_APP_MANAGED_QUEUE = "java:global/jms/mySyncAppQueue";
    public static final String SYNC_CONTAINER_MANAGED_QUEUE = "java:global/jms/mySyncContainerQueue";
    public static final String ASYNC_QUEUE = "java:global/jms/myAsyncQueue";
    public static final String CLASSIC_QUEUE = "java:global/jms/classicQueue";
    public static final String CLASSIC_CONNECTION_FACTORY = "java:global/jms/DefaultJMSConnectionFactory";
    
}
