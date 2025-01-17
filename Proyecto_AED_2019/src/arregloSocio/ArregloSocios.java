package arregloSocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import socio.AdicionarSocio;

public class ArregloSocios {
private ArrayList<AdicionarSocio> ad;
public ArregloSocios(){
	ad = new ArrayList <AdicionarSocio> ();
	cargarSocio();
}
public void adicionar(AdicionarSocio x){
	ad.add(x);
}
public int tama�o(){
	return ad.size();
}
public AdicionarSocio obtener(int i){
	return ad.get(i);
}
public AdicionarSocio buscar(int codigo){
	for (int i=0;i<tama�o();i++)
		if (obtener (i).getCodigo()==codigo)
			return obtener(i);
	return null;
}
public void eliminar(AdicionarSocio x){
	ad.remove(x);
}
public void grabarPacientes() {
	try {
		PrintWriter pw;
		String linea;
		AdicionarSocio x;
		pw = new PrintWriter(new FileWriter("socios.txt"));
		for (int i=0; i<tama�o(); i++) {
			x = obtener(i);
			linea = x.getCodigo() + ";" +
					x.getNombres() + ";" +
					x.getApellidos() + ";" +
					x.getTelefono() + ";" +
					x.getDni();
			pw.println(linea);
		}
		pw.close();	
	}
	catch (Exception e) {
	}
}
private void cargarSocio() {
	try {
		BufferedReader br;
		String linea;
		String[] s;
		int codigoSocio;
		String nombres, apellidos, telefono, dni;
		br = new BufferedReader(new FileReader("socios.txt"));
		while ((linea = br.readLine()) != null) {
			s = linea.split(";");
			codigoSocio = Integer.parseInt(s[0].trim());
			nombres = s[1].trim();
			apellidos = s[2].trim();
			telefono = s[3].trim();
			dni = s[4].trim();
			adicionar(new AdicionarSocio(codigoSocio, nombres, apellidos, telefono, dni));
		}
		br.close();
	}
	catch (Exception e) {
	}
}
public int numeroCorrelativo() {
	if (tama�o() == 0)
		return 10001;
	else
		return obtener(tama�o()-1).getCodigo() + 1;
}
}
