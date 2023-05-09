package com.api.atividadeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.atividadeapi.models.ClienteModel;

import java.util.List;
import java.util.UUID;




@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {
    
 List<ClienteModel> findByCpf(String cpf);

boolean existsByCpf(String cpf);

}
