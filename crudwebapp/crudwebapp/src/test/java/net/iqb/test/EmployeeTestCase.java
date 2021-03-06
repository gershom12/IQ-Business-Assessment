package net.iqb.test;

import java.util.Date;
import java.util.List;
import net.iqb.common.AddressType;
import net.iqb.common.PersonType;
import net.iqb.config.ApplicationConfig;
import net.iqb.model.Address;
import net.iqb.model.Employee;
import net.iqb.model.Person;
import net.iqb.service.EmployeeServiceLocal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author gershom
 */
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = ApplicationConfig.class)
public class EmployeeTestCase {

    @Autowired
    private EmployeeServiceLocal employeeService;

    private Employee employee;

    private Long employeeId;

    public EmployeeTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFind() {
        Long id = persistEmp();
        employeeId = id;
        Employee persistentEmployee = employeeService.find(id);
        Assert.assertEquals(employee.getDesignation(), persistentEmployee.getDesignation());
        Assert.assertEquals(employee.getEmployeeNumber(), persistentEmployee.getEmployeeNumber());
    }

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeService.findAll();
        Assert.assertTrue(!employees.isEmpty());
    }

    @Test
    public void testUpdate() {
        Long id = persistEmp();

        Employee emp = employeeService.find(id);
        emp.setDesignation("Senior developer");
        emp.setEmployeeNumber("453");
        emp.getPerson().setFirstName("Mike");
        employeeService.update(emp);

        Assert.assertEquals("Senior developer", emp.getDesignation());
        Assert.assertEquals("453", emp.getEmployeeNumber());
        Assert.assertEquals("Mike", emp.getPerson().getFirstName());
    }

    @Ignore
    public void testDelete() {
        Long id = persistEmp();
        employeeService.delete(employee);
        Employee emp = employeeService.find(id);
        Assert.assertNull(emp);
    }
    
    private Long persistEmp() {
        employee = new Employee();
        employee.setCreatedBy("Gershom");
        employee.setCreatedDate(new Date());
        employee.setDesignation("Developer");
        employee.setEmployeeNumber("23");

        Person person = new Person();
        person.setCreatedBy("Gershom");
        person.setCreatedDate(new Date());
        person.setEmail("gershom.mnaluleke1@gmail.com");
        person.setFacebookHandle("gershom12");
        person.setFirstName("Gershom");
        person.setLastName("Maluleke");
        person.setMobileNumber("0717890606");
        person.setPersonType(PersonType.EMPLOYEE);
        person.setTwitterHandle("gershom12");
        person.setUpdatedBy("Gershom");
        person.setUpdatedDate(new Date());

        Address postaAddress = new Address();
        postaAddress.setAddressType(AddressType.POSTAL);
        postaAddress.setCreatedBy("Gershom");
        postaAddress.setCreatedDate(new Date());
        postaAddress.setLine1("Box 787");
        postaAddress.setLine2("101 Jorrisen street");
        postaAddress.setLine3("Extension 3");
        //postaAddress.setLine4("Centurion");
        postaAddress.setSurbub("Centurion");
        postaAddress.setPostalCode("0002");
        person.addAddress(postaAddress);

        Address resAddress = new Address();
        resAddress.setAddressType(AddressType.RESIDENTIAL);
        resAddress.setCreatedBy("Gershom");
        resAddress.setCreatedDate(new Date());
        resAddress.setLine1("787 Thornfield estate");
        resAddress.setLine2("101 esselen");
        resAddress.setLine3("Extension 3");
        //postaAddress.setLine4("Centurion");
        resAddress.setSurbub("Centurion");
        resAddress.setPostalCode("0002");
        person.addAddress(resAddress);

        employee.setPerson(person);
        return employeeService.save(employee);
    }

}
