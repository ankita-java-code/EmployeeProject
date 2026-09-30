package org.example.DTO;

import java.util.Date;

public record EmployeeRecord(Long empID, String FName, String LName, String Email,int phone, String address, Date JOD) {
}
