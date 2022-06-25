package com.example.examspringboot1.restapi;

import com.example.examspringboot1.dto.ResponseDTO;
import com.example.examspringboot1.entity.Employee;
import com.example.examspringboot1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.examspringboot1.dto.ResponseDTO;
import com.example.examspringboot1.entity.Employee;
import com.example.examspringboot1.service.EmployeeService;


@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin("*")
@Validated
public class EmployeeApi {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ResponseDTO> findAll() {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.OK.toString())
                .body(employeeService.findAll()).build();
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody Employee employee) {
        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.CREATED.toString())
                .body(employeeService.save(employee)).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

}