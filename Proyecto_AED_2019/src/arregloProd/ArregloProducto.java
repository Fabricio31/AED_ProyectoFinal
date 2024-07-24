package arregloProd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import producto.Producto;


public class ArregloProducto {
private ArrayList<Producto> pr;
public ArregloProducto(){
	pr = new ArrayList<Producto>();
	cargarProductos();
}
public void adicionar(Producto x){
	pr.add(x);
}
public int tamaño(){
	return pr.size();
}
public Producto obtener(int i){
	return pr.get(i);
}
public Producto buscar(int codigoPro){
for (int i=0;i<tamaño();i++)
	if (obtener(i).getCodigoPro()==codigoPro)
		return obtener(i);
return null;
}
public void eliminar(Producto x){
	pr.remove(x);
}
public void grabarProdu() {
	try {
		PrintWriter pw;
		String linea;
		Producto x;
		pw = new PrintWriter(new FileWriter("productos.txt"));
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			linea = x.getCodigoPro() + ";" +
					x.getPrecioUni() + ";" +
					x.getStock() + ";" +
					x.getDetalle();
			pw.println(linea);
		}
		pw.close();
	}
	catch (Exception e) {	
	}
}
private void cargarProductos() {
	try {
		BufferedReader br;
		String linea, detalle;
		String[] s;
		int codigoProd, stock;
		double precio;
		br = new BufferedReader(new FileReader("productos.txt"));
		while ((linea = br.readLine()) != null) {
			s = linea.split(";");
			codigoProd = Integer.parseInt(s[0].trim());
			detalle = s[1].trim();
			stock = Integer.parseInt(s[2].trim());
			precio = Double.parseDouble(s[3].trim());
			adicionar(new Producto(codigoProd, stock, precio,detalle));
		}
		br.close();
	}
	catch (Exception e) {
	}
}
public int codigoCorrelativo() {
	if (tamaño() == 0) {
		return 20001;
	}
	else
		return obtener(tamaño()-1).getCodigoPro() + 1;
}
}
