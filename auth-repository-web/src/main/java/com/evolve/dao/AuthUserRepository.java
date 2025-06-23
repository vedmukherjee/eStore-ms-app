package com.evolve.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evolve.domain.Usr;

@Repository
public interface AuthUserRepository extends JpaRepository<Usr, Long> {
}
