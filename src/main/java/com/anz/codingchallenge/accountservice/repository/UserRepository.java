package com.anz.codingchallenge.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anz.codingchallenge.accountservice.domain.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long> {

}
