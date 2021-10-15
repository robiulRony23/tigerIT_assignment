package com.assignment.contactManagement.service;

import com.assignment.contactManagement.model.Contact;
import com.assignment.contactManagement.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContactService {

    ContactRepository contactRepository;
    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts(){
        List<Contact> contacts = new ArrayList<Contact>();
        contactRepository.findAll().forEach(
                contact -> contacts.add( contact)
        );
        return contacts;
    }

    public List<Contact> getContactsByKeyword(String keyword){
        return contactRepository.findByKeyword(keyword);
    }

    public List<Contact> getContactsByFirstName(String keyword){
        return contactRepository.findByFirstName(keyword);
    }

    public List<Contact> getContactsByLastName(String keyword){
        return contactRepository.findByLastName(keyword);
    }

    public List<Contact> getContactsByEmail(String keyword){
        return contactRepository.findByEmail(keyword);
    }

    public List<Contact> getContactsByPhoneNo(String keyword){
        return contactRepository.findByPhoneNo(keyword);
    }

    public void addContact(Contact contact){
        contactRepository.save(contact);
    }

    public void deleteContact(Long id){
        contactRepository.deleteById(id);
    }

    public Contact getContactById(Long id){
        return contactRepository.findById(id).get();
    }


}
