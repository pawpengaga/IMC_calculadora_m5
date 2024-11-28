package modelo;

public class IMCResultado {

  private int userId;
  private float peso;
  private float altura;
  
  private float imc;


  public IMCResultado(int userId, float peso, float altura) {
    this.userId = userId;
    this.peso = peso;
    this.altura = altura;
    this.imc = calcularIMC();
  }

  public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public float getPeso() {
    return this.peso;
  }

  public void setPeso(float peso) {
    this.peso = peso;
  }

  public float getAltura() {
    return this.altura;
  }

  public void setAltura(float altura) {
    this.altura = altura;
  }

  public float getImc() {
    return this.imc;
  }

  /* ************************************************* */

  private float calcularIMC(){
    return this.peso / (this.altura * this.altura);
  }


}
