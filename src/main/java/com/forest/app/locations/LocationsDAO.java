package com.forest.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forest.app.util.DBConnector;

public class LocationsDAO {
	
	public LocationsDTO getDetail(LocationsDTO lD) throws Exception {
		
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, lD.getLocation_id());
		ResultSet rs = ps.executeQuery();
		
		LocationsDTO resultDTO = null;
		if(rs.next()) {
			resultDTO = new LocationsDTO();
			resultDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			resultDTO.setStreet_address(rs.getString("STREET_ADDRESS"));
			resultDTO.setPostal_code(rs.getString("POSTAL_CODE"));
			resultDTO.setCity(rs.getString("CITY"));
			resultDTO.setState_porvince(rs.getString("STATE_PROVINCE"));
			resultDTO.setCountry_id(rs.getString("COUNTRY_ID"));
		}
		return resultDTO;
	}
	
	public List<LocationsDTO> getList() throws Exception {
		
		Connection con = DBConnector.getConnector();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<LocationsDTO> ar = new ArrayList<LocationsDTO>();
		while(rs.next()) {
			LocationsDTO lD = new LocationsDTO();
			lD.setLocation_id(rs.getInt("LOCATION_ID"));
			lD.setStreet_address(rs.getString("STREET_ADDRESS"));
			lD.setPostal_code(rs.getString("POSTAL_CODE"));
			lD.setCity(rs.getString("CITY"));
			lD.setState_porvince(rs.getString("STATE_PROVINCE"));
			lD.setCountry_id(rs.getString("COUNTRY_ID"));
			ar.add(lD);
		}
		DBConnector.disConnect(rs, ps, con);
		return ar;
	}
}
