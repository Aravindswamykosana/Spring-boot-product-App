package hibernate_template.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

import hibernate_template.config.EmployeeConfig;
import hibernate_template.dto.Employee;
import hibernate_template.service.EmployeeService;

public class EmployeeMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        
        Employee employee = new Employee();
        employee.setId(2);
        employee.setName("aravind");
        employee.setDepartment("monet tree");
        
        employeeService.save(employee);
        
        System.out.println("Employee saved successfully!");
    }
}
