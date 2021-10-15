package com.assignment.contactManagement.repository;

import com.assignment.contactManagement.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long>{
}
