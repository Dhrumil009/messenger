package org.learning.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.learning.messenger.model.Profile;

public class ProfileService {

private Map<String,Profile> profiles=DataBase.getProfiles();
	
	public ProfileService() {
		profiles.put("dhrumil", new Profile(1,"dhrumil","Dhrumil","Munshi"));
		profiles.put("neel", new Profile(2,"neel","Neel","Munshi"));
		profiles.put("Gganesh", new Profile(3,"ganesh","Ganesh","Bapa"));
		profiles.put("lala", new Profile(4,"lala","Lala","kanyiya"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile getProfile(String name) {
		if(name.isEmpty()) {
			return null;
		}
		return profiles.get(name);
	}
	
	public Profile updatePrifile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeMessage(String name) {
		if(name.isEmpty()) {
			return null;
		}
		return profiles.remove(name);
	}

}
