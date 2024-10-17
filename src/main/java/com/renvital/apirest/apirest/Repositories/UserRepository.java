package com.renvital.apirest.apirest.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.renvital.apirest.apirest.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
