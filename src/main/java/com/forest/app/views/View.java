package com.forest.app.views;

import java.util.List;

import com.forest.app.Regions.RegionDTO;
import com.forest.app.countries.CountriesDTO;
import com.forest.app.departments.DepartmentDTO;
import com.forest.app.employees.EmployeesDTO;
import com.forest.app.locations.LocationsDTO;

public class View {

		//Regions를 출력
		public void regionView(List<RegionDTO> ar) {
			for(RegionDTO rD : ar) {
				System.out.println(rD.getRegion_id()+" : "+rD.getRegion_name());
			}
			System.out.println("==================================");
		}
		
		//Departments를 출력
		public void departmentView(List<DepartmentDTO> ar) {
			for(DepartmentDTO rD : ar) {
				System.out.println(rD.getDepartment_id()+" : "+rD.getDepartment_name()+" : "+rD.getManager_id()+" : "+rD.getLocation_id());
			}
			System.out.println("==================================");
		}
		//Countries를 출력
		public void countryView(List<CountriesDTO> ar) {
			for(CountriesDTO cD : ar) {
				System.out.println(cD.getCountry_id()+" : "+cD.getCountry_name()+" : "+cD.getRegion_id());
			}
			System.out.println("==================================");
		}
		//Locations를 출력
		public void locationsView(List<LocationsDTO> ar) {
			for(LocationsDTO lD : ar) {
				System.out.println(lD.getLocation_id()+" : "+lD.getStreet_address()+" : "+lD.getPostal_code()+" : "+lD.getCity()+" : "+lD.getState_porvince()+" : "+lD.getCountry_id());
			}
			System.out.println("==================================");
		}
		//Employees를 출력
		public void employeesView(List<EmployeesDTO> ar) {
			for(EmployeesDTO eD : ar) {
				System.out.println(eD.getEmployee_id()+" : "+eD.getFirst_name()+" : "+eD.getLast_name()+" : "+eD.getEmail()+" : "+eD.getPhone_number()+" : "+eD.getHire_date()+" : "+eD.getJob_id()+" : "+eD.getSalary()+" : "+eD.getCommission_pct()+" : "+eD.getManager_id()+" : "+eD.getDepartment_id());
			}
			System.out.println("==================================");
		}
}
