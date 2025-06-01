package com.ldar01.demoemployees.utils.mappers;

import com.ldar01.demoemployees.dto.request.vacation.*;
import com.ldar01.demoemployees.dto.response.vacation.*;
import com.ldar01.demoemployees.entities.Employee;
import com.ldar01.demoemployees.entities.Vacation;
import com.ldar01.demoemployees.entities.enums.VacationStatus;

import java.util.List;

public class VacationMapper {

    public static Vacation toEntityCreate(
            VacationRequest vacationDTO,
            Employee employee,
            VacationStatus status
    ){
        return Vacation.builder()
                .startDate(vacationDTO.getStartDate())
                .endDate(vacationDTO.getEndDate())
                .reason(vacationDTO.getReason())
                .employee(employee)
                .status(status)
                .build();
    }

    public static Vacation toEntityUpdate(
            VacationUpdateRequest vacationDTO,
            Employee employee
    ){
        return Vacation.builder()
                .id(vacationDTO.getVacationId())
                .startDate(vacationDTO.getStartDate())
                .endDate(vacationDTO.getEndDate())
                .reason(vacationDTO.getReason())
                .status(vacationDTO.getStatus())
                .employee(employee)
                .build();
    }


    public static VacationResponse toDTOResponse(Vacation vacation){
        return VacationResponse.builder()
                .vacationId(vacation.getId())
                .startDate(vacation.getStartDate())
                .endDate(vacation.getEndDate())
                .reason(vacation.getReason())
                .status(vacation.getStatus())
                .employee(vacation.getEmployee().getId())
                .build();
    }

    public static List<VacationResponse> toDTOResponseList(List<Vacation> vacations){
        return vacations.stream()
                .map(VacationMapper::toDTOResponse)
                .toList();
    }

    public static EmployeeVacationsResponse toDTOEmployeeVacation(
            Employee employee,
            List<Vacation> vacations
    ){
        return EmployeeVacationsResponse.builder()
                .employeeId(employee.getId())
                .employeeVacations(vacations
                        .stream()
                        .map(VacationMapper::toDTOResponse)
                        .toList()
                )
                .build();
    }
}
