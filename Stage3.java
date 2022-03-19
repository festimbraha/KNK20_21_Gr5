package knk;
import com.sun.javafx.stage.EmbeddedWindow;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import javafx.scene.Scene;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;




public class Stage3 {





		private static Stage mainstage;
		public static TableView<Orari> table = new TableView<Orari>();
		private static Button kthehu = new Button("Kthehu");




		private static TableColumn idcol = new TableColumn();
		private static TableColumn lenda = new TableColumn("Lenda");
		
		
		private static TableColumn kredi = new TableColumn("Kredite");
		
		private static TableColumn prof = new TableColumn("Profesoret");
		private static TableColumn profcol = new TableColumn("Profesor");
		private static TableColumn asscol = new TableColumn("Asistenti");
		
		private static TableColumn ligjeratacol = new TableColumn("Mbajtja e ligjeratave");
		
		
		
		private static TableColumn ldita = new TableColumn("Dita");
		private static TableColumn lora = new TableColumn("Ora");
		private static TableColumn lsalla = new TableColumn("Salla e percaktuar");

		
		private static Label errormsg = new Label("Nuk ka te dhena nga kjo pjese.");




		public void thirdstage(Stage stage3) throws FileNotFoundException {
			 
		mainstage = stage3;







		BorderPane bpane = new BorderPane();





		bpane.setPadding(new Insets(40,25,50,25));
		bpane.setStyle("-fx-background-color:#023557;");






		
		table.setPrefSize(480, 115);
		lenda.setMinWidth(130);
		kredi.setPrefWidth(40);
		kredi.setMinWidth(40);
		prof.setMinWidth(250);
		profcol.setMinWidth(125);
		asscol.setMinWidth(125);
		ligjeratacol.setMinWidth(180);
		ldita.setMinWidth(80);
		lora.setMinWidth(50);
		lsalla.setMinWidth(50);


	    if(table.getColumns().size()==0) {
	   table.getItems().clear();
	   prof.getColumns().addAll(profcol,asscol);
		
		ligjeratacol.getColumns().addAll(ldita, lora, lsalla);

	    
		idcol.setCellValueFactory(new PropertyValueFactory("id"));
		lenda.setCellValueFactory(
	       new PropertyValueFactory<Orari, String>("titlenda"));
	    kredi.setCellValueFactory(
	 	       new PropertyValueFactory<Orari, String>("ects"));
	    prof.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("teacher"));
	    profcol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("profcol"));
	    asscol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("asscol"));
	    
	    ligjeratacol.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("ligjeratacol"));
	    ldita.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("ldita"));
	    lora.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("lora"));
	    lsalla.setCellValueFactory(
		 	       new PropertyValueFactory<Orari, String>("lsalla"));


	    
	    
	    table.setPlaceholder(errormsg);
	    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    table.getItems().clear();
	    }
	    table.setItems( Stage2.showOrarin());
		table.getColumns().addAll(lenda, kredi, prof,ligjeratacol);
		table.setEditable(false);
	
				HBox hbox = new HBox();
				hbox.setPadding(new Insets(10,10,10,1));
				hbox.getChildren().add(kthehu);
				kthehu.setPrefHeight(30);
				kthehu.setPrefWidth(70);
				kthehu.setStyle("-fx-background-color:white;-fx-font-color:bold;-fx-text-fill: black;");

				kthehu.setOnAction(e ->{
					stage3.hide();



					try {
						Stage2.secondarystage(mainstage);
					} catch (Exception e1) {
					
						e1.printStackTrace();
					}
				});
				kthehu.setOnMouseEntered(e ->{
					kthehu.setStyle("-fx-background-color:linear-gradient(white,white);-fx-font-weight:bold;-fx-text-fill: black;");
					kthehu.setCursor(Cursor.HAND);
				});
				kthehu.setOnMouseExited(e -> {
					kthehu.setStyle("-fx-background-color:white;-fx-font-weight:bold;-fx-text-fill: black;");
				});

				
				

				Insets tblinsets = new Insets (80,2,20,1);
				bpane.setMargin(table, tblinsets);
				bpane.setTop(hbox);
				bpane.setCenter(table);
				bpane.setMinHeight(600);
				bpane.setMinWidth(967);




				
				Scene scene = new Scene(bpane,950,600);



			String css = this.getClass().getResource("style.css").toExternalForm();
			scene.getStylesheets().add(css);
				
				bpane.minWidthProperty().bind(stage3.minWidthProperty());
				bpane.minHeightProperty().bind(stage3.minHeightProperty());
				stage3.setTitle("SMO - FIEK");
				stage3.setScene(scene);
				stage3.getIcons().add(new Image("/images/unipr.png"));
				stage3.show();




			}
				public static void shfaqVlerat(ObservableList<Orari> orariList) {
					System.out.println(orariList);
					table.setItems(orariList);
				}
				public static ObservableList<Orari> data(ObservableList<Orari> orariList) {
					System.out.println(orariList);
					table.setItems(orariList);
					return orariList;
				}


		}
