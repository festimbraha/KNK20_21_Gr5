
package knk;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Stage2 {
		
		private static Button vazhdoBtn = new Button();
		private static Stage mainstage;
		private static Stage3 stage3 = new Stage3();
	
//Titujt e dropdown
		private static	Text studimet = new Text("Niveli i studimeve");
		private static	Text departamenti = new Text("Departamenti");
		private static	Text semestri = new Text("Semestri");
		private static  Text grupiText = new Text("Grupi");

//Niveli i studimeve
		private static String bachelortxt = new String("Bachelor");
		private static String mastertxt = new String("Master");

//Departamenti
		private static String autotxt = new String("Automatike");
		private static String elektxt = new String("Elektroenergjetike");
		private static String elektrtxt = new String("Elektronike");
		private static String komptxt = new String("Kompjuterike");
		private static String teletxt = new String("Telekomunikacion");

//Semestri
		private static String sem1 = new String("I");
		private static String sem2 = new String("II");
		private static String sem3 = new String("III");
		private static String sem4 = new String("IV");
		private static String sem5 = new String("V");
		private static String sem6 = new String("VI");

//Grupi
		private static String gr1 = new String("1");
		private static String gr2 = new String("2");

		private static ComboBox nstud = new ComboBox();
		private static ComboBox dpt = new ComboBox();
		private static ComboBox sem = new ComboBox();
		private static ComboBox grupi = new ComboBox();

		public static void secondarystage(Stage stage2) throws Exception {

		mainstage = stage2;

//Fontet
		studimet.setStyle("-fx-font-size:16;");
		departamenti.setStyle("-fx-font-size:16;");
		semestri.setStyle("-fx-font-size:16;");
		grupiText.setStyle("-fx-font-size:16;");

//BorderPane per Background
		BorderPane bpane = new BorderPane();
		bpane.setPadding(new Insets(100,80,100,80));
		bpane.setStyle("-fx-background-color:#E0E8FF;");
		bpane.setPrefSize(850, 470);

//Gridpane per Combo boxes
		GridPane gpane = new GridPane();
		gpane.setHgap(10);
		gpane.setVgap(15);
		gpane.setAlignment(Pos.TOP_LEFT);
		gpane.setPadding(new Insets(10, 10, 10, 10));
		gpane.setPrefHeight(20);
		gpane.setStyle("-fx-background-color:#FFFFFF;");
		gpane.setEffect(new DropShadow(8,Color.BLACK));
		gpane.setMinHeight(350);
		gpane.setMinWidth(830);

		//COMBO BOXES

		nstud.getItems().clear();
		nstud.setPromptText("Niveli i studimeve");
		nstud.setPrefWidth(190);
		nstud.getItems().addAll(
			bachelortxt,
			mastertxt
		);

		dpt.getItems().clear();
		dpt.setPromptText("departamentiamenti");
		dpt.setPrefWidth(170);
		dpt.getItems().addAll(
			autotxt,
			elektxt,
			elektrtxt,
			komptxt,
			teletxt
		);

		sem.getItems().clear();
		sem.setPromptText("Semestri");
		sem.setPrefWidth(150);
		sem.getItems().addAll(
			sem1,
			sem2,
			sem3,
			sem4,
			sem5,
			sem6
		);

		grupi.getItems().clear();
		grupi.setPromptText("Grupi");
		grupi.setPrefWidth(120);
		grupi.getItems().addAll(
			gr1,
			gr2
		);

//Logo
		Image image = new Image("/images/unipr.png");
		ImageView logo = new ImageView(image);
		logo.setSmooth(true);

//Butoni vazhdo dhe event handlers

		vazhdoBtn.setText("Vazhdo");
		vazhdoBtn.setStyle("-fx-font-size:15;-fx-background-color:#636FD1;-fx-font-weight:bold;-fx-text-fill: white;");
		vazhdoBtn.setPrefSize(180, 30);

		vazhdoBtn.setOnMouseEntered(e -> {
			vazhdoBtn.setStyle("-fx-font-size:15;-fx-background-color:linear-gradient(#636FD1,#43B7FF);-fx-font-weight:bold;-fx-text-fill: white;");
			vazhdoBtn.setCursor(Cursor.HAND);
		});
		vazhdoBtn.setOnMouseExited(e -> {
			vazhdoBtn.setStyle("-fx-font-size:15;-fx-background-color:#636FD1;-fx-font-weight:bold;-fx-text-fill: white;");
		});
		vazhdoBtn.setOnAction(e -> {
			stage2.hide();
			  try {
				  stage3.thirdstage(mainstage);
			  }
			  catch (Exception e1){
			  e1.printStackTrace();
			  }
		});

		gpane.add(studimet, 0, 1);
		gpane.add(nstud,1,1);
		gpane.add(departamenti, 0, 2);
		gpane.add(dpt, 1, 2);
		gpane.add(semestri, 0, 3);
		gpane.add(sem, 1, 3);
		gpane.add(grupiText,0,4);
		gpane.add(grupi,1,4);
		gpane.add(vazhdoBtn, 16, 4);
		gpane.add(logo, 16, 0);
		
		
		bpane.setCenter(gpane);
		Scene scene = new Scene(bpane);
		
		stage2.minWidthProperty().bind(gpane.minWidthProperty());
		stage2.minHeightProperty().bind(gpane.minHeightProperty());
		bpane.minWidthProperty().bind(stage2.minWidthProperty());
		bpane.minHeightProperty().bind(stage2.minHeightProperty());
		
		stage2.setTitle("Sistemi Për Menaxhimin E Orarit Të Studentëve");
		stage2.setScene(scene);
		stage2.getIcons().add(new Image("/images/unipr.png"));
		stage2.show();
	}
		
		
		public static List<Orari> merrOrarin() {
			List<Orari> orariList = new ArrayList();
			String dep=(String) dpt.getValue();
			String nvStud= (String)nstud.getValue();
			String seme=(String) sem.getValue();
			String gr=(String) grupi.getValue();
			System.out.println(nvStud);
			String query = "Select titlenda, ects, profcol, asscol, ldita, lora, lsalla, udita, uora, usalla from orari WHERE nstud=? and departamentiamenti=? and sem=? and grupi=?";
			
			try {
				PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
				preparedStatement.setString(1,nvStud);
				  preparedStatement.setString(2, dep);
				  preparedStatement.setString(3,seme);
				  preparedStatement.setString(4,gr);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Orari orari = new Orari(
											0, resultSet.getString(1),
											resultSet.getInt(2),
											resultSet.getString(3),
											resultSet.getString(4),
											resultSet.getString(5),
											resultSet.getString(6),
											resultSet.getInt(7),
											resultSet.getString(8),
											resultSet.getString(9),
											resultSet.getInt(10), null, null, null, null
											);
					orariList.add(orari);
					
				}
				
			} catch(SQLException ex) {
				ex.printStackTrace();
			}
			
			return orariList;
		}
		
		public static ObservableList<Orari> showOrarin() {
			List<Orari> orariL = merrOrarin();
			
			ObservableList<Orari> orariList = FXCollections.observableArrayList();
			Stage3.table.getColumns().clear();
			for(int i = 0; i < orariL.size(); i++) {
				orariList.add(orariL.get(i));
			}
			return orariList;
		}
}
