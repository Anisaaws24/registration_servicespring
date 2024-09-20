package com.example.registrationservice.service;

import java.util.List;


import com.example.registrationservice.Model.Registration;

public interface Regservice {
	
	Registration saveRegistration(Registration reg);
	
	List<Registration>getAllRegistration();
	List<Registration>insertAllRegistration(List <Registration> s);
	
	void DeleteRegistartion(long id);
	
	Registration updateregistration(Registration reg,long id);

	
	

}
