package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProducer {

	public static void main(String[] args)throws JMSException {
		
		// 1.创建ConnectionFactory  连接工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		// 2.创建Connection  连接
		Connection connection = factory.createConnection();
		
		// 3.创建Session  会话 					  是否支持事务	Session.AUTO_ACKNOWLEDGE为自动确认
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		// 4.创建Destination
		Queue helloQueue = session.createQueue("hello");
		
		// 5.通过Session创建消息生产者
		MessageProducer producer = session.createProducer(helloQueue);
		
		// 6.通过Session创建消息
		TextMessage msg = session.createTextMessage("这是第一个Hello World消息");
		
		// 7.使用消息发送者发送消息
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
		
		System.out.println("OK");
				
	}
}
