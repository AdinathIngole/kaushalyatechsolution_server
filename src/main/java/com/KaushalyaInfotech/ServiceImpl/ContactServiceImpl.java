package com.KaushalyaInfotech.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KaushalyaInfotech.Entity.ContactList;
import com.KaushalyaInfotech.Repository.ContactRepository;
import com.KaushalyaInfotech.Service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public ContactList saveContactList(ContactList contactList) {
		
		return contactRepo.save(contactList);

	}

}
