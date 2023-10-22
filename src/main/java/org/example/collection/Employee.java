package org.example.collection;


import java.util.Objects;

public class Employee {
    private int tabNumber; //Табельный номер
    private String phoneNumber; //Номер телефона
    private String name; //Имя
    private int workExperience; // Стаж

    @Override
    public String toString() {
        return "Employee{" +
                "tabNumber=" + tabNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", workExperience=" + workExperience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return tabNumber == employee.tabNumber && workExperience == employee.workExperience && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tabNumber, phoneNumber, name, workExperience);
    }

    public int getTabNumber() {
        return tabNumber;
    }

    public void setTabNumber(int tabNumber) {
        this.tabNumber = tabNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Employee() {
    }

    public Employee(int tabNumber, String phoneNumber, String name, int workExperience) {
        this.tabNumber = tabNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }
}
