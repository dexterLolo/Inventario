package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlite {
	Connection c=null;
	Statement sentencia = null;
	String nombreTabla;
	
	String Nombre, Marca, Categria, Precio;
	int  Cantidad;
	
	public void conectar() {
	
		try {
			Class.forName("org.sqlite.JDBC");
			c=DriverManager.getConnection("jdbc:sqlite:database.db");
			
			System.out.println("Exito al conectar con base de datos.");
		}catch(Exception e) {
				System.out.println("Error al conectar.");
				}
	}
	
	
	public void crearTabla(String nombreTabla) throws SQLException{
		this.nombreTabla=nombreTabla;
		
		String sql = "CREATE TABLE "+nombreTabla+ " "+
				"(Nombre TEXT NOT NULL, "+ " Marca TEXT NOT NULL, "+
				" Categoria TEXT NOT NULL, "+ " Cantidad INT NOT NULL, "+
				" Precio TEXT NOT NULL)";
		try {
			sentencia = c.createStatement();
			sentencia.execute(sql);
			sentencia.close();
			c.close();
				
			System.out.println("Exito al crear tabla");		
		}catch(Exception e) {
			System.out.println("Error o ya estaba creada.");
		}
	}
	
	public void insertaDatos(String Nombre, String Marca, String Categoria, int Cantidad, String Precio)throws SQLException{
		this.Nombre= Nombre;
		this.Marca=Marca;
		this.Categria=Categoria;
		this.Cantidad=Cantidad;
		this.Precio=Precio;
		
		try {	
			Class.forName("org.sqlite.JDBC");
			conectar();
			sentencia = c.createStatement();
		
			String sqlInsert="INSERT INTO Inventario "+"VALUES('"+Nombre+"','"+Marca+"','"+Categoria+"',"+Cantidad+","+Precio+");";
		
		
			sentencia.executeUpdate(sqlInsert);
			sentencia.close();
			c.close();
			
		
			System.out.println("Datos Insertados");
		}catch(Exception e) {
			System.out.println("Error al insertar datos en la tabla");
		}
	}
	
	public void consultaDatos() throws SQLException {
		conectar();
		sentencia = c.createStatement();
		String consultaSql="SELECT * FROM Inventario;";
		try {
			ResultSet rs= sentencia.executeQuery(consultaSql);
			while(rs.next()) {
				String Nombre=rs.getString("Nombre");
				String Marca=rs.getString("Marca");
				String Categoria=rs.getString("Categoria");
				int Precio=rs.getInt("Precio");
				int Cantidad=rs.getInt("Cantidad");
				System.out.println("Nombre: "+Nombre+", Marca: "+ Marca	+ ", Categoria: "+Categoria+", Cantidad "+Cantidad+", Precio $"+Precio);
				
			}
			rs.close();
			sentencia.close();
			c.close();
		}catch(Exception e) {
			System.out.println("Fallo al recuperar datos");
		}
	}
	
	public void borrar(String Nombre) throws SQLException {
		this.Nombre=Nombre;
		try {
			conectar();
			sentencia=c.createStatement();
			String sql = "DELETE FROM INVENTARIO WHERE Nombre='"+Nombre+"';";
			sentencia.executeUpdate(sql);
			
		}catch(Exception e) {
			System.out.println("Error al borrar datos");
		}
	sentencia.close();
	c.close();
	
	}
	
	}


	
