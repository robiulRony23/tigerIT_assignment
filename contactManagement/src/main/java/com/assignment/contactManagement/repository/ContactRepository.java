package com.assignment.contactManagement.repository;

import com.assignment.contactManagement.model.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact,Long>{


    @Query(value = "SELECT * FROM CONTACT where lower(first_name) like %:keyword% or lower(last_name) like %:keyword% " +
            "or lower(email) like %:keyword% or phone_no like %:keyword%",nativeQuery = true)
    List<Contact> findByKeyword(String keyword);

    @Query(value = "SELECT * FROM CONTACT where lower(first_name) like %:keyword%",nativeQuery = true)
    List<Contact> findByFirstName(String keyword);

    @Query(value = "SELECT * FROM CONTACT where lower(last_name) like %:keyword%",nativeQuery = true)
    List<Contact> findByLastName(String keyword);

    @Query(value = "SELECT * FROM CONTACT where lower(email) like %:keyword%",nativeQuery = true)
    List<Contact> findByEmail(String keyword);

    @Query(value = "SELECT * FROM CONTACT where lower(phone_no) like %:keyword%",nativeQuery = true)
    List<Contact> findByPhoneNo(String keyword);
}
