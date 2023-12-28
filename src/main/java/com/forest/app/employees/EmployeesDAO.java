package com.forest.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.forest.app.util.DBConnector;

public class EmployeesDAO {
//	사원 추가
	public int add(EmployeesDTO eD) throws Exception{
		Connection con = DBConnector.getConnector();
		
		String sql = "INSERT INTO EMPLOYEES VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, eD.getEmployee_id());
		ps.setString(2, eD.getFirst_name());
		ps.setString(3, eD.getLast_name());
		ps.setString(4, eD.getEmail());
		ps.setString(5, eD.getPhone_number());
		ps.setDate(6, eD.getHire_date());
		ps.setString(7, eD.getJob_id());
		ps.setDouble(8, eD.getSalary());
		ps.setDouble(9, eD.getCommission_pct());
		ps.setInt(10, eD.getManager_id());
		ps.setInt(11, eD.getDepartment_id());
		
		int result = ps.executeUpdate();
		
		DBConnector.disConnect(ps, con);
		return result;
		
	}
	
	//사원급여의 합계
	public Map<String, Integer> getSalary() throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Connection con = DBConnector.getConnector();
		String sql = "SELECT SUM(SALARY), COUNT(EMPLOYEE_ID) AS C FROM EMPLOYEES";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		rs.next();
		
		int sum = rs.getInt(1); // => rs.getInt("SUM(SALARY)") (AS 써서 별칭으로 해도 가능)
		int count = rs.getInt("C");
		map.put("count", count);
		map.put("sum", sum);
		
		DBConnector.disConnect(rs, ps, con);
		
		return map;
	}
	
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
