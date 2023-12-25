package com.forest.app.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forest.app.util.DBConnector;

public class DepartmentDAO {
	//데이타 엑셉트 오브젝트 DAO Data Accept Object
	
	public DepartmentDTO getDetail(DepartmentDTO dDto) throws Exception {
		Connection con = DBConnector.getConnector(); //연결
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?"; //sql구문작성
		PreparedStatement ps = con.prepareStatement(sql); //sql 구문 미리 보내기
		ps.setInt(1, dDto.getDepartment_id()); //sql구문에 ? 값 설정
		ResultSet rs = ps.executeQuery();
		DepartmentDTO resultDTO = null;
		if(rs.next()) {
			resultDTO = new DepartmentDTO();
			resultDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			resultDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			resultDTO.setManager_id(rs.getInt("MANAGER_ID"));
		}
		
		return resultDTO;
	}
	
	
	public List<DepartmentDTO> getList() throws Exception {
		//DB접속 후 부서테이블의 모든 정보를 출력
		
			Connection con = DBConnector.getConnector();
			String sql = "SELECT * FROM DEPARTMENTS";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
			while(rs.next()) {
				DepartmentDTO dDto = new DepartmentDTO();
				dDto.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
				dDto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				dDto.setManager_id(rs.getInt("MANAGER_ID"));
				dDto.setLocation_id(rs.getInt("LOCATION_ID"));
				ar.add(dDto);

			}
			
			DBConnector.disConnect(rs, ps, con);
			return ar;
		
	}
}
