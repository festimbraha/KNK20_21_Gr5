package knk;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Help {

	public static void ndihme() {

		Stage helpAboutStage = new Stage();

		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();
        
		String url = Help.class.getResource("Ndihme.html").toExternalForm();

		System.out.println("Local URL: " + url);

		webEngine.load(url);

		Scene sc = new Scene(browser, 500, 300);

		helpAboutStage.setTitle("Ndihme");
		helpAboutStage.setScene(sc);

		helpAboutStage.show();
	}
	public static void help() {

		Stage helpAboutStage = new Stage();

		WebView browser = new WebView();

		WebEngine webEngine = browser.getEngine();
        
		String url = Help.class.getResource("Help.html").toExternalForm();

		System.out.println("Local URL: " + url);

		webEngine.load(url);

		Scene sc = new Scene(browser, 500, 300);

		helpAboutStage.setTitle("Help");
		helpAboutStage.setScene(sc);

		helpAboutStage.show();
	}

}
