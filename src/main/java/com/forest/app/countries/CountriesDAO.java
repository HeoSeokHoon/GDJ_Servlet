package com.forest.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forest.app.util.DBConnector;

public class CountriesDAO {
	
	public CountriesDTO getDetail (CountriesDTO cDto) throws Exception {
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cDto.getCountry_id());
		ResultSet rs =  ps.executeQuery();
		
		CountriesDTO resultDto = null;
		if(rs.next()) {
			resultDto = new CountriesDTO();
			resultDto.setCountry_id(rs.getString("COUNTRY_ID"));
			resultDto.setCountry_name(rs.getString("COUNTRY_NAME"));
			resultDto.setRegion_id(rs.getInt("REGION_ID"));			
		}
		return resultDto;
	}
	
	public List<CountriesDTO> getList () throws Exception {
		//1. 커넥션 연결
		//2. sql 구문 작성
		//3. sql 미리보내기
		//4. 물음표값 생성
		//5. 최종 엑스큐트
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM COUNTRIES";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<CountriesDTO> ar = new ArrayList<CountriesDTO>();
		while(rs.next()) {
			CountriesDTO cD = new CountriesDTO();
			cD.setCountry_id(rs.getString("COUNTRY_ID"));
			cD.setCountry_name(rs.getString("COUNTRY_NAME"));
			cD.setRegion_id(rs.getInt("REGION_ID"));
			ar.add(cD);
		}
		
		DBConnector.disConnect(rs, ps, con);
		return ar;
	}
}
