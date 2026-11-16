package org.example;

import org.example.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private static Map<Employee, Integer> countEmployees(List<Employee> employees) {
        Map<Employee, Integer> counts = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null) {
                counts.merge(employee, 1, Integer::sum);
            }
        }
        return counts;
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Employee, Integer> counts = countEmployees(employees);
        List<Employee> result = new LinkedList<>();
        List<Employee> seen = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee != null && counts.get(employee) > 1 && !seen.contains(employee)) {
                seen.add(employee);
                result.add(employee);
            }
        }
        return result;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null) {
                uniques.putIfAbsent(employee.getId(), employee);
            }
        }
        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> counts = countEmployees(employees);
        List<Employee> result = new LinkedList<>();
        for (Employee employee : employees) {
            if (employee != null && counts.get(employee) == 1) {
                result.add(employee);
            }
        }
        return result;
    }
}
