package com.nyeon.driverslicense.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.nyeon.driverslicense.model.License;
import com.nyeon.driverslicense.model.Person;
import com.nyeon.driverslicense.repository.PersonRepository;
import com.nyeon.driverslicense.repository.LicenseRepository;

@Service
public class DriversLicenseService {

	private final LicenseRepository lRepo;
	private final PersonRepository pRepo;
	
	public DriversLicenseService(LicenseRepository lRepo, PersonRepository pRepo) {
		this.lRepo = lRepo;
		this.pRepo = pRepo;
	}
	
	//find person by id
	public Person getPerson(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	//find all people
	public List<Person> allPeople(){
		return pRepo.findAll();
	}
	
	//find people without a license
	public List<Person> getUnlicensedPerson() {
		return pRepo.findByLicenseIdIsNull();
	}
	
	//create and update license
	public License saveLicense(License license) {
		license.setNumber(this.generateLicenseNumber());
		return lRepo.save(license);
	}
	
	//create and update person
	public Person savePerson(Person person) {
		return pRepo.save(person);
	}
	
	//generate license number
	public Integer generateLicenseNumber() {
		License license = lRepo.findTopByOrderByNumberDesc();
		if(license==null) {
			return 1;
		}
		else {
			Integer nxtNum = license.getNumber();
			nxtNum++;
			return nxtNum;
		}
	}
}
