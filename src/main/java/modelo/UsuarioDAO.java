package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

  public void registrarUsuario(Usuario user) throws SQLException{
    
    // Partimos con la consulta
    String sql = "INSERT INTO usuarios (nombre, clave, correo) VALUES (?,?,?)";

    try {
      Connection conn = DBConn.getConnection();
      PreparedStatement pstm = conn.prepareStatement(sql);
      // Sacamos los datos para ingresarlos del usuario que esta ENTRANDO
      pstm.setString(1, user.getNombre());
      pstm.setString(2, user.getClave());
      pstm.setString(3, user.getCorreo());
      
      if (pstm.executeUpdate() < 0) {
        System.out.println("Registro aniadido.");
      }
    } catch (Exception e){
      e.printStackTrace();
    }

  }

}
