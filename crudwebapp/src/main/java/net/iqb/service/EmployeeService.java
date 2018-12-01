
package net.iqb.service;

import net.iqb.model.Employee;
import net.iqb.persistence.GenericPersistenceFacade;
import org.springframework.stereotype.Service;

/**
 *
 * @author gershom
 */
@Service
public class EmployeeService extends GenericPersistenceFacade<Employee>implements EmployeeServiceLocal{

    public EmployeeService() {
        super(Employee.class);
    }
    
}
