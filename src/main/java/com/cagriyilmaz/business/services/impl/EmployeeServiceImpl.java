package com.cagriyilmaz.business.services.impl;

import com.cagriyilmaz.business.dto.EmployeeDto;
import com.cagriyilmaz.business.services.EmployeeServices;
import com.cagriyilmaz.data.entity.EmployeeEntity;
import com.cagriyilmaz.data.repository.EmployeeRepository;
import com.cagriyilmaz.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EmployeeServiceImpl implements EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    //LIST
    // http://localhost:8001/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> teacherList = employeeRepository.findAll();
        for (EmployeeEntity entity : teacherList) {
            EmployeeDto employeeDto  = EntityToDto(entity);//model
            listDto.add(employeeDto);
        }
        return listDto;
    }

    //SAVE
    // http://localhost:8001/api/v1/employees
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);//ModelMapper
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    //FIND
    // http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) throws Throwable {
        EmployeeEntity employee=
                (EmployeeEntity) employeeRepository
                        .findById(id)
                        .orElseThrow(
                                ()->new ResourceNotFoundException("Employee "+id+" numaralı product id bulunamadı !!!!")
                        );
        EmployeeDto employeeDto = EntityToDto(employee);//model
        return ResponseEntity.ok(employeeDto);
    }


    //UPDATE
    // http://localhost:8001/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);//ModelMapper

        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName( employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());
        EmployeeEntity updatedEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updatedEmployee);//model
        return ResponseEntity.ok(employeeDto);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        return null;
    }

    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        return null;
    }


    ////////////////////////////////////
    //Model Mapper Entity ==> Dto
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    //Model Mapper Dto  ==> Entity
    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
