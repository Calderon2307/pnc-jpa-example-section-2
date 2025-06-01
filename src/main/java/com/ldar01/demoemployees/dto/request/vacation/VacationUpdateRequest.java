package com.ldar01.demoemployees.dto.request.vacation;

import com.ldar01.demoemployees.entities.enums.VacationStatus;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacationUpdateRequest {
    @JsonProperty(value = "id")
    @NotNull(message = "Debes colocar el ID.")
    private Integer vacationId;

    @JsonProperty(value = "start_date")
    @FutureOrPresent(message = "La fecha de inicio no puede ser en pasado.")
    private LocalDate startDate;

    @JsonProperty(value = "end_date")
    @Future(message = "La fecha de fin no puede ser en pasado ni en presente.")
    private LocalDate endDate;

    @JsonProperty(value = "vacation_reason")
    private String reason;

    @JsonProperty(value =  "vacation_status")
    private VacationStatus status;

    @JsonProperty(value = "employee_id")
    @NotNull(message = "El usuario es obligatorio.")
    private Integer employee;
}
