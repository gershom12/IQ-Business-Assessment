package net.iqb.ui;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import net.iqb.model.Employee;
import net.iqb.service.EmployeeServiceLocal;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author gershom
 */
@ManagedBean
@ViewScoped
public class EmployeeDetails implements Serializable{

    @ManagedProperty(value = "#{employeeService}")
    private EmployeeServiceLocal employeeService;

    private Employee employee;

    private String employeeId;

    /**
     * Creates a new instance of HomeBean
     */
    public EmployeeDetails() {
    }

    @PostConstruct
    public void init() {

    }

    public EmployeeServiceLocal getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeServiceLocal employeeService) {
        this.employeeService = employeeService;
    }

    public void before(ComponentSystemEvent event) {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            if (!StringUtils.isBlank(getEmployeeId())) {
                employee = employeeService.find(new Long(getEmployeeId()));
            }
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
