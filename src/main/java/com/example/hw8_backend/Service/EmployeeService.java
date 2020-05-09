package com.example.hw8_backend.Service;

//import com.amazonaws.util.StringUtils;

import com.example.hw8_backend.Entity.EmployeeEntity;
import com.example.hw8_backend.Exceptions.RecordNotFoundException;
import com.example.hw8_backend.Repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<EmployeeEntity> getAllEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        if (employeeList.size()>0)
        {
            return employeeList;
        }
        else
        {
            return new ArrayList<EmployeeEntity>();
        }
    }


    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity employee)
    throws RecordNotFoundException {
        Optional<EmployeeEntity> entity = employeeRepository.findById(employee.getId());
        if (entity.isPresent()) {
            EmployeeEntity newEntity = entity.get();
            newEntity.setEmail(employee.getEmail());
            newEntity.setFirstName(employee.getFirstName());
            newEntity.setLastName(employee.getLastName());

            newEntity = employeeRepository.save(newEntity);
            return newEntity;

        } else {
            employee = employeeRepository.save(employee);
            return employee;
        }

    }


    public EmployeeEntity getEmployeeByID(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public void deleteEmployeeByID(Long id) throws RecordNotFoundException
    {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);

        if(employee.isPresent())
        {
            employeeRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}

