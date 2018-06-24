package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProperties {
	@Value("${open}")
	private String open;
	@Value("${close}")
	private String close;
	@Value("${assigned}")
	private String assigned;
	@Value("${managet_type}")
	private String managerType;
	@Value("${department_type}")
	private String departmenttype;
	
	@Value("${employee_type}")
	private String employee;
	/**
	 * @return the open
	 */
	public String getOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(String open) {
		this.open = open;
	}
	/**
	 * @return the close
	 */
	public String getClose() {
		return close;
	}
	/**
	 * @return the assigned
	 */
	public String getAssigned() {
		return assigned;
	}

	/**
	 * @return the manager_type
	 */
	/**
	 * @return the managerType
	 */
	public String getManagerType() {
		return managerType;
	}
	
	
	/**
	 * @return the departmenttype
	 */
	public String getDepartmenttype() {
		return departmenttype;
	}
	/**
	 * @return the employee
	 */
	public String getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	/**
	 * @param close the close to set
	 */
	public void setClose(String close) {
		this.close = close;
	}
	/**
	 * @param assigned the assigned to set
	 */
	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}
	/**
	 * @param managerType the managerType to set
	 */
	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}



	
	
	

}
