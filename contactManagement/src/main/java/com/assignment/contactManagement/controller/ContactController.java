package com.assignment.contactManagement.controller;

import com.assignment.contactManagement.model.Contact;
import com.assignment.contactManagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class ContactController {
    ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/contacts";
    }

    @GetMapping("/contacts")
    public String getAllContacts(Model model){
        model.addAttribute("contacts",contactService.getAllContacts());
        return "contacts_list";
    }

    @GetMapping("/contacts/addNewContact")
    public String addContact(Model model){
        Contact contact = new Contact();
        model.addAttribute("contact",contact);
        return "add_contact";
    }

    @PostMapping("/contacts/saveContact")
    public String saveContact(@ModelAttribute("contact") Contact contact){
        contactService.addContact(contact);
        return "redirect:/contacts";
    }

    @PostMapping("/contacts/updateContact/{id}")
    public String updateContact(@ModelAttribute("contact") Contact contact, @PathVariable Long id){
        Contact existingContact = contactService.getContactById(id);
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhoneNo(contact.getPhoneNo());

        contactService.addContact(existingContact);

        return "redirect:/contacts";
    }

    @GetMapping("/contacts/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

    @GetMapping("/contacts/editContact/{id}")
    public String editContact(@PathVariable Long id, Model model){
//        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact",contactService.getContactById(id));
        return "edit_contact";
    }
}
