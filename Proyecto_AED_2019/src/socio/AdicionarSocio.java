package socio;

public class AdicionarSocio {
private int codigo;
private String nombres,apellidos,dni,telefono;
public AdicionarSocio(int codigo,String dni, String telefono, String nombres, String apellidos) {
	this.codigo = codigo;
	this.dni = dni;
	this.telefono = telefono;
	this.nombres = nombres;
	this.apellidos = apellidos;
}
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telfono) {
	this.telefono = telfono;
}
public String getNombres() {
	return nombres;
}
public void setNombres(String nombres) {
	this.nombres = nombres;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

}
