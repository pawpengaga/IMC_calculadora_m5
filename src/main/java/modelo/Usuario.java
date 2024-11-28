package modelo;

public class Usuario {

  private int id;
  private String nombre;
  private String clave;
  private String correo;


  public Usuario(String nombre, String clave, String correo) {
    this.nombre = nombre;
    this.clave = clave;
    this.correo = correo;
  }

  public int getId() {
    return this.id;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getClave() {
    return this.clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getCorreo() {
    return this.correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", nombre='" + getNombre() + "'" +
      ", correo='" + getCorreo() + "'" +
      " }";
  }

  public void setId(int id) {
    this.id = id;
  }

  


}
