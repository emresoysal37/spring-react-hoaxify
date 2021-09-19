package com.hoaxify.ws.hoax;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoaxify.ws.user.User;

@Service(value = "hoaxSecurity")
public class HoaxSecurityService {
	
	@Autowired
	HoaxRepository hoaxRepository;
	
	public boolean isAllowedToDelete(long id, User loggedInUser) {
		Optional<Hoax> optionalHoax = hoaxRepository.findById(id);
		if(!optionalHoax.isPresent()) {
			return false;
		}
		Hoax inDB = optionalHoax.get();
		if(inDB.getUser().getId() != loggedInUser.getId()) {
			return false;
		}
		return true;
	}
}
