package net.iqb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author gershom
 */
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{

    @Column(name = "employee_number", nullable = false)
    private String employeeNumber;
    @Column(name = "designation", nullable = false)
    private String designation;
    @OneToOne(optional = false, cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity =Person.class)
    private Person person;

    public Employee(){}

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
