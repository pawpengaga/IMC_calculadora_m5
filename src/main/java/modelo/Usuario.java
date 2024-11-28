package modelo;

public class Usuario {

  private int id;
  private String nombre;
  private String clave;
  private String correo;


  public Usuario(int id, String nombre, String clave, String correo) {
    this.id = id;
    this.nombre = nombre;
    this.clave = clave;
    this.correo = correo;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
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


}
