package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.request.employee.EmployeeRequest;
import com.ldar01.demoemployees.dto.request.employee.EmployeeUpdateRequest;
import com.ldar01.demoemployees.dto.response.employee.EmployeeResponse;
import com.ldar01.demoemployees.entities.Employee;

import java.util.List;

/**
 * EmployeeService is the interface for the Employee Service.
 * It defines the methods to interact with the Employee data.
 */
public interface EmployeeService {
    List<EmployeeResponse> findAll();
    EmployeeResponse findById(int id);
    EmployeeResponse save(EmployeeRequest employee);
    EmployeeResponse update(EmployeeUpdateRequest employee);
    void delete(int id);
    //Servicio que devuelve ENTIDAD Employee
    Employee findEntityById(int id);
}
