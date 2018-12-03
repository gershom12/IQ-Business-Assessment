package net.iqb.ui;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import net.iqb.common.AddressType;
import net.iqb.common.PersonType;
import net.iqb.model.Address;
import net.iqb.model.Employee;
import net.iqb.model.Person;
import net.iqb.service.EmployeeServiceLocal;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.PrimeFaces;

/**
 *
 * @author gershom
 * This is the managed bean behind the addemployee.xhtml page. 
 */
@ManagedBean
@ViewScoped
public class AddEmployee implements Serializable {
    @ManagedProperty(value = "#{employeeService}")
    private EmployeeServiceLocal employeeService;

    private Employee employee;

    private String employeeId;
    
    private String PanelHeaderName;

    /**
     * Creates a new instance of HomeBean
     */
    public AddEmployee() {
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

    /*This method gets fired before the page is loaded.*/
    public void before(ComponentSystemEvent event) {
        if (!FacesContext.getCurrentInstance().isPostback()) {
            if (!StringUtils.isBlank(getEmployeeId())) {
                setPanelHeaderName("UPDATE EMPLOYEE");
                employee = employeeService.find(new Long(getEmployeeId()));
            } else {
                setPanelHeaderName("ADD NEW EMPLOYEE");
                employee = new Employee();
                employee.setCreatedBy("Gershom");
                employee.setCreatedDate(new Date());
                Person person = new Person();
                person.setCreatedBy("Gershom");
                person.setPersonType(PersonType.EMPLOYEE);
                person.setCreatedDate(new Date());
                Address postalAddress = new Address();
                postalAddress.setAddressType(AddressType.POSTAL);
                postalAddress.setCreatedBy("Gershom");
                postalAddress.setCreatedDate(new Date());
                Address residential = new Address();
                residential.setAddressType(AddressType.RESIDENTIAL);
                residential.setCreatedBy("Gershom");
                residential.setCreatedDate(new Date());
                
                person.addAddress(postalAddress);
                person.addAddress(residential);
                employee.setPerson(person);
            }
        }
    }
    /*This method saves or update the employee instance*/
    public void save(Employee persistentEmployee)
    {
        if(persistentEmployee.getId() != null)
        {
            employeeService.update(persistentEmployee);
        }
        else
        {
            employeeService.save(persistentEmployee);
        }
        PrimeFaces.current().dialog().closeDynamic(persistentEmployee);
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

    /**
     * @return the PanelHeaderName
     */
    public String getPanelHeaderName() {
        return PanelHeaderName;
    }

    /**
     * @param PanelHeaderName the PanelHeaderName to set
     */
    public void setPanelHeaderName(String PanelHeaderName) {
        this.PanelHeaderName = PanelHeaderName;
    }
    
}
