package org.learning.messenger.service;

import java.util.HashMap;
import java.util.Map;

import org.learning.messenger.model.Message;
import org.learning.messenger.model.Profile;

public class DataBase {
	
	private static Map<Long,Message> messages=new HashMap<>();
	private static Map<Long,Profile> profiles=new HashMap<>();
	
		
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
