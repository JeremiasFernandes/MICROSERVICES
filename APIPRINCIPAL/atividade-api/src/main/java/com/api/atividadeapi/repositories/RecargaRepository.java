package com.api.atividadeapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.atividadeapi.models.RecargaModel;

import java.util.List;


@Repository
public interface RecargaRepository extends JpaRepository<RecargaModel, UUID> {
    
    
List<RecargaModel> findByCpfCliente(String cpfCliente);


}
