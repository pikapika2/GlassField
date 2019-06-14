package application;
	
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.fxml.FXMLLoader;


public class SetRecorder {
	public Scene set() {
			Scene recorder = new Scene(null);
			Pane root = new Pane();
			try {
				root = (Pane)FXMLLoader.load(getClass().getResource("Use.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			recorder = new Scene(root,400,400);
			recorder.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			return recorder;

	}

}
