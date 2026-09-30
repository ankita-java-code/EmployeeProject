package org.example.service;

import org.example.DTO.EmployeeRecord;
import org.example.entity.Employee;
import org.example.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Employee addEmployee(EmployeeRecord employeeRecord){
        Employee save =null;
        try {
            Employee emp = new Employee();
            emp.setF_Name(employeeRecord.FName());
            emp.setL_Name(employeeRecord.LName());
            emp.setEmail(employeeRecord.Email());
            emp.setAddress(employeeRecord.address());
            emp.setPhone_no(employeeRecord.phone());
            emp.setJOD(employeeRecord.JOD());
            emp.setCreated_at(new Date());
            emp.setUpdated_at(new Date());

             save = employeeRepo.save(emp);

            return save;
        }catch (Exception e){

            e.getMessage();
        }

        return  save;


    }


    public List<Employee> getEmployee()
    {
        List<Employee> employee =null;
        try {
             employee = employeeRepo.findAll();
        }catch (Exception e){
            e.getMessage();
        }
        return employee;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        try {

            Optional<Employee> empObj = employeeRepo.findById((long) id);

            if (empObj.isEmpty()) {
                return employee;
            }
            if (empObj.isPresent()) {
                employee = empObj.get();
            }
        }catch (Exception e){
            e.getMessage();
        }

        return  employee;
    }


    public  boolean deleteEmp(int id){
        try {
            Optional<Employee> empObj = employeeRepo.findById((long) id);
            if (empObj.isEmpty()) {
                return false;
            }

            if (empObj.isPresent()) {
                employeeRepo.delete(empObj.get());
            }
        }catch (Exception e){
            e.getMessage();
        }

        return true;
    }


    public Employee updateEmployee(EmployeeRecord employeeRecord){
        Employee emp =null;
        try {
            Optional<Employee> empObj = employeeRepo.findById(employeeRecord.empID());
            if (empObj.isPresent()) {
                emp = empObj.get();
                if (employeeRecord.FName() != null) {
                    emp.setF_Name(employeeRecord.FName());
                }
                if (employeeRecord.LName()!= null) {
                    emp.setL_Name(employeeRecord.LName());
                }
                if (employeeRecord.Email()!= null) {
                    emp.setEmail(employeeRecord.Email());
                }
                if (employeeRecord.phone() != 0) {
                    emp.setPhone_no(employeeRecord.phone());
                }
                if (employeeRecord.address()!= null) {
                    emp.setAddress(employeeRecord.address());
                }
                if (employeeRecord.JOD().toString()!= null) {
                    emp.setJOD(employeeRecord.JOD());
                }
                emp.setCreated_at(new Date());
                emp.setUpdated_at(new Date());

                employeeRepo.save(emp);
            }
        }catch (Exception e){
            e.getMessage();
        }

        return  emp;

    }
}
