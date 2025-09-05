package com.forjadoescritor.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forjadoescritor.api.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, UUID> {

}