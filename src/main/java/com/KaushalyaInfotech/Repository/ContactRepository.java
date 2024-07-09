package com.KaushalyaInfotech.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.KaushalyaInfotech.Entity.ContactList;

@Repository
public interface ContactRepository extends JpaRepository<ContactList, Long> {

}
