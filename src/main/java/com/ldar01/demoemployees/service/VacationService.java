package com.ldar01.demoemployees.service;

import com.ldar01.demoemployees.dto.request.vacation.VacationRequest;
import com.ldar01.demoemployees.dto.response.vacation.VacationResponse;

import java.util.List;

public interface VacationService {
    List<VacationResponse> findAll();
    VacationResponse findById(Integer id);
    VacationResponse save(VacationRequest vacationRequest);
    VacationResponse update(VacationRequest vacationRequest);
    VacationResponse delete(VacationRequest vacationRequest);
    List<VacationResponse> findByEmployeeId(Integer employeeId);
}
