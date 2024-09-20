package com.example.registrationservice.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.registrationservice.Model.Registration;
import com.example.registrationservice.service.Regservice;

@RestController
@RequestMapping("/api/reg")
@CrossOrigin(origins="http://localhost:4200/")
public class Regcontroller {
	
	private Regservice service;

	
	
	
	public Regcontroller(Regservice service) {
		super();
		this.service = service;
	}
	@PostMapping("/create")
	public ResponseEntity<Registration> saveRegistration(@RequestBody Registration reg)
	{
		
		return new ResponseEntity<Registration>(service.saveRegistration(reg),HttpStatus.CREATED);
		
		
	}
	@GetMapping
	public List<Registration> getAllRegistartions()
	{
		
		return service.getAllRegistration();
	}
	
	@PutMapping("{id}")

	public ResponseEntity<Registration> updateRegistration(@PathVariable("id")long id,@RequestBody Registration reg)
	{
		return new ResponseEntity<Registration>(service.updateregistration(reg, id),HttpStatus.OK);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteRegistartion(@PathVariable("id")long id)

	{
		service.DeleteRegistartion(id);
	    return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
	}
}
