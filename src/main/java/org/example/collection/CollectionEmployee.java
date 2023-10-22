/*
* Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников -
каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
* */

package org.example.collection;


import java.util.*;


public class CollectionEmployee{
    private HashSet<Employee> myEmployees;

    public HashSet<Employee> getMyEmployees() {
        return myEmployees;
    }

    public void addEmployee(Employee employee){
        myEmployees.add(employee);
    }

    public Set<Employee> findEmployeeOnWorkExperience(int workExperience){
        Set<Employee> result = new HashSet<>(this.myEmployees);
        result.removeIf(x -> x.getWorkExperience() != workExperience);
        return result;
    }

    public List<String> findPhoneOnEmployeeName(String employeeName){
        List<String> result = new ArrayList<>();
        Set<Employee> temp = new HashSet<>(this.myEmployees);
        temp.removeIf(x -> !x.getName().equals(employeeName));
        temp.forEach(x -> result.add(x.getName() + " - " + x.getPhoneNumber()));
        return result;
    }

    public Employee findEmployeeOnTabNumber(int employeeTabNumber){
        return this.myEmployees.stream().filter(x -> x.getTabNumber() == employeeTabNumber).findFirst().get();
    }

    public void setMyEmployees(HashSet<Employee> myEmployees) {
        this.myEmployees = myEmployees;
    }
}
