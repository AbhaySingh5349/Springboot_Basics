package com.example.Springboot_Basics.JpaHibernate.repository;

import com.example.Springboot_Basics.JpaHibernate.model.JpaPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepo extends JpaRepository<JpaPerson, Integer> {
}
