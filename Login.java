package knk;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;
import java.sql.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login extends Application {


	static String result[];
	private Connection dbConnection;
	private TextField ID = new TextField();
	private PasswordField passwordTxt = new PasswordField();
	public Stage mainStage;
	private Button logInButton = new Button("Kycu");
	private Label resetpassword = new Label("Keni harruar fjalekalimin?");
	private Button Shqip = new Button("Shqip");
	private Button English = new Button("English");


	@Override
	public void start(Stage primaryStage) throws Exception {

		mainStage = primaryStage;
		dbConnection = DBConnection.getConnection();
		setConnection();


		BorderPane bpane = new BorderPane();
		bpane.setPadding(new Insets(40, 200, 70, 200));
		bpane.setStyle("-fx-background-color:#efefef;");
		bpane.setPrefSize(850, 500);




//Create and add menu items to menu

		Menu editmenu= new Menu("_Click Me");

		MenuItem cut= new MenuItem("Help");
		editmenu.getItems().add(cut);
		cut.setOnAction(e -> {
			getHostServices().showDocument("C:\\Users\\erata\\OneDrive\\Desktop\\drive-download-20210706T211453Z-001\\src\\knk\\Help.html");
		});

//Main menu bar
		MenuBar menubar= new MenuBar();
		menubar.getMenus().addAll(editmenu);
		GridPane gridPane = new GridPane();
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setStyle("-fx-background-color:#f2f2f2;");
		gridPane.setEffect(new DropShadow(8, Color.BLACK));
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setMinWidth(395);
		gridPane.setMinHeight(450);

//Logo
		Image image = new Image("/images/unipr.png");
		ImageView logo = new ImageView(image);
		logo.setSmooth(true);
		gridPane.add(logo, 1, 0);

// User
		Label ID = new Label("Perdoruesi:");
		ID.setStyle("-fx-font-size:15;");
		this.ID.setPromptText("ID");
		this.ID.setStyle("-fx-font-size:15;");
		this.ID.setMaxWidth(150);
		gridPane.add(ID, 0, 1);
		gridPane.add(this.ID, 1, 1);

// Password
		Label PW = new Label("Fjalekalimi:");
		PW.setStyle("-fx-font-size:15;");
		passwordTxt.setStyle("-fx-font-size:15;");
		passwordTxt.setMaxWidth(150);
		gridPane.add(PW, 0, 2);
		gridPane.add(passwordTxt, 1, 2);

//RadioButton
		Label lbl1 = new Label("Mbaj mend");
		ToggleGroup lblGr = new ToggleGroup();
		RadioButton PoRadioButton = new RadioButton("Po");
		RadioButton JoRadioButton = new RadioButton("Jo");
		PoRadioButton.setToggleGroup(lblGr);
		JoRadioButton.setToggleGroup(lblGr);
		gridPane.add(lbl1, 0, 5);
		gridPane.add(new HBox(15, PoRadioButton, JoRadioButton), 1, 5, 2, 1);

//LogIn Buton
		logInButton.setPrefWidth(150);
		logInButton.setStyle("-fx-background-color:#41B3FF;-fx-font-weight:bold;-fx-text-fill: white;");
		gridPane.add(logInButton, 1, 3);
		logInButton.setDefaultButton(true);

		logInButton.setOnAction(e -> {
			loginUser();
		});

		logInButton.setOnMouseEntered(e -> {
			logInButton.setStyle(
					"-fx-background-color:linear-gradient(#41B3FF,#41B3FF);-fx-font-weight:bold;-fx-text-fill: white;");
			logInButton.setCursor(Cursor.HAND);
		});
		logInButton.setOnMouseExited(e -> {
			logInButton.setStyle("-fx-background-color:#41B3FF;-fx-font-weight:bold;-fx-text-fill: white;");
		});

//Reset psw

		resetpassword.setUnderline(true);
		gridPane.add(resetpassword, 1, 4);

		resetpassword.setOnMouseClicked(e -> {
			getHostServices().showDocument("https://notimi.uni-pr.edu/ResetPassword");
		});
		resetpassword.setOnMouseEntered(e -> {
			resetpassword.setCursor(Cursor.HAND);
			resetpassword.setStyle("-fx-text-fill:#41B3FF;");
		});
		resetpassword.setOnMouseExited(e -> {
			resetpassword.setStyle("-fx-text-fill: BLACK;");
		});



// Shqip
		Shqip.setUnderline(false);
		Shqip.setOnMouseEntered(e -> {
			Shqip.setCursor(Cursor.HAND);
			Shqip.setStyle("-fx-text-fill:#41B3FF;");
		});
		Shqip.setOnMouseExited(e -> {
			Shqip.setStyle("-fx-text-fill: BLACK;");
		});

//English
		English.setUnderline(false);
		English.setOnMouseEntered(e -> {
			English.setCursor(Cursor.HAND);
			English.setStyle("-fx-text-fill:#41B3FF;");
		});
		English.setOnMouseExited(e -> {
			English.setStyle("-fx-text-fill: BLACK;");
		});

//Ndryshimi i gjuhes

		Shqip.setOnMousePressed(e -> {
			logInButton.setText("Kycu");
			ID.setText("Perdoruesi: ");
			PW.setText("Fjalekalimi: ");
			English.setText("Anglisht");
			Shqip.setText("Shqip");
			resetpassword.setText("Keni harruar fjalekalimin?");
			primaryStage.setTitle("SMO-FIEK");
		});

		English.setOnMousePressed(e -> {
			logInButton.setText("Login");
			ID.setText("Username: ");
			PW.setText("Password: ");
			English.setText("English");
			Shqip.setText("Albanian");
			resetpassword.setText("Forgot password?");
			primaryStage.setTitle("Schedule Management Application");
		});



		HBox hbox = new HBox(5);
		gridPane.add(hbox, 3, 8);
		hbox.getChildren().addAll(Shqip, English);

		bpane.setCenter(gridPane);
		bpane.setTop(menubar);
		Scene scene = new Scene(bpane);

		primaryStage.setTitle("SMO-FIEK");
		primaryStage.setScene(scene);
		primaryStage.minWidthProperty().bind(gridPane.minWidthProperty());
		primaryStage.minHeightProperty().bind(gridPane.minHeightProperty());
		bpane.minWidthProperty().bind(primaryStage.minWidthProperty());
		bpane.minHeightProperty().bind(primaryStage.minHeightProperty());

		primaryStage.getIcons().add(new Image("/images/unipr.png"));
		primaryStage.show();

	}

	private void setConnection() {
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private void loginUser() {
		String query = "Select * from users where numriid = ? AND password = ?";
		try {
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);

			preparedStatement.setString(1, ID.getText());
			preparedStatement.setString(2, passwordTxt.getText());
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setResizable(false);
				alert.setTitle("Kycja");
				alert.setHeaderText(null);
				alert.setContentText("Jeni kycur me sukses!");
				alert.showAndWait();
				mainStage.hide();
				String usr = String.valueOf(ID.getText());
				BigInteger bi = new BigInteger(usr);
				BigInteger one = new BigInteger("1");
				int test = bi.compareTo(one);
				if (test == 0) {
					try {
						stage3admin.adminStage(mainStage);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						Stage2.secondarystage(mainStage);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}

			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setResizable(false);
				alert.setTitle("Kycja");
				alert.setHeaderText(null);
				alert.setContentText("Email ose password i gabuar!");
				alert.showAndWait();
			}

		} catch (SQLException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setResizable(false);
			alert.setTitle("Problem gjate lidhjes me databaze!");
			alert.setHeaderText(null);
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
			System.exit(0);
		}

	}

	public static String getMd5(String input) {
		try {

			// Static getInstance method is called with hashing MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(input.getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}


	}



}