package com.example.jpa_hybernate_diff;

import com.example.jpa_hybernate_diff.model.Employee;
import com.example.jpa_hybernate_diff.service.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpaHybernateDiffApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(JpaHybernateDiffApplication.class);
	private static EmployeeService employeeService;
	public static SessionFactory factory;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JpaHybernateDiffApplication.class, args);
		LOGGER.info("Inside main method of JpaHybernateDiffApplication");
		employeeService = context.getBean(EmployeeService.class);
		LOGGER.info("EmployeeService bean initialized successfully");

		factory = context.getBean(SessionFactory.class);
		LOGGER.info("SessionFactory bean initialized successfully");

		testSaveEmployee();
		testAddEmployeeHibernate();
	}

	public static Integer addEmployeeHibernate(Employee employee){
		try (Session session = factory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Integer id = (Integer) session.save(employee);
			transaction.commit();
			return id;
		} catch (Exception e) {
			LOGGER.error("Error adding employee with Hibernate", e);
			return null;
		}
	}

	public static void testSaveEmployee() {
		LOGGER.info("Inside testSaveEmployee");
		try {
			Employee employee = new Employee();
			employee.setName("John Doe");
			employee.setSurname("Smith");
			employee.setDept("Social Media");

			Employee savedEmployee = employeeService.saveEmployee(employee);
			LOGGER.info("Employee saved successfully: {}", savedEmployee);
		} catch (Exception e) {
			LOGGER.error("Error saving employee", e);
		}
	}

	public static void testAddEmployeeHibernate(){
		LOGGER.info("Inside testAddEmployeeHibernate");
		try {
			Employee employee = new Employee();
			employee.setName("Jane Doe");
			employee.setSurname("Johnson");
			employee.setDept("Marketing");

			Integer id = addEmployeeHibernate(employee);
			if (id != null) {
				LOGGER.info("Employee added successfully with ID: {}", id);
			} else {
				LOGGER.error("Failed to add employee");
			}
		} catch (Exception e) {
			LOGGER.error("Error adding employee with Hibernate", e);
		}
	}


}
