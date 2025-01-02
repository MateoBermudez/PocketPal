package com.devcrew.logmicroservice.repository;

import com.devcrew.logmicroservice.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ActionRepository extends JpaRepository<Action, Integer> {

    @Query("SELECT a FROM Action a WHERE a.name = ?1")
    Optional<Action> findByName(String name);
}