package org.example.entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String F_Name;

    String L_Name;

    String email;

    String address;

    int phone_no;

    Date JOD;

    Date Created_at;

    Date updated_at;



    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public Date getJOD() {
        return JOD;
    }

    public void setJOD(Date JOD) {
        this.JOD = JOD;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
