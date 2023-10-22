package org.example.collection;

import java.util.HashSet;

public class DataEmployee {
    private final HashSet<Employee> DATA_EMPLOYEE = new HashSet<>();

    public DataEmployee() {
        DATA_EMPLOYEE.add(new Employee(1, "111", "Andrey", 1));
        DATA_EMPLOYEE.add(new Employee(2, "222", "Ivan", 2));
        DATA_EMPLOYEE.add(new Employee(3, "333", "Lavrentiy", 3));
        DATA_EMPLOYEE.add(new Employee(4, "444", "Evgeniy", 3));
        DATA_EMPLOYEE.add(new Employee(5, "555", "Stas", 1));
    }

    public HashSet<Employee> getDATA_EMPLOYEE() {
        return DATA_EMPLOYEE;
    }
}

