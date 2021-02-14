package application;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDAO {

	public static void insertEmployee(String Nombre, String Marca, String Categoria, int Cantidad, String Precio) throws SQLException, ClassNotFoundException {
		String sqlInsert="INSERT INTO Inventario "+"VALUES('"+Nombre+"','"+Marca+"','"+Categoria+"',"+Cantidad+",'$"+Precio+"');";
		
		try {
			DBUtil.dbExecuteQuery(sqlInsert);
			System.out.println("Estamos dentro");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("NO pude añadir los datos.");
			e.printStackTrace();
		}
		
		
	}
	
	public static void updateEmployee(String Nombre, int Cantidad) throws SQLException, ClassNotFoundException {
		String sqlInsert="UPDATE Inventario SET Cantidad ="+Cantidad+" WHERE Nombre = '"+Nombre+"'";
		
		try {
			DBUtil.dbExecuteQuery(sqlInsert);
			System.out.println("Actualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("NO pude Actualizar los datos.");
			e.printStackTrace();
		}
		
		
	}
	
	public static void deleteEmployee(String Nombre) throws SQLException, ClassNotFoundException {
		String sqlInsert="DELETE FROM INVENTARIO WHERE Nombre='"+Nombre+"';";
		
		try {
			DBUtil.dbExecuteQuery(sqlInsert);
			System.out.println("Actualizado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("NO pude Actualizar los datos.");
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static ObservableList<Employee> getAllRecords() throws SQLException, ClassNotFoundException {
		String sqlInsert="SELECT * FROM Inventario;";
		
		try {
			
			ResultSet rsSet=DBUtil.dbExecute(sqlInsert);
			ObservableList<Employee> emplist = getEmployeeObjects(rsSet);
			return emplist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No encontre datos");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	private static ObservableList<Employee> getEmployeeObjects(ResultSet rsSet) throws ClassNotFoundException, SQLException{
		try {
			ObservableList<Employee> emplist = FXCollections.observableArrayList();
			
			while(rsSet.next()) {
				Employee emp = new Employee();
				emp.setEmpNombre(rsSet.getString("Nombre"));
				emp.setEmpMarca(rsSet.getString("Marca"));
				emp.setEmpCategoria(rsSet.getString("Categoria"));
				emp.setEmpPrecio(rsSet.getString("Precio"));
				
				emp.setEmpCantidad(rsSet.getInt("Cantidad"));
				
				
				
				emplist.add(emp);
			}
			
			return emplist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No encontre datos");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public static ObservableList<Employee> searchEmployee(String Nombre) throws ClassNotFoundException, SQLException{
		String sqlInsert="SELECT * FROM Inventario WHERE Nombre = '"+Nombre+"';";
		
		try {
			
			ResultSet rsSet=DBUtil.dbExecute(sqlInsert);
			
			ObservableList<Employee> emplist = getEmployeeObjects(rsSet);
			return emplist;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("search failed");
			e.printStackTrace();
			throw e;
		}
		
	}

	public static ObservableList<Employee> searchCategoryEmployee(String Categoria) throws ClassNotFoundException, SQLException{
		String sqlInsert="SELECT * FROM Inventario WHERE Categoria = '"+Categoria+"';";
		
		try {
			
			ResultSet rsSet=DBUtil.dbExecute(sqlInsert);
			
			ObservableList<Employee> emplist = getEmployeeObjects(rsSet);
			return emplist;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("search failed");
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
