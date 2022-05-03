package com.cagriyilmaz.data.repository;

import com.cagriyilmaz.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//JPA Yapısını sağlar JAP repository Crud repository'den daha geniştir.
//create readt update delete (CRUD)

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
