package com.forest.app.locations;

public class LocationsDTO {
	
	private int location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private String state_porvince;
	private String country_id;
	
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_porvince() {
		return state_porvince;
	}
	public void setState_porvince(String state_porvince) {
		this.state_porvince = state_porvince;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	
	
}
