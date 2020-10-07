package ua.itea.service;

import ua.itea.db.DBConnector;
import ua.itea.db.HumanDB;
import ua.itea.model.Human;

public class HumanSQLService extends HumanService {
	private HumanDB humanDB ;
	private DBConnector conn;
	
	public HumanSQLService(HumanDB humanDB, DBConnector conn) {
		this.humanDB = humanDB;
		this.conn = conn;
	}
	
	@Override
	public Human load() {
		return humanDB.getUser(conn.getConnection());
	}
	
	@Override
	public void save(String name, int health) {
		humanDB.addUser(conn.getConnection(), name, health);
	}
}
