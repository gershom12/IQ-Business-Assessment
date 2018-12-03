package net.iqb.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import net.iqb.model.Employee;
import net.iqb.service.EmployeeServiceLocal;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author gershom
 * This is the managed bean that is bound to the employee.xhtml page and is purpose is to list all persistent employees data
 */
@ManagedBean
@ViewScoped
public class EmployeeBean implements Serializable {

    @ManagedProperty(value = "#{employeeService}")
    private EmployeeServiceLocal employeeService;

    private List<Employee> employees = new ArrayList<>();

    private Employee selectedEmployee;

    /**
     * Creates a new instance of HomeBean
     */
    public EmployeeBean() {
    }

    @PostConstruct
    public void init() {
        employees = employeeService.findAll();
    }

    public void addEmployee(Employee employee) {
        Map<String, List<String>> parameters = new HashMap();
        List<String> values = new ArrayList<>();
        if (employee != null) {
            values.add(String.valueOf(employee.getId()));
        } else {
            values.add(String.valueOf(""));
        }
        parameters.put("empId", values);
        openDialogBox("addemployee", parameters, 1000, 570);
    }

    /*Update the employee table with the newly created employee record*/
    public void onEmployeeAdded(SelectEvent event) {
        Employee employee = (Employee) event.getObject();
        Iterator<Employee> ite = employees.listIterator();
        while (ite.hasNext()) {
            if (ite.next().getId().equals(employee.getId())) {
                ite.remove();
                break;
            }
        }
        employees.add(0, employee);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Employee successfully updated or added"));
    }

    /*This method deletes employee record from both database and employee table*/
    public void delete(Employee employee) {
        employeeService.delete(employee);
        Iterator<Employee> ite = employees.listIterator();
        while (ite.hasNext()) {
            if (ite.next().getId().equals(employee.getId())) {
                ite.remove();
                break;
            }
        }
    }

    public EmployeeServiceLocal getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeServiceLocal employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    /*This method triggers the popup for viewing employee details*/
    public void viewEmployee(Employee emp) {

        Map<String, List<String>> parameters = new HashMap();
        List<String> values = new ArrayList<>();
        if (emp != null) {
            values.add(String.valueOf(emp.getId()));
        } else {
            values.add(String.valueOf(""));
        }
        parameters.put("empId", values);
        openDialogBox("employeedetails", parameters, 1000, 570);
    }
    
    /*This method construct popup window for both add employee page and view employee details page*/
    public void openDialogBox(String targetPageName, Map<String, List<String>> parameters, Integer width, Integer height) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        options.put("width", width);
        options.put("height", height);
        options.put("contentHeight", "100%");
        options.put("contentWidth", "100%");
        options.put("dynamic", false);

        PrimeFaces.current().dialog().openDynamic(targetPageName, options, parameters);
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

}
