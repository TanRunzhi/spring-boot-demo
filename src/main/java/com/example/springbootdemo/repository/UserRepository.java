package com.example.springbootdemo.repository;

import com.example.springbootdemo.entities.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SysUser,String> {



}
