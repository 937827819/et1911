package com.etoak.selector;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SelectorProducer {
	
	public static void main(String[] args) throws JMSException{
		
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue queue = session.createQueue("selector");
		
		MessageProducer producer = session.createProducer(queue);
		
		// 设置消息持久化
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		TextMessage msg = session.createTextMessage("山东易途:趵突泉北路 蓝石大厦401");
		
		// 设置选择器
		msg.setStringProperty("name", "etoak");
		msg.setIntProperty("age", 11);
		
		TextMessage msg2 = session.createTextMessage("济南易途:山大路 数码港大厦");
		msg2.setIntProperty("age", 2);
		
		producer.send(msg);
		producer.send(msg2);
		
		producer.close();
		session.close();
		connection.close();
		
	}
}
