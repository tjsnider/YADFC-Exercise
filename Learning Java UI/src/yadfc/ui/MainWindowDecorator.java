package yadfc.ui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import yadfc.ui.panes.ActionPaneDecorator;
import yadfc.ui.panes.MenuPaneDecorator;

public class MainWindowDecorator {
	
	public static Stage decorate (Stage mainStage) {
		mainStage.setTitle("YADFC");

		//TODO: Use BorderPane for main window
		//TODO: Instantiate and decorate the five panes of the BorderPane
		
		BorderPane masterPane = new BorderPane();
		masterPane.setTop(MenuPaneDecorator.decorate(new HBox())); 
		masterPane.setLeft(ActionPaneDecorator.decorate(new VBox()));
		masterPane.setRight(ViewPaneDecorator.decorate(new));
		
		return mainStage;
	}
}
