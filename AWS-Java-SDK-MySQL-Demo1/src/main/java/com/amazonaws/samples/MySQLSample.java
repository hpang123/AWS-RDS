package com.amazonaws.samples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSample {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://hpang-mysql.crxxxx.us-east-2.rds.amazonaws.com:3306/mysqldb";
	static final String USER = "admin";
	static final String PASS = "mysql123";

	public static void main(String[] args) throws IOException {

		try {
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e) {
			
		}
		try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement statement = connection.createStatement()) {
			

			
			String createTableQuery = "CREATE TABLE RDStable " + "(rowNumber INTEGER PRIMARY KEY, column1 INTEGER, "
					+ "column2 VARCHAR(30), column3 VARCHAR(30))";
			statement.execute(createTableQuery);
			
			String insertQuery = "INSERT INTO RDStable " + "VALUES (1, 1111, 'element12', 'element13')";
			statement.executeUpdate(insertQuery);
			insertQuery = "INSERT INTO RDStable " + "VALUES (2, 2222, 'element22', 'element23')";
			statement.executeUpdate(insertQuery);
			insertQuery = "INSERT INTO RDStable " + "VALUES (3, 3333, 'element32', 'element33')";
			statement.executeUpdate(insertQuery);
			String query = "SELECT COUNT(*) FROM RDStable";
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
			System.out.println("Totally there are " + resultSet.getInt(1) + " elements in the table");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
