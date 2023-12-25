package com.forest.app.Regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.forest.app.util.DBConnector;

public class RegionDAO {
	
	public RegionDTO getDetail(RegionDTO rD)throws Exception {
		Connection con = DBConnector.getConnector();
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		//물음표 값 설정
		ps.setInt(1, rD.getRegion_id());
		
		ResultSet rs = ps.executeQuery();
		RegionDTO resultDTO = null; 
		if(rs.next()) {
			resultDTO = new RegionDTO();
			resultDTO.setRegion_id(rs.getInt("REGION_ID"));
			resultDTO.setRegion_name(rs.getString("REGION_NAME"));
		}
		return resultDTO;
	}
	
	public List<RegionDTO> getList() throws Exception {
			
			Connection con = DBConnector.getConnector();
			String sql = "SELECT * FROM REGIONS";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			List<RegionDTO> ar = new ArrayList<RegionDTO>();
			
			while(rs.next()) {
				RegionDTO rD = new RegionDTO();
				rD.setRegion_id(rs.getInt("REGION_ID"));
				rD.setRegion_name(rs.getString("REGION_NAME"));
				ar.add(rD);
			}			
			
			DBConnector.disConnect(rs, ps, con);
			return ar;
	}
}
