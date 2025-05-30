package com.ldar01.demoemployees.dto.response.vacation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ldar01.demoemployees.entities.enums.VacationStatus;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacationResponse {
    @JsonProperty(value = "vacation_id")
    private Integer vacationId;

    @JsonProperty(value = "start_date")
    private LocalDate startDate;

    @JsonProperty(value = "end_date")
    private LocalDate endDate;

    @JsonProperty(value = "vacation_reason")
    private String reason;

    @JsonProperty(value = "vacation_status")
    private VacationStatus status;

    @JsonProperty(value = "employee_id")
    private Integer employee;
}
