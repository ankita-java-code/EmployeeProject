package org.example.controller;


import org.example.DTO.EmployeeRecord;
import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeRecord employeeRecord)
    {
        if(employeeRecord == null){
            return  new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Employee empObj = employeeService.addEmployee(employeeRecord);

        return  ResponseEntity.ok(empObj);

    }

    @GetMapping("/getEmpByID")
    public ResponseEntity<Employee> getByEmployeeId(@RequestParam("id") int empId){

       if(empId == 0){
            return  new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

        Employee employeeById = employeeService.getEmployeeById(empId);
       if(employeeById == null)
       {
           return (ResponseEntity<Employee>) ResponseEntity.noContent();
       }

        return  ResponseEntity.ok(employeeById);

    }


    @GetMapping("/getAllEmp")
    public List<Employee> getEmployeeList(){

        List<Employee> employeeList = employeeService.getEmployee();

        return employeeList;
    }

    @DeleteMapping("/delete")
    public  ResponseEntity<String> deleteEmpById(@RequestParam("id") int empId){
        if(empId == 0){
            return  new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

       Boolean isDeletedEmp = employeeService.deleteEmp(empId);

        if(!isDeletedEmp)
        {
            return (ResponseEntity<String>) ResponseEntity.noContent();
        }

        return  ResponseEntity
                .status(HttpStatus.FOUND)
                .body("Employee Deleted"
                );
    }


    @PutMapping("/update")

    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeRecord employeeRecord)
    {
        if(employeeRecord == null){
            return  new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Employee empObj = employeeService.updateEmployee(employeeRecord);

        return  ResponseEntity.ok(empObj);

    }

}
