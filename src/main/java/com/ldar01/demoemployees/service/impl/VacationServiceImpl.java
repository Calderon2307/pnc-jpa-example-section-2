package com.ldar01.demoemployees.service.impl;

import com.ldar01.demoemployees.dto.request.vacation.VacationRequest;
import com.ldar01.demoemployees.dto.request.vacation.VacationUpdateRequest;
import com.ldar01.demoemployees.dto.response.vacation.EmployeeVacationsResponse;
import com.ldar01.demoemployees.dto.response.vacation.VacationResponse;
import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.entities.enums.VacationStatus;
import com.ldar01.demoemployees.repository.VacationRepository;
import com.ldar01.demoemployees.service.EmployeeService;
import com.ldar01.demoemployees.service.VacationService;
import com.ldar01.demoemployees.utils.mappers.VacationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    private final VacationRepository vacationRepository;
    private final EmployeeService employeeService;

    @Autowired
    public VacationServiceImpl(VacationRepository vacationRepository, EmployeeService employeeService) {
        this.vacationRepository = vacationRepository;
        this.employeeService = employeeService;
    }

    @Override
    public VacationResponse save(VacationRequest vacationRequest) {
        Employee employee =  employeeService.findEntityById(vacationRequest.getEmployee());
        VacationStatus status = VacationStatus.PENDING;
        return VacationMapper.toDTOResponse(vacationRepository.save(VacationMapper.toEntityCreate(vacationRequest, employee, status)));
    }

    @Override
    public VacationResponse update(VacationUpdateRequest vacationRequest) {
        Employee employee =  employeeService.findEntityById(vacationRequest.getEmployee());
        return VacationMapper.toDTOResponse(vacationRepository.save(VacationMapper.toEntityUpdate(vacationRequest, employee)));
    }

    @Override
    public VacationResponse findById(int id) {
        return VacationMapper.toDTOResponse(vacationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacation not Found")));
    }

    @Override
    public List<VacationResponse> findAll() {
        return VacationMapper.toDTOResponseList(vacationRepository.findAll());
    }

    @Override
    public void delete(int id) {
        vacationRepository.deleteById(id);
    }

    @Override
    public EmployeeVacationsResponse findByEmployeeId(int employeeId) {
        return VacationMapper.toDTOEmployeeVacation(
                employeeService.findEntityById(employeeId),
                vacationRepository.findByEmployeeId(employeeId).orElseThrow(() -> new RuntimeException("Vacations not Found"))
        );
    }
}
