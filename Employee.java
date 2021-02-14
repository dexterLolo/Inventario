package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	
	private StringProperty nombreProperty;
	
	private StringProperty marcaProperty;
	
	private StringProperty categoriaProperty;
	
	private IntegerProperty cantidadProperty;
	
	private StringProperty precioProperty;
	
	public Employee() {
		this.nombreProperty = new SimpleStringProperty();
		this.marcaProperty = new SimpleStringProperty();
		this.categoriaProperty = new SimpleStringProperty();
		this.cantidadProperty = new SimpleIntegerProperty();
		this.precioProperty = new SimpleStringProperty();
	}
	
	
	
	public String getEmpNombre() {
		return nombreProperty.get();
	}
	
	public void setEmpNombre(String nombre) {
		this.nombreProperty.set(nombre);
	}
	
	public StringProperty getEmployeeNombre() {
		return nombreProperty;
	}
	
	
	
	public String getEmpMarca() {
		return marcaProperty.get();
	}
	
	public void setEmpMarca(String marca) {
		this.marcaProperty.set(marca);
	}
	
	public StringProperty getEmployeeMarca() {
		return marcaProperty;
	}
	


	
	public String getEmpCategoria() {
		return categoriaProperty.get();
	}
	
	public void setEmpCategoria(String categoria) {
		this.categoriaProperty.set(categoria);
	}
	
	public StringProperty getEmployeeCategoria() {
		return categoriaProperty;
	}
	
	
	
	public String getEmpPrecio() {
		return precioProperty.get();
	}
	
	public void setEmpPrecio(String precio) {
		this.precioProperty.set(precio);
	}
	
	public StringProperty getEmployeePrecio() {
		return precioProperty;
	}
	
	
	
	public int getEmpCantidad() {
		return cantidadProperty.get();
	}
	
	public void setEmpCantidad(int cantidad) {
		this.cantidadProperty.set(cantidad);
	}
	
	public IntegerProperty getEmployeeCantidad() {
		return cantidadProperty;
	}
	
	
	
	
	

}
