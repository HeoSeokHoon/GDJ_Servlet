package com.forest.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forest.app.util.DBConnector;

public class EmployeesDAO {
	
	public EmployeesDTO getDetail(EmployeesDTO eDto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, eDto.getEmployee_id());
		ResultSet rs = ps.executeQuery();
		
		EmployeesDTO resultDto = null;
		if(rs.next()) {
			resultDto = new EmployeesDTO();
			resultDto.setFirst_name(rs.getString("FIRST_NAME"));
			resultDto.setLast_name(rs.getString("LAST_NAME"));
		}
		return resultDto;
	}

	public List<EmployeesDTO> getList() throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM EMPLOYEES";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		while(rs.next()) {
			EmployeesDTO eD = new EmployeesDTO();
			eD.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			eD.setFirst_name(rs.getString("FIRST_NAME"));
			eD.setLast_name(rs.getString("LAST_NAME"));
			eD.setEmail(rs.getString("EMAIL"));
			eD.setPhone_number(rs.getString("PHONE_NUMBER"));
			eD.setHire_date(rs.getDate("HIRE_DATE"));
			eD.setJob_id(rs.getString("JOB_ID"));
			eD.setSalary(rs.getDouble("SALARY"));
			eD.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
			eD.setManager_id(rs.getInt("MANAGER_ID"));
			eD.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			ar.add(eD);
		}
		DBConnector.disConnect(rs, ps, con);
		return ar;
	}
}
