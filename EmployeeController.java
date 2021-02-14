package application;


import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class EmployeeController {

	@FXML
	private TextField txtArticulo;
	@FXML
	private TextField txtMarca;
	@FXML
	private TextField intCantidad;
	@FXML
	private TextField txtPrice;
	@FXML
	private TextField txtCategoria;
	
	
	@FXML
	private TextField txtArticuloSearch;
	@FXML
	private TextField txtCategorySearch;
	@FXML
	private TextField intCantidadSearch;

	
	@FXML
	private TableColumn<Employee, String> colEmpNombre;
	@FXML
	private TableColumn<Employee, String> colEmpMarca;
	@FXML
	private TableColumn<Employee, String> colEmpCategoria;
	@FXML
	private TableColumn<Employee, String> colEmpPrice;
	@FXML
	private TableColumn<Employee, Integer> colEmpCantidad;
	
	
	@FXML
	private TableView employeeTable;
	
	
	
	@FXML
	private void insertEmployee(ActionEvent event) throws SQLException, ClassNotFoundException{
		int cant=Integer.parseInt(intCantidad.getText()); 
		
		EmployeeDAO.insertEmployee(txtArticulo.getText(), txtMarca.getText(), txtCategoria.getText(), cant, txtPrice.getText());
		
		ObservableList<Employee> emplist = EmployeeDAO.getAllRecords();
		populateTable(emplist);
		
		txtArticulo.clear();
		txtMarca.clear();
		intCantidad.clear();
		txtPrice.clear();
		txtCategoria.clear();
		
		
	}
	
	@FXML
	private void updateEmployee(ActionEvent event) throws SQLException, ClassNotFoundException{
		int cant=Integer.parseInt(intCantidadSearch.getText()); 
		
		EmployeeDAO.updateEmployee(txtArticuloSearch.getText(), cant);
		ObservableList<Employee> emplist = EmployeeDAO.getAllRecords();
		populateTable(emplist);
		
		intCantidadSearch.clear();
		txtArticuloSearch.clear();
		
	}
	
	@FXML
	private void deleteEmployee(ActionEvent event) throws SQLException, ClassNotFoundException{
		EmployeeDAO.deleteEmployee(txtArticuloSearch.getText());
		
		ObservableList<Employee> emplist = EmployeeDAO.getAllRecords();
		populateTable(emplist);
		
		txtArticuloSearch.clear();
		
	}
	
	
	@FXML
	private void initialize() throws Exception{
		colEmpNombre.setCellValueFactory(cellData -> cellData.getValue().getEmployeeNombre());
		colEmpMarca.setCellValueFactory(cellData -> cellData.getValue().getEmployeeMarca());
		colEmpCategoria.setCellValueFactory(cellData -> cellData.getValue().getEmployeeCategoria());
		colEmpCantidad.setCellValueFactory(cellData -> cellData.getValue().getEmployeeCantidad().asObject());
		colEmpPrice.setCellValueFactory(cellData -> cellData.getValue().getEmployeePrecio());
		
		
		ObservableList<Employee> emplist = EmployeeDAO.getAllRecords();
		populateTable(emplist);
		
	}
	
	private void populateTable(ObservableList<Employee> empList) {
		employeeTable.setItems(empList);
	}
	
	@FXML
	private void searchEmployee(ActionEvent event) throws SQLException, ClassNotFoundException{
		ObservableList<Employee> list = EmployeeDAO.searchEmployee(txtArticuloSearch.getText());
		
		 
		populateTable(list);
		
		txtArticuloSearch.clear();
	}
	
	@FXML
	private void searchCategoryEmployee(ActionEvent event) throws SQLException, ClassNotFoundException{
		ObservableList<Employee> list = EmployeeDAO.searchCategoryEmployee(txtCategorySearch.getText());
		
		 
		populateTable(list);
		
		txtCategorySearch.clear();
	}
	
	@FXML
	private void searchAll(ActionEvent event) throws SQLException, ClassNotFoundException{
		ObservableList<Employee> emplist = EmployeeDAO.getAllRecords();
		populateTable(emplist);
		
	}
	
	@FXML
	private void delete(ActionEvent event) throws SQLException, ClassNotFoundException{
		txtArticulo.clear();
		txtMarca.clear();
		intCantidad.clear();
		txtPrice.clear();
		txtCategoria.clear();
		intCantidadSearch.clear();
		txtArticuloSearch.clear();
		txtCategorySearch.clear();
		
	}
	
}
