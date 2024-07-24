package producto;

public class Producto {
private int codigoPro,stock;
private double precioUni;
private String detalle;
public Producto(int codigoPro, int stock, double precioUni, String detalle) {
	this.codigoPro = codigoPro;
	this.stock = stock;
	this.precioUni = precioUni;
	this.detalle = detalle;
}
public int getCodigoPro() {
	return codigoPro;
}
public void setCodigoPro(int codigoPro) {
	this.codigoPro = codigoPro;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public double getPrecioUni() {
	return precioUni;
}
public void setPrecioUni(double precioUni) {
	this.precioUni = precioUni;
}
public String getDetalle() {
	return detalle;
}
public void setDetalle(String detalle) {
	this.detalle = detalle;
}

}
