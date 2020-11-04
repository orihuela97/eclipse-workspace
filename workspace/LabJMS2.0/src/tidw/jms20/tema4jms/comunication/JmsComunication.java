package tidw.jms20.tema4jms.comunication;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 * http://www.oracle.com/technetwork/articles/java/jms20-1947669.html
 * http://www.oracle.com/technetwork/articles/java/jms2messaging-1954190.html
 */
public class JmsComunication {
	
	@Inject 
	@JMSConnectionFactory("jms/cf1.1")
	private JMSContext _context;

	/*
	 * @Resource(mappedName = "jms/cf1.1") private static JMSConnectionFactory
	 * _connectionFactory;
	 */
	@Resource(mappedName = "jms/queue1.1")
	private static Queue _queue;

	public void sendMessageJMS20(String mensaje) {
		
		try {
			System.out.println("sendMessageJMS20 antes");
			System.out.println("sendMessageJMS20: " + _context.toString());
			_context.createProducer().send(_queue, mensaje);
			
		} catch (JMSRuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * try (JMSContext context = _connectionFactory.createContext();) {
		 * context.createProducer().send(_queue, text); } catch (JMSRuntimeException
		 * excepcion) { // handle exception (details omitted) }
		 */
	}

	public String receiveMessageJMS20() {
		
		String cuerpoMensaje = null;
		
		try  {
			JMSConsumer consumer = _context.createConsumer(_queue);
			cuerpoMensaje = (consumer.receiveBody(TextMessage.class, 100)).toString();
		} catch (JMSRuntimeException ex) {
			// handle exception (details omitted)
		}
		return cuerpoMensaje;
	}

}
