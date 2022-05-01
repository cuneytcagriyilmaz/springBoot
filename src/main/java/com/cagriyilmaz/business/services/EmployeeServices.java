package com.cagriyilmaz.business.services;

import com.cagriyilmaz.business.dto.EmployeeDto;
import com.cagriyilmaz.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    //CRUD
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) throws Throwable;


    //model mapper
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity);
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto);

    ////////////////////////////////////
    //Model Mapper Entity ==> Dto
    EmployeeDto entityToDto(EmployeeEntity employeeEntity);

    //Model Mapper Dto  ==> Entity
    EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}
