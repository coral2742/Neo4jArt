package queries;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Query;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Path;

import static org.neo4j.driver.Values.parameters;

import java.util.List;

public class Queries implements AutoCloseable{
	    private final Driver driver;

	    public Queries(String uri, String user, String password) {
	        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	    
	    }
	    

	    @Override
	    public void close() throws RuntimeException {
	        driver.close();
	    }
	    

	    public String consulta_1(String nombrePintor) {
            StringBuilder resultado = new StringBuilder();

	        try (Session session = driver.session()) {
	            session.executeRead(tx -> {
	                Query query = new Query("MATCH (pintor:Pintor)-[:PINTÓ]->(cuadro:Cuadro)\r\n"
	                        + "WHERE pintor.nombre = $nombre\r\n"
	                        + "RETURN cuadro AS cuadros\r\n"
	                        + "", parameters("nombre", nombrePintor));

	                Result result = tx.run(query);

	                List<org.neo4j.driver.Record> records = result.list();


	                records.forEach(record -> {
	                    Node node = record.get("cuadros").asNode();
	                    List<String> nodeTypes = (List<String>) node.labels();

	                    resultado.append(nodeTypes.get(0).toUpperCase() + "\n");
	                    node.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + node.get(propertyKey).asObject());
	                    });
	                    resultado.append("\n\n");
	                });

	                return "Nodes retrieved successfully";
	            });
	        }
			return resultado.toString();
	    }


	    
	    
	    public String consulta_2(String nombreTecnica) {
	    	StringBuilder resultado = new StringBuilder();
	    	
	        try (Session session = driver.session()) {
	            session.executeRead(tx -> {
	                Query query = new Query("MATCH (pintor:Pintor)-[:PINTÓ]->(cuadro:Cuadro)-[:PINTADO_CON]->(tecnica:Tecnica {nombre: $nombre})\r\n"
	                        + "RETURN DISTINCT pintor AS pintores\r\n"
	                        + "", parameters("nombre", nombreTecnica));
	                
	                Result result = tx.run(query);

	                List<org.neo4j.driver.Record> records = result.list();


	                records.forEach(record -> {
	                    Node node = record.get("pintores").asNode();
	                    List<String> nodeTypes = (List<String>) node.labels();

	                    resultado.append(nodeTypes.get(0).toUpperCase() + "\n");
	                    node.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + node.get(propertyKey).asObject() + "\n");
	                    });
	                    resultado.append("\n");
	                });

	                return "Nodes retrieved successfully";
	            });
	        }
	        return resultado.toString();
	    }
	    
	    
	    
	    public String consulta_3() {
	    	StringBuilder resultado = new StringBuilder();

	        try (Session session = driver.session()) {
	            session.executeRead(tx -> {
	                Query query = new Query("MATCH (tecnica:Tecnica)<-[:PINTADO_CON]-(cuadro:Cuadro)\r\n"
	                		+ "WITH tecnica, COUNT(cuadro) AS obrasUtilizandoTecnica\r\n"
	                		+ "WHERE obrasUtilizandoTecnica > 5\r\n"
	                		+ "RETURN tecnica\r\n"
	                		+ "");
	                
	                Result result = tx.run(query);

	                List<org.neo4j.driver.Record> records = result.list();


	                records.forEach(record -> {
	                    Node node = record.get("tecnica").asNode();
	                    List<String> nodeTypes = (List<String>) node.labels();

	                    resultado.append(nodeTypes.get(0).toUpperCase() + "\n");
	                    node.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + node.get(propertyKey).asObject() + "\n");
	                    });
	                    resultado.append("\n");
	                });

	                return "Nodes retrieved successfully";
	            });
	        }
	        
	        return resultado.toString();
	    }
	    
	    
	    
	    
	    public String consulta_4() {
	    	StringBuilder resultado = new StringBuilder();

	    	
	        try (Session session = driver.session()) {
	            session.executeRead(tx -> {
	                Query query = new Query("MATCH (pintor1:Pintor)-[:INFLUENCIA_A]->(pintor2:Pintor)-[:PINTÓ]->(cuadro:Cuadro)\r\n"
	                        + "WHERE pintor1 <> pintor2\r\n"
	                        + "RETURN cuadro, pintor1, pintor2\r\n"
	                        + "");

	                Result result = tx.run(query);

	                List<org.neo4j.driver.Record> records = result.list();


	                records.forEach(record -> {
	                    Node cuadroNode = record.get("cuadro").asNode();
	                    Node pintor1Node = record.get("pintor1").asNode();
	                    Node pintor2Node = record.get("pintor2").asNode();

	                    
	                    resultado.append("Cuadro: \n");
	                    cuadroNode.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + cuadroNode.get(propertyKey).asObject() + "\n");
	                    });

	                    
	                    resultado.append("Pintor 1: \n");
	                    pintor1Node.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + pintor1Node.get(propertyKey).asObject() + "\n");
	                    });

	                    
	                    resultado.append("Pintor 2: \n");
	                    pintor2Node.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + pintor2Node.get(propertyKey).asObject() + "\n");
	                    });

	                    resultado.append("\n");
	                });

	                return "Nodes retrieved successfully";
	            });
	        }
	        
	        return resultado.toString();
	    }
	    
	    


	    

	    public String consulta_5() {
	    	StringBuilder resultado = new StringBuilder();
	    	
	    	
	        try (Session session = driver.session()) {
	            session.executeRead(tx -> {
	                Query query = new Query("MATCH p=(pintor1:Pintor)-[:INFLUENCIA_A*]->(pintor2:Pintor)\r\n"
	                        + "WHERE pintor1 <> pintor2\r\n"
	                        + "RETURN p AS pintores\r\n"
	                        + "");

	                Result result = tx.run(query);

	                while (result.hasNext()) {
	                    Record record = result.next();
	                    Path path = record.get("pintores").asPath();

	                    Node startNode = path.start();
	                    Node endNode = path.end();

	                    resultado.append("- " + startNode.get("nombre").asString() + " influye en " + endNode.get("nombre").asString() + "\n");
	                }

	                return "Nodes retrieved successfully";
	            });
	        }
	        return resultado.toString();
	    }


	    public String consulta_6() {
	    	StringBuilder resultado = new StringBuilder();
	    	
	    	
	        try (Session session = driver.session()) {
	            session.executeRead(tx -> {
	                Query query = new Query("MATCH (p:Pintor)-[:INFLUENCIA_A]->(q:Pintor)\r\n"
	                		+ "WITH p, COUNT(q) AS influencias\r\n"
	                		+ "RETURN p AS pintor, influencias AS num_influencias\r\n"
	                		+ "ORDER BY influencias DESC\r\n"
	                		+ "LIMIT 1\r\n"
	                		+ "");
	                
	                Result result = tx.run(query);

	                List<org.neo4j.driver.Record> records = result.list();


	                records.forEach(record -> {
	                    Node node = record.get("pintor").asNode();
	                    List<String> nodeTypes = (List<String>) node.labels();

	                    resultado.append(nodeTypes.get(0).toUpperCase() + "\n");
	                    node.keys().forEach(propertyKey -> {
	                    	resultado.append("- " + propertyKey + ": " + node.get(propertyKey).asObject() + "\n");
	                    });
	                    
	                    resultado.append("- Número de influencias: " + record.get("num_influencias") + "\n");
	                    
	                    resultado.append("\n");
	                });

	                return "Nodes retrieved successfully";
	            });
	        }
	        
	        return resultado.toString();
	    }
	
}
