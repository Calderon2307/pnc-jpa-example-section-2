package com.ldar01.demoemployees.dto.request.vacation;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacationRequest {
    @JsonProperty(value = "start_date")
    @NotNull(message = "Debes ingresar una fecha de inicio.")
    @FutureOrPresent(message = "La fecha de inicio no puede ser en pasado.")
    private LocalDate startDate;

    @JsonProperty(value = "end_date")
    @NotNull(message = "Debes ingresar una fecha de fin.")
    @Future(message = "La fecha de fin no puede ser en pasado ni en presente.")
    private LocalDate endDate;

    @JsonProperty(value = "vacation_reason")
    @NotBlank(message = "Se debe incluir una razon.")
    private String reason;

    @JsonProperty(value = "employee_id")
    @NotNull(message = "El usuario es obligatorio.")
    private Integer employee;
}
