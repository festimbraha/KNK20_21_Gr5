package knk;
import java.sql.*;
import java.util.List;

import com.mysql.cj.xdevapi.Table;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class stage3admin {

	private static Stage mainstage;

	private static Stage primaryStage = new Stage();
	// Pjesa per tekst
	private static TextField idF = new TextField();
	private static TextField subjectF = new TextField();
	private static TextField ectsF = new TextField();
	private static TextField profF = new TextField();
	private static TextField assF = new TextField();
	private static TextField Ldita = new TextField();
	private static TextField Lora = new TextField();
	private static TextField Lsalla = new TextField();
	private static TextField Udita = new TextField();
	private static TextField Uora = new TextField();
	private static TextField Usalla = new TextField();
	private static TextField nstud = new TextField();
	private static TextField departamenti = new TextField();
	private static TextField sem = new TextField();
	private static TextField grupi = new TextField();
	
	
	// Buttonat
	private static Button insertBtn = new Button("Insert");



	private static Button logoutBtn = new Button("LogOut");

	
	// Table views
	@SuppressWarnings("rawtypes")
	private static TableView OrariTbl = new TableView();
	
	
	
	public static void adminStage(Stage stage3admin)  {
		
		mainstage = stage3admin;
		// Form pane
		GridPane formPane = new GridPane();

		Label ID = new Label("ID:");
		ID.setStyle("-fx-font-size:10;-fx-text-fill: red;-fx-font-weight:bold;");
		idF.setStyle("-fx-font-size:10;");
		idF.setMaxWidth(1);
		formPane.add(ID, 0, 0);
		formPane.add(idF, 1, 0);


		Label Lenda = new Label("Lenda:");
		Lenda.setStyle("-fx-font-size:10;-fx-text-fill: red;-fx-font-weight:bold;");
		subjectF.setStyle("-fx-font-size:10;");
		subjectF.setMaxWidth(150);
		formPane.add(Lenda, 0, 1);
		formPane.add(subjectF, 1, 1);


		Label Ects = new Label("Ects:");
		Ects.setStyle("-fx-font-size:10;-fx-text-fill: red;-fx-font-weight:bold;");
		ectsF.setStyle("-fx-font-size:10;");
		ectsF.setMaxWidth(40);
		formPane.add(Ects, 2, 1);
		formPane.add(ectsF,3 ,1 );

		Label Profesori = new Label("Profesori:");
		Profesori.setStyle("-fx-font-size:10;-fx-text-fill: blue;-fx-font-weight:bold;");
		profF.setStyle("-fx-font-size:10;");
		profF.setMaxWidth(150);
		formPane.add(Profesori, 0, 2);
		formPane.add(profF,1 ,2 );

		Label Asistenti = new Label("Asistenti:");
		Asistenti.setStyle("-fx-font-size:10;-fx-text-fill: blue;-fx-font-weight:bold;");
		assF.setStyle("-fx-font-size:10;");
		assF.setMaxWidth(150);
		formPane.add(Asistenti, 2, 2);
		formPane.add(assF,3 ,2 );

		Label Ligj = new Label("Ligj/Dita:");
		Ligj.setStyle("-fx-font-size:10;-fx-text-fill: pink;-fx-font-weight:bold;");
		Ldita.setStyle("-fx-font-size:10;");
		Ldita.setMaxWidth(150);
		formPane.add(Ligj, 0, 3);
		formPane.add(Ldita,1 ,3 );

		Label LigjO = new Label("Ligj/Ora:");
		LigjO.setStyle("-fx-font-size:10;-fx-text-fill: pink;-fx-font-weight:bold;");
		Lora.setStyle("-fx-font-size:10;");
		Lora.setMaxWidth(150);
		formPane.add(LigjO, 2, 3);
		formPane.add(Lora,3 ,3 );

		Label LigjS = new Label("Ligj/Salla:");
		LigjS.setStyle("-fx-font-size:10;-fx-text-fill: pink;-fx-font-weight:bold;");
		Lsalla.setStyle("-fx-font-size:10;");
		Lsalla.setMaxWidth(150);
		formPane.add(LigjS, 0, 4);
		formPane.add(Lsalla,1 ,4 );

		Label Usht = new Label("Usht/Dita:");
		Usht.setStyle("-fx-font-size:10;-fx-text-fill: green;-fx-font-weight:bold;");
		Udita.setStyle("-fx-font-size:10;");
		Udita.setMaxWidth(150);
		formPane.add(Usht, 0, 5);
		formPane.add(Udita,1 ,5 );

		Label UshtO = new Label("Usht/Ora:");
		UshtO.setStyle("-fx-font-size:10;-fx-text-fill: green;-fx-font-weight:bold;");
		Uora.setStyle("-fx-font-size:10;");
		Uora.setMaxWidth(150);
		formPane.add(UshtO, 2, 5);
		formPane.add(Uora,3 ,5 );

		Label UshtS = new Label("Usht/Salla:");
		UshtS.setStyle("-fx-font-size:10;-fx-text-fill: green;-fx-font-weight:bold;");
		Usalla.setStyle("-fx-font-size:10;");
		Usalla.setMaxWidth(150);
		formPane.add(UshtS, 0, 6);
		formPane.add(Usalla,1 ,6 );


		formPane.addRow(11, new Label("Niveli stud:"), nstud);
		formPane.addRow(12, new Label("Departamenti:"), departamenti);
		formPane.addRow(13, new Label("Semestri:"), sem);
		formPane.addRow(14, new Label("Grupi:"), grupi);
		
		formPane.setHgap(10);
		formPane.setVgap(5);
		
		idF.setDisable(true);
		
		// Pjesa e butonave
		HBox buttonsPane = new HBox(5);
		
		buttonsPane.getChildren().addAll(insertBtn, logoutBtn);
		insertBtn.setStyle("-fx-background-color:#41B3FF;-fx-font-weight:bold;-fx-text-fill: white;");



		logoutBtn.setStyle("-fx-background-color:#41B3FF;-fx-font-weight:bold;-fx-text-fill: white;");
		insertBtn.setMinWidth(50);



		logoutBtn.setMinWidth(70);


		logoutBtn.setOnAction(e ->{
			Login l=new Login();
			try {
				stage3admin.close();
				l.start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		
		insertBtn.setOnAction(e -> {
			insertOrari();
		});
		




		
		VBox leftPane = new VBox(100);
		
		leftPane.getChildren().addAll(formPane, buttonsPane);
		
		@SuppressWarnings("rawtypes")

		TableColumn teacher = new TableColumn("Mesimdhenesi");
		TableColumn ligjeratacol = new TableColumn("Ligjerata");
		TableColumn ushtrimecol = new TableColumn("Ushtrime");
		// Books table
		TableColumn<String, Orari> column1 = new TableColumn<>("ID:");
		column1.setCellValueFactory(new PropertyValueFactory("id"));

		column1.setMinWidth(150);


		TableColumn<String, Orari> column2 = new TableColumn<>("Lendet");
		column2.setCellValueFactory(new PropertyValueFactory("titlenda"));

		column2.setMinWidth(155);


		TableColumn<String, Orari> column3 = new TableColumn<>("Ects");
		column3.setCellValueFactory(new PropertyValueFactory("ects"));
		column3.setMinWidth(30);


		TableColumn<String, Orari> column4 = new TableColumn<>("Profesori");
		column4.setCellValueFactory(new PropertyValueFactory("profcol"));
		column4.setMinWidth(140);


		TableColumn<String, Orari> column5 = new TableColumn<>("Assistenti");
		column5.setCellValueFactory(new PropertyValueFactory("asscol"));
		column5.setMinWidth(100);


		TableColumn<String, Orari> column6 = new TableColumn<>("Dita");
		column6.setCellValueFactory(new PropertyValueFactory("ldita"));
		column6.setMinWidth(60);


		TableColumn<String, Orari> column7 = new TableColumn<>("Ora");
		column7.setCellValueFactory(new PropertyValueFactory("lora"));
		column7.setMinWidth(70);


		TableColumn<String, Orari> column8 = new TableColumn<>("Salla");
		column8.setCellValueFactory(new PropertyValueFactory("lsalla"));
		column8.setMinWidth(60);


		TableColumn<String, Orari> column9 = new TableColumn<>("Dita");
		column9.setCellValueFactory(new PropertyValueFactory("udita"));
		column9.setMinWidth(70);
		TableColumn<String, Orari> column10 = new TableColumn<>("Ora");
		column10.setCellValueFactory(new PropertyValueFactory("uora"));
		column10.setMinWidth(60);
		TableColumn<String, Orari> column11 = new TableColumn<>("Salla");
		column11.setCellValueFactory(new PropertyValueFactory("usalla"));
		column11.setMinWidth(60);

		teacher.getColumns().addAll(column4,column5);
		ligjeratacol.getColumns().addAll(column6, column7, column8);
		ushtrimecol.getColumns().addAll(column9, column10, column11);
		
		OrariTbl.getColumns().add(column2);
		OrariTbl.getColumns().add(column3);
		OrariTbl.getColumns().add(teacher);
		OrariTbl.getColumns().add(ligjeratacol);
		OrariTbl.getColumns().add(ushtrimecol);
		
		OrariTbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



		OrariTbl.setMinWidth(600);
		OrariTbl.setPrefHeight(200);
		
		// Main Pane ku duhet me bo me minus
		HBox mainPane = new HBox(100);
		
		mainPane.getChildren().addAll(leftPane, OrariTbl);
		
		mainPane.setPadding(new Insets(10, 10, 10 ,10));
		
		
		Scene scene = new Scene(mainPane, 1000, 580);


		scene.getStylesheets().add("style.css");

		stage3admin.setTitle("Admin Stage");
		stage3admin.setScene(scene);

		showOrari();
		
		stage3admin.show();
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static void showOrari() {
		List<Orari> orariL = Orari.getOrari();
		
		ObservableList<Orari> orariList = FXCollections.observableArrayList();
		
		for(int i = 0; i < orariL.size(); i++) {
			orariList.add(orariL.get(i));
		}
		
		OrariTbl.setItems(orariList);
	}
	
	public static void insertOrari() {
		
		if(Orari.addOrari(subjectF.getText(),
						  Integer.parseInt(ectsF.getText()),
						  profF.getText(),
						  assF.getText(),
						  Ldita.getText(),
						  Lora.getText(),
						  Integer.parseInt(Lsalla.getText()),
						  Udita.getText(),
						  Uora.getText(),
						  Integer.parseInt(Usalla.getText()),
						  nstud.getText(),
						  departamenti.getText(),
						  sem.getText(),
						  grupi.getText()
						  ))
		{
			showOrari();
			clearOrari();
		}
	}
	
	public static void clearOrari() {
		idF.setText("");
		subjectF.setText("");
		ectsF.setText("");
		profF.setText("");
		assF.setText("");
		Ldita.setText("");
		Lora.setText("");
		Lsalla.setText("");
		Udita.setText("");
		Uora.setText("");
		Usalla.setText("");
		nstud.setText("");
		departamenti.setText("");
		sem.setText("");
		grupi.setText("");
	}
	public static boolean updateOrari(int id,String titlenda, int ects, String profcol, String asscol, String ldita, String lora, int lsalla, String udita, String uora, int usalla,String nstud, String departamenti, String sem, String grupi) {
		System.out.println(id);
		String query = "UPDATE orari SET titlenda=?, ects=?, profcol=?, asscol=?, ldita=?, lora=?, lsalla=?, udita=?, uora=?, usalla=?, nstud=?, departamenti=?, sem=?, grupi=? WHERE id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			
			preparedStatement.setString(1, titlenda);
			preparedStatement.setInt(2, ects);
			preparedStatement.setString(3, profcol);
			preparedStatement.setString(4, asscol);
			preparedStatement.setString(5, ldita);
			preparedStatement.setString(6, lora);
			preparedStatement.setInt(7, lsalla);
			preparedStatement.setString(8, udita);
			preparedStatement.setString(9, uora);
			preparedStatement.setInt(10, usalla);
			preparedStatement.setString(11, nstud);
			preparedStatement.setString(12, departamenti);
			preparedStatement.setString(13, sem);
			preparedStatement.setString(14, grupi);
			preparedStatement.setInt(15, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public static boolean deleteOrari(int id) {
		String query = "Delete from orari where id=?";
		
		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, id);
			return (preparedStatement.executeUpdate() > 0);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
