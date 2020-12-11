package com.ibm.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.login.entity.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, String>{

}
