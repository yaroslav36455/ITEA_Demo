package ua.itea.main;

import ua.itea.db.DBConnector;
import ua.itea.db.DBSQLiteConnector;
import ua.itea.db.DBMySQLConnector;
import ua.itea.db.HumanDB;
import ua.itea.gui.HumanGUI;
import ua.itea.service.HumanSQLService;
import ua.itea.service.HumanService;
import ua.itea.service.HumanXMLFileService;

public class Application {

	public static void main(String[] args) {
		DBConnector mySQLconn = new DBMySQLConnector();
		DBConnector liteConn = new DBSQLiteConnector();
		HumanDB humanDB = new HumanDB();
		
		HumanService humanSQLService = new HumanSQLService(humanDB, liteConn);
		HumanService humanXMLFileService = new HumanXMLFileService();
		
		new HumanGUI(humanXMLFileService);
	}

}
