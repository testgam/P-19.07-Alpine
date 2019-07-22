package me.m11m.p1907.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.m11m.p1907.model.MyUser;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{
        
}