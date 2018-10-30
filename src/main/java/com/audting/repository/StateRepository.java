package com.audting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audting.model.State;
@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
