package org.learning.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.learning.messenger.exception.DataNotFoundException;
import org.learning.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages=DataBase.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1,"Hello World !!","Dhrumil"));
		messages.put(2L, new Message(2,"Hello World !!","Neel"));
		messages.put(3L, new Message(3,"Hello World !!","Ganesh"));
		messages.put(4L, new Message(4,"Hello World !!","Lala"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message getMessage(long Id) {
		if(Id <= 0) {
			return null;
		}
		Message message=messages.get(Id);
		if(message == null) {
			throw new DataNotFoundException("message with id not found");
		}
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long Id) {
		if(Id <= 0) {
			return null;
		}
		return messages.remove(Id);
	}
	
	public List<Message> getMessageByYear(int year) {
		List<Message> yearList=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		List<Message> msgList=getAllMessages();
		for(Message msg:msgList) {
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				yearList.add(msg);
			}
		}
		return yearList;
	}
	
	public List<Message> getMessageByPage(int start,int size){
		 List<Message> msgs= getAllMessages();
		 if(msgs.size() < (start+size)) {
			 return new ArrayList<>(); 		
		}
		 return  msgs.subList(start, start+size);
	}


}