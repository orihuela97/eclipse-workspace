package tidw.jms20.tema4jms.appmanaged;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import tidw.jms20.tema4jms.recursos.Resources;


@Stateless
public class MessageReceiverAppManaged {

    @Resource
    private ConnectionFactory factory;

    @Resource(mappedName = Resources.SYNC_APP_MANAGED_QUEUE)
    Queue myQueue;

    public String receiveMessage() {
        try (JMSContext context = factory.createContext()) {
            return context.createConsumer(myQueue).receiveBody(String.class, 1000);
        }
    }
}
