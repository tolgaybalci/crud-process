package com.example.crudprocess.repository;

import com.example.crudprocess.domain.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends CrudRepository<Material, Long>{


}
