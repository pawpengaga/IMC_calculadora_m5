package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

  // Esto deberia estar en otro lado...
  public boolean esUsuarioValido(String usuario, String clave) throws SQLException{
    
    String sql = "SELECT * FROM usuarios WHERE correo = ? AND clave = ?";

    try {
      Connection conn = DBConn.getConnection();
      PreparedStatement pstm = conn.prepareStatement(sql);

      pstm.setString(1, usuario);
      pstm.setString(2, clave);

      // Se guardan los resultados dados por una DB en un resulset
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        return true;
      } 
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

}
