package org.example.collection;

import junit.framework.TestCase;


public class CollectionEmployeeTest extends TestCase {
    CollectionEmployee collectionEmployee = new CollectionEmployee();
    DataEmployee dataEmployee = new DataEmployee();
    Employee employee = new Employee(6, "666", "Artur", 5);
    public void testAddEmployee() {
        collectionEmployee.setMyEmployees(dataEmployee.getDATA_EMPLOYEE());
        collectionEmployee.addEmployee(employee);
        assertTrue(collectionEmployee.getMyEmployees().contains(employee));
    }

    public void testFindEmployeeOnWorkExperience() {
        collectionEmployee.setMyEmployees(dataEmployee.getDATA_EMPLOYEE());
        collectionEmployee.addEmployee(employee);
        assertEquals(collectionEmployee.findEmployeeOnWorkExperience(5)
                .stream().findFirst().get().getWorkExperience(), employee.getWorkExperience());
    }

    public void testFindPhoneOnEmployeeName() {
        collectionEmployee.setMyEmployees(dataEmployee.getDATA_EMPLOYEE());
        collectionEmployee.addEmployee(employee);
        assertEquals("Artur - 666", collectionEmployee.findPhoneOnEmployeeName("Artur").get(0));
    }

    public void testFindEmployeeOnTabNumber() {
        collectionEmployee.setMyEmployees(dataEmployee.getDATA_EMPLOYEE());
        collectionEmployee.addEmployee(employee);
        assertEquals(collectionEmployee.findEmployeeOnTabNumber(6), employee);
    }
}