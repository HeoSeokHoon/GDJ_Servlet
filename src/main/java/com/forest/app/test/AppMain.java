package com.forest.app.test;

import java.sql.Date;
import java.util.Map;

import com.forest.app.employees.EmployeesDAO;
import com.forest.app.employees.EmployeesDTO;


public class AppMain {
	
	public static void main(String[] args) {
		EmployeesDAO eD = new EmployeesDAO();
		EmployeesDTO eDto = new EmployeesDTO();
		eDto.setEmployee_id(Integer.parseInt("207"));
		eDto.setFirst_name("first_name");
		eDto.setLast_name("last_name");
		eDto.setEmail("email");
		eDto.setPhone_number("010");
		eDto.setHire_date(Date.valueOf("2023-12-27"));
		eDto.setJob_id("AC_MGR");
		eDto.setSalary(Double.parseDouble("50000"));
		eDto.setCommission_pct(Double.parseDouble("0.12"));
		eDto.setManager_id(205);
		eDto.setDepartment_id(10);
		
		try {
			int result = eD.add(eDto);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
