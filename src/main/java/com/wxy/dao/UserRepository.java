package com.wxy.dao;

import com.wxy.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {
}