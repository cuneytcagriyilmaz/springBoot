package com.cagriyilmaz.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
//JPA yapısı Crud'dan daha geniştir.
public interface EmployeeRepository extends JpaRepository {
    //Kodlama içerisindeki JPA Hibernate işlemlerini kullanacak yapılardır
}

 */

@Repository
public interface EmployeeRepository extends CrudRepository {
    //Kodlama içerisindeki JPA Hibernate işlemlerini kullanacak yapılardır
}
