package ua.itea.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.itea.model.Human;

public class HumanDB {
	private final static String INSERT = "INSERT INTO `users` (name, health) VALUES ('%s', %d)";
	private final static String SELECT = "SELECT name, health FROM `users`";
	private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `users` (`name` VARCHAR(20), `health` INT)";
	
	public void addUser(Connection conn, String name, int health) {
		Statement statement = null;
		
		try {
			statement = conn.createStatement();
			statement.execute(CREATE_TABLE);
			statement.execute(String.format(INSERT, name, health));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Human getUser(Connection conn) {
		Statement statement = null;
		ResultSet resultSet = null;
		Human human = null;
		
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(SELECT);

			while (resultSet.next()) {
				human = new Human();
				human.setName(resultSet.getString("name"));
				human.setHealth(resultSet.getInt("health"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return human;
	}
}
