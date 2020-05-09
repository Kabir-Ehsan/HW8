package com.example.hw8_backend.Resource;

import com.example.hw8_backend.Entity.EmployeeEntity;
import com.example.hw8_backend.Exceptions.RecordNotFoundException;
import com.example.hw8_backend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeResource {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/1")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
    {
        List<EmployeeEntity> list = employeeService.getAllEmployees();
       return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        EmployeeEntity entity = employeeService.getEmployeeByID(id);
        return new ResponseEntity<EmployeeEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(EmployeeEntity employee)
            throws RecordNotFoundException {
        EmployeeEntity updated = employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<EmployeeEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        employeeService.deleteEmployeeByID(id);
        return HttpStatus.FORBIDDEN;
    }




}
