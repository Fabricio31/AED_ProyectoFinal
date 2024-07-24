package clase;

public class BungalowClass {
private int numeroBungalow,categoria,estado;
private double precioPorDia;
public BungalowClass(int numeroBungalow, int categoria, int estado, double precioPorDia) {
	this.numeroBungalow = numeroBungalow;
	this.categoria = categoria;
	this.estado = estado;
	this.precioPorDia = precioPorDia;
}
public int getNumeroBungalow() {
	return numeroBungalow;
}
public void setNumeroBungalow(int numeroBungalow) {
	this.numeroBungalow = numeroBungalow;
}
public int getCategoria() {
	return categoria;
}
public void setCategoria(int categoria) {
	this.categoria = categoria;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public double getPrecioPorDia() {
	return precioPorDia;
}
public void setPrecioPorDia(double precioPorDia) {
	this.precioPorDia = precioPorDia;
}

}
