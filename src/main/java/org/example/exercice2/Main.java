package org.example.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR", 50000));
        employees.add(new Employee("Bob", "IT", 60000));
        employees.add(new Employee("Charlie", "Finance", 55000));

        double totalSalaries = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Somme totale des salaires : " + totalSalaries);

        employees.sort((e1, e2) -> e1.toString().compareTo(e2.toString()));
        System.out.println("Liste des employés triée par nom : " + employees);

        Optional<Employee> minSalaryEmployee = employees.stream()
                .min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("Employé avec le salaire le plus bas : " + minSalaryEmployee.orElse(null));

        double thresholdSalary = 55000;
        List<Employee> highSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary() > thresholdSalary)
                .collect(Collectors.toList());
        System.out.println("Employés avec un salaire supérieur à " + thresholdSalary + " : " + highSalaryEmployees);

        Optional<Employee> maxSalaryEmployee = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        System.out.println("Employé avec le salaire le plus élevé : " + maxSalaryEmployee.orElse(null));

        String concatenatedNames = employees.stream()
                .map(Employee::toString)
                .reduce((e1, e2) -> e1 + ", " + e2)
                .orElse("");
        System.out.println("Noms de tous les employés : " + concatenatedNames);
    }
}

