package projects;

//import projects.dao.DbConnection;
import java.sql.Connection;

import projects.dao.DbConnection;

@SuppressWarnings("unused")
public class ProjectsApp {

	public static void main(String[] args) {
		Connection conn = DbConnection.getConnection();

	}

}
