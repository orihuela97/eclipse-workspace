
package tidw.jms20.tema4jms.classic;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import tidw.jms20.tema4jms.recursos.Resources;


@Stateless
public class ClassicMessageSender {

    @Resource(lookup = "jms/__defaultConnectionFactory")
	//@Resource(mappedName = Resources.CLASSIC_CONNECTION_FACTORY)
    ConnectionFactory connectionFactory;

    @Resource(mappedName = Resources.CLASSIC_QUEUE)
    Queue demoQueue;

    public void sendMessage(String payload) {
        
    	Connection connection = null;
       
    	try {
    		System.out.println("sendMessage");
            connection = connectionFactory.createConnection();
            System.out.println("connectionFactory");
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(demoQueue);
            TextMessage textMessage = session.createTextMessage(payload);
            messageProducer.send(textMessage);
        
    	} catch (JMSException ex) {
            //ex.printStackTrace();
            System.out.println("Estoy en ClassicMessageSender: " +ex.getErrorCode() + " " + ex.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
