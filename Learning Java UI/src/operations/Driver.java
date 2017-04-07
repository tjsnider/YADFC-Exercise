package operations;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.MainWindow;

public class Driver extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MainWindow main = new MainWindow(primaryStage);
		main.show();
	}

}
