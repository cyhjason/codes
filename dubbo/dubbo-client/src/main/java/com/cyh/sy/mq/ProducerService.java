package com.cyh.sy.mq;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("producerService")
public class ProducerService {

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
    
    @Resource(name="topicJmsTemplate")
    private JmsTemplate topicJmsTemplate;
       
    /**
     * 向指定队列发送消息
     */
    public void sendMessage(Destination destination, final String msg) {
    	System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
        	public Message createMessage(Session session) throws JMSException {
	            return session.createTextMessage(msg);
	          }
        });
    }
    
    /**
     * 向指定队列发送消息
     */
    public void sendTopMessage(Destination destination, final String msg) {
    	System.out.println("向队列" + destination.toString() + "发送了消息------------" + msg);
    	topicJmsTemplate.send(destination, new MessageCreator() {
        	public Message createMessage(Session session) throws JMSException {
	            return session.createTextMessage(msg);
	          }
        });
    }
    
    /**
     * 向默认队列发送消息
     */
    public void sendMessage(final String msg) {
        String destination =  jmsTemplate.getDefaultDestination().toString();
        System.out.println("向队列" +destination+ "发送了消息------------" + msg);
        jmsTemplate.send(new MessageCreator() {
        	public Message createMessage(Session session) throws JMSException {
        		return session.createTextMessage(msg);
        	}
        });
     
    }
    
}