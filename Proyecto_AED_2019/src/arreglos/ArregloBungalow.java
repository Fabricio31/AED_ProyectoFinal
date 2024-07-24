package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clase.BungalowClass;

public class ArregloBungalow {
private ArrayList<BungalowClass> bun;
public ArregloBungalow(){
	bun = new ArrayList<BungalowClass>();
	cargarBungalow();
}
public void adicionar(BungalowClass x){
	bun.add(x);
}
public int tamaño(){
	return bun.size();
}
public BungalowClass obtener(int i){
	return bun.get(i);
}
public BungalowClass buscar(int numeroBungalow){
	for(int i=0;i<tamaño();i++)
		if (obtener(i).getNumeroBungalow() ==numeroBungalow)
			return obtener(i);
	return null;
}
public void eliminar(BungalowClass x){
	bun.remove(x);
}
public void grabarBungalows(){
	try{
		PrintWriter pw;
		String linea;
		BungalowClass x;
		pw = new PrintWriter(new FileWriter("Bungalow.txt"));
		for(int i=0;i<tamaño();i++){
			x =obtener(i);
			linea = x.getNumeroBungalow()+";"+
			        x.getCategoria() +";"+
					x.getPrecioPorDia()+";"+
			        x.getEstado();
			pw.println(linea);
		}
		pw.close();
	}
	catch (Exception e){
	}
}
private void cargarBungalow() {
	try {
		BufferedReader br;
		String linea;
		String[] s;
		int numeroBungalow, categoria, estado;
		double precioPorDia;
		br = new BufferedReader(new FileReader("Bungalow.txt"));
		while ((linea=br.readLine()) != null) {
			s = linea.split(";");
			numeroBungalow = Integer.parseInt(s[0].trim());
			categoria = Integer.parseInt(s[1].trim());
			precioPorDia = Double.parseDouble(s[2].trim());
			estado = Integer.parseInt(s[3].trim());
			adicionar(new BungalowClass(numeroBungalow, categoria, estado,precioPorDia));
		}
		br.close();	
	}
	catch (Exception e) {
	}
}
public int numeroCorrelativo() {
	if (tamaño() == 0)
		return 30001;
	else
		return obtener(tamaño()-1).getNumeroBungalow() + 1;
}
}
