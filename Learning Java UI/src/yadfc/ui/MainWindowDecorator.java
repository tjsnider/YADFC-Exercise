package yadfc.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindowDecorator {
	
	public static Stage decorate (Stage mainStage) {
		Stage stage;

		stage = mainStage;
		stage.setTitle("YADFC");

		//TODO: Use BorderPane for main window
		//TODO: Instantiate and decorate the five panes of the BorderPane
		
		Scene scene = new Scene(grid, 300, 275);
		stage.setScene(scene);
		
		return stage;
	}
}
