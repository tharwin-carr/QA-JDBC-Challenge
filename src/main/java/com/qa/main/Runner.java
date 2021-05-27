package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		try {
			Connection con = DriverManager
					.getConnection("jdbc:myslql://localhost:3306/Gameshop?db_name&serverTimezone=UTC", "root", "root");
			PreparedStatement ps = con.prepareStatement("INSERT INTO customers (name) values (?)");
			ps.setString(1, "Tharwin");

			ResultSet rs = ps.executeQuery("SELECT * FROM customers");
			while (rs.next()) {
				System.out.println(String.format("Name: %s", rs.getString("name") ));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
