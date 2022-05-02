package com.cagriyilmaz.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//JPA Yapısını sağlar JAP repository Crud repository'den daha geniştir.
//create readt update delete (CRUD)

@Repository
public interface EmployeeRepository extends CrudRepository {

}
