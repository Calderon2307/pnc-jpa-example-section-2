package com.ldar01.demoemployees.controller;

import com.ldar01.demoemployees.dto.request.vacation.VacationRequest;
import com.ldar01.demoemployees.dto.request.vacation.VacationUpdateRequest;
import com.ldar01.demoemployees.dto.response.GeneralResponse;
import com.ldar01.demoemployees.dto.response.vacation.EmployeeVacationsResponse;
import com.ldar01.demoemployees.dto.response.vacation.VacationResponse;
import com.ldar01.demoemployees.exception.VacationNoyFoundException;
import com.ldar01.demoemployees.service.VacationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/vacation")
public class VacationController {
    private final VacationService vacationService;

    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @PostMapping()
    public ResponseEntity<GeneralResponse> saveVacation(@RequestBody @Valid VacationRequest vacation){
        return buildResponse(
                "Vacation Request Created",
                HttpStatus.CREATED,
                vacationService.save(vacation)
        );
    }

    @PutMapping()
    public ResponseEntity<GeneralResponse> updateVacation(@RequestBody @Valid VacationUpdateRequest vacation){
        Boolean vacationExists = vacationService.existsById(vacation.getVacationId());
        if(!vacationExists){
            throw new VacationNoyFoundException("Vacation Not Found");
        }

        return buildResponse(
                "Vacation updated",
                HttpStatus.OK,
                vacationService.update(vacation)
        );
    }

    @GetMapping()
    public ResponseEntity<GeneralResponse> getAllVacations(){
        List<VacationResponse> vacations = vacationService.findAll();
        if (vacations.isEmpty()) {throw new VacationNoyFoundException("No vacations found");}
        return buildResponse(
                "Vacations Found",
                HttpStatus.OK,
                vacations
        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GeneralResponse> getVacationById(@PathVariable int id){
        VacationResponse vacation = vacationService.findById(id);
        return buildResponse(
                "Vacation found",
                HttpStatus.OK,
                vacation
        );
    }

    @GetMapping(value = "/{id}/employee")
    public ResponseEntity<GeneralResponse> getEmployeeVacationsById(@PathVariable int id){
        EmployeeVacationsResponse employeeVacations = vacationService.findByEmployeeId(id);
        if(employeeVacations.getEmployeeVacations().isEmpty()){
            throw new VacationNoyFoundException("The employee does not have any vacations");
        }

        return buildResponse(
                "Vacations Found",
                HttpStatus.OK,
                employeeVacations
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<GeneralResponse> deleteVacationById(@PathVariable int id){
        VacationResponse vacation = vacationService.findById(id);
        vacationService.delete(id);
        return buildResponse(
          "Vacation deleted",
          HttpStatus.OK,
          vacation
        );
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        /*BUILD URI*/
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity.status(status).body(GeneralResponse.builder()
                .message(message)
                .status(status.value())
                .data(data)
                .uri(uri)
                .time(LocalDate.now())
                .build());
    }
}
