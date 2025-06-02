package com.ldar01.demoemployees.dto.response.vacation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ldar01.demoemployees.entities.Vacation;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeVacationsResponse {
    @JsonProperty(value = "employee_id")
    private Integer employeeId;

    @JsonProperty(value = "employee_name")
    private String employeeName;

    @JsonProperty("employee_department")
    private String employeeDepartment;

    @JsonProperty(value = "vacations")
    private List<VacationResponse> employeeVacations;
}
