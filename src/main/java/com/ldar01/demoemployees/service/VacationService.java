package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.request.vacation.VacationRequest;
import com.ldar01.demoemployees.dto.request.vacation.VacationUpdateRequest;
import com.ldar01.demoemployees.dto.response.vacation.EmployeeVacationsResponse;
import com.ldar01.demoemployees.dto.response.vacation.VacationResponse;

import java.util.List;

public interface VacationService {
    List<VacationResponse> findAll();
    VacationResponse findById(int id);
    VacationResponse save(VacationRequest vacationRequest);
    VacationResponse update(VacationUpdateRequest vacationRequest);
    Boolean existsById(int id);
    void delete(int id);
    EmployeeVacationsResponse findByEmployeeId(int employeeId);
}
