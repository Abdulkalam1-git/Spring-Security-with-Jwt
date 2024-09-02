package com.telusko.secures.repository;

import com.telusko.secures.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Data, Integer> {
    Data findByUsername(String username);
}
