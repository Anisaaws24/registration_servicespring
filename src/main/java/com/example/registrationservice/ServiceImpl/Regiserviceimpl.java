package com.example.registrationservice.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.registrationservice.Exception.ResourceNotFoundException;
import com.example.registrationservice.Model.Registration;
import com.example.registrationservice.Repository.RegistrationRepo;
import com.example.registrationservice.service.Regservice;

@Service
public class Regiserviceimpl implements Regservice {
	@Autowired
	private RegistrationRepo repo;
	

	@Override
	public Registration saveRegistration(Registration reg) {
		// TODO Auto-generated method stub
		return repo.save(reg);
	}

	public Regiserviceimpl(RegistrationRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Registration> getAllRegistration() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void DeleteRegistartion(long id) {
		// TODO Auto-generated method stub
		
		
		repo.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Registration","Id",id));
			repo.deleteById(id);
		
		
	}

	@Override
	public Registration updateregistration(Registration reg, long id) {
		// TODO Auto-generated method stub
		Registration  existingRegistartion=repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Registartion","Id",id));
		
		existingRegistartion.setName(reg.getName());
		existingRegistartion.setExperience(reg.getExperience());
		existingRegistartion.setDomain(reg.getDomain());
		existingRegistartion.setEmail(reg.getEmail());
		return existingRegistartion;
		
	}

	@Override
	public List<Registration> insertAllRegistration(List<Registration> s) {
		// TODO Auto-generated method stub
		return repo.saveAll(s);
	}

	
	
	
	
	

}
