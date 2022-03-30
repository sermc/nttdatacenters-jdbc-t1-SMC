package com.everis.nttdatacenters_jdbc_t1_SMC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Conexión de consulta
        conexionDB();
    }
    
    private static void conexionDB() {
    	try {
    		//Se establece conexión
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		
    		//Apertura de la conexión a la BD (URL / USU / PASSWD)
    		final Connection dBconection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","root");
    		
    		//Se realiza la consulta
    		final Statement sentencia = dBconection.createStatement();
    		final String query = "SELECT * FROM table";
    		final ResultSet queryResult = sentencia.executeQuery(query);
    		
    		//Se itera
    		while(queryResult.next()) {
    			System.out.println(queryResult);
    		}
    		
    		//Se cierra la conexión
    		dBconection.close();
    	} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
    		System.out.println("Conexión realizada con éxito.");
    	}
    }
}
