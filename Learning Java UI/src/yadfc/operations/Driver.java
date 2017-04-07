package yadfc.operations;

import javafx.application.Application;
import javafx.stage.Stage;
import yadfc.ui.MainWindowDecorator;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage = MainWindowDecorator.decorate(primaryStage);
		primaryStage.show();
	}

}
