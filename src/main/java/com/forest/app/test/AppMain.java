package com.forest.app.test;

import java.util.List;

import com.forest.app.Regions.RegionDAO;
import com.forest.app.Regions.RegionDTO;
import com.forest.app.countries.CountriesDAO;
import com.forest.app.countries.CountriesDTO;
import com.forest.app.departments.DepartmentDAO;
import com.forest.app.departments.DepartmentDTO;
import com.forest.app.employees.EmployeesDAO;
import com.forest.app.employees.EmployeesDTO;
import com.forest.app.locations.LocationsDAO;
import com.forest.app.locations.LocationsDTO;
import com.forest.app.views.View;

public class AppMain {
	
	public static void main(String[] args) {
		DepartmentDAO dDao = new DepartmentDAO();
		RegionDAO rDao = new RegionDAO();
		CountriesDAO cDao = new CountriesDAO();
		LocationsDAO lDao = new LocationsDAO();
		EmployeesDAO eDao = new EmployeesDAO();
		RegionDTO rD = new RegionDTO();
		DepartmentDTO dDTO = new DepartmentDTO();
		CountriesDTO cD = new CountriesDTO();
		LocationsDTO lD = new LocationsDTO();
		EmployeesDTO eD = new EmployeesDTO();
		View view = new View();
		try {
			List<RegionDTO> ar = rDao.getList();
			List<DepartmentDTO> ar2 = dDao.getList();
			List<CountriesDTO> ar3 = cDao.getList();
			List<LocationsDTO> ar4 = lDao.getList();
			List<EmployeesDTO> ar5 = eDao.getList();
			rD.setRegion_id(1);
			rD = rDao.getDetail(rD);
			
			dDTO.setDepartment_id(100);
			dDTO = dDao.getDetail(dDTO);
			
			cD.setCountry_id("DE");
			cD = cDao.getDetail(cD);
			
			lD.setLocation_id(1100);
			lD = lDao.getDetail(lD);
			
			eD.setEmployee_id(101);
			eD = eDao.getDetail(eD);
			
			if(rD!=null) {
				System.out.println(rD.getRegion_name());
			}else {
				System.out.println("없다");
			}
			
			if(dDTO!=null) {
				System.out.println(dDTO.getDepartment_name());
			}else {
				System.out.println("없다");
			}
			if(cD!=null) {
				System.out.println(cD.getCountry_name());
			}else {
				System.out.println("없다");
			}
			if(lD!=null) {
				System.out.println(lD.getCity());
			}else {
				System.out.println("없다");
			}
			if(eD!=null) {
				System.out.println(eD.getFirst_name()+" "+eD.getLast_name());
			}else {
				System.out.println("없다");
			}
			
//			view.countryView(ar3);
//			view.regionView(ar);
//			view.departmentView(ar2);
//			view.locationsView(ar4);
			view.employeesView(ar5);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
