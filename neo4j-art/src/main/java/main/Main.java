package main;

import queries.Credentials;
import queries.Queries;
import ui.Neo4jArt;

public class Main {

	public static void main(String[] args) {
		Welcome.welcome();
		String URI = Credentials.getURI();
		String user = Credentials.getUser();
		String password = Credentials.getPassword();
		
		try {
			Queries q = new Queries(URI, user, password);

			Neo4jArt frame = new Neo4jArt(q);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
