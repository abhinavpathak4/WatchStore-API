package com.watches.loginRegisterApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watches.loginRegisterApi.model.Users;

public interface LoginDao extends JpaRepository<Users,String>{

}
