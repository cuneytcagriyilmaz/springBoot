package com.cagriyilmaz;

import com.cagriyilmaz.data.entity.EmployeeEntity;
import com.cagriyilmaz.data.repository.EmployeeRepository;
import com.cagriyilmaz.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests implements TestCrud {


    //Database e ekledi mi
    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
    }

    //Create
    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Hamit Test")
                .lastName("Mızrak Test")
                .emailId("hamitmizrak@gmail.com")
                .build();
        employeeRepository.save(employeeEntity);

        //Nesne NULL ise assertionError hatası göndersin
        assertNotNull(employeeRepository.findById(1L).get());

    }
    //List Test
    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();
        //eğer 0 dan büyükse liste vardır.
        assertThat(list).size().isGreaterThan(0);

    }

    //FindById
    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();

        //Hamit Tesdt adında kayıt varmı
        assertEquals("Hamit Test",employeeEntity.getFirstName());
    }

    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Hamir 44 Test");
        employeeRepository.save(employeeEntity);

        //Eşit değilse bir sorun olmayacak ama eşitse exception fırlatsın
        //1. kayda göree verileri gertir (1L)
        assertNotEquals("Hamit Test",employeeRepository.findById(1L).get().getFirstName());

    }

    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        assertThat(employeeRepository.existsById(1L)).isFalse();

    }
}
