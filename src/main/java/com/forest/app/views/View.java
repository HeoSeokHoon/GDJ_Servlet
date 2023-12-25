package com.forest.app.views;

import java.util.List;

import com.forest.app.Regions.RegionDTO;
import com.forest.app.departments.DepartmentDTO;

public class View {

		//Regions를 출력
		public void regionView(List<RegionDTO> ar) {
			for(RegionDTO rD : ar) {
				System.out.println(rD.getRegion_id()+" : "+rD.getRegion_name());
				System.out.println("==================================");
			}
		}
		
		//Departments를 출력
		public void departmentView(List<DepartmentDTO> ar) {
			for(DepartmentDTO rD : ar) {
				System.out.println(rD.getDepartment_id()+" : "+rD.getDepartment_name()+" : "+rD.getManager_id()+" : "+rD.getLocation_id());
				System.out.println("==================================");
			}
		}
}
