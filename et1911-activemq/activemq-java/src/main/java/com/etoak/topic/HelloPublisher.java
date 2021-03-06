package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;



public class HelloPublisher {

	public static void main(String[] args) throws JMSException {
		
		// 1.
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		// 2.
		Connection connection = factory.createConnection();
		connection.start();
		
		// 3.
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 4.
		Topic topic = session.createTopic("topic");
		
		// 5.
		MessageProducer producer = session.createProducer(topic);
		
		// 6.创建消息
		MapMessage msg = session.createMapMessage();
		msg.setString("name", "topic msg");
		msg.setInt("id", 1);
		
		// 7.发送消息
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
		
		
	}

}
