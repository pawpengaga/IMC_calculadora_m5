package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

  private static Connection cnx = null;

  private DBConn(){
    try {
      Class.forName("org.postgresql.Driver");

      cnx = DriverManager.getConnection("jdbc:postgresql:imc_db?user=postgres&password=12345678");

      System.out.println("Cargo el driver...");

      if (cnx != null) {
        System.out.println("Conexion establecida");
      } else{
        System.out.println("No se pudo conectar...");
      }

    } catch (SQLException e){
      e.printStackTrace();
    } catch (ClassNotFoundException e){
      System.out.println(e.getMessage());
    }
  }

  public static Connection getConnection(){

    if (cnx == null) {
      new DBConn();
      System.out.println("CARGADO EL PRIMERO");
    }

    return cnx;
  }

  public static void main(String[] args) {
    DBConn.getConnection();
   }

}
