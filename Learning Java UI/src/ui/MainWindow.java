package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainWindow {
	Stage stage;
	
	public MainWindow (Stage mainStage) {
		stage = mainStage;
		
		// Hello world demo
		Button btn = new Button();
		btn.setText("Say 'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hellow World!");
			}
		});
		
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		stage.setScene(new Scene(root, 300, 250));
	}
	
	public void show() {
		stage.show();
	}
}
