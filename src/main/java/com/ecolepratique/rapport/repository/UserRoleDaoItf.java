package com.ecolepratique.rapport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecolepratique.rapport.entite.UserRole;


public interface UserRoleDaoItf extends JpaRepository<UserRole, Long>{

}
