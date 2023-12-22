package com.forest.app.test;

import com.forest.app.util.DBConnector;

public class AppMain {

	public static void main(String[] args) {
		new DBConnector().getConnector();;
	}

}
