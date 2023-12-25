package com.forest.app.test;

import java.util.List;

import com.forest.app.Regions.RegionDAO;
import com.forest.app.Regions.RegionDTO;
import com.forest.app.departments.DepartmentDAO;
import com.forest.app.departments.DepartmentDTO;
import com.forest.app.views.View;

public class AppMain {
	
	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		RegionDAO rDao = new RegionDAO();
		RegionDTO rD = new RegionDTO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		View view = new View();
		try {
			List<RegionDTO> ar = rDao.getList();
			List<DepartmentDTO> ar2 = dao.getList();
			rD.setRegion_id(1);
			rD = rDao.getDetail(rD);
			
			departmentDTO.setDepartment_id(100);
			departmentDTO = dao.getDetail(departmentDTO);
			
			if(rD!=null) {
				System.out.println(rD.getRegion_name());
			}else {
				System.out.println("없다");
			}
			
			if(departmentDTO!=null) {
				System.out.println(departmentDTO.getDepartment_name());
			}else {
				System.out.println("없다");
			}
			
//			view.regionView(ar);
//			view.departmentView(ar2);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
