
package net.iqb.service;

import net.iqb.model.Employee;
import net.iqb.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author gershom
 * This service inherit all generic methods from the persistence layer as well as implements all custom methods which are defined in the EmployeeServiceLocal 
 */
@Service
public class EmployeeService extends GenericPersistenceFacade<Employee>implements EmployeeServiceLocal{

    public EmployeeService() {
        super(Employee.class);
    }
    
}
