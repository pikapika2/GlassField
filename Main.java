package application;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	public Scene recorder = null;
	SetRecorder setR = new SetRecorder();
	@Override
	public void start(Stage primaryStage) {
		try {
			DatePicker myDatePicker = new DatePicker(LocalDate.now());
			DatePickerSkin skin = new DatePickerSkin(myDatePicker);
			Node calender = skin.getPopupContent();
			Button choice = new Button("Œˆ’è");
			choice.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent ev) {
				    System.out.println(myDatePicker.getValue());	
				    recorder = setR.set();
				    setScene(primaryStage, recorder); 
				    System.out.println("hoge");
			    }
			});

			FlowPane ch = new FlowPane();
			ch.getChildren().addAll(myDatePicker, choice);
			SplitPane root = new SplitPane(ch, calender);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Calender.css").toExternalForm());
			
			primaryStage.setTitle("Calender");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setScene (Stage stage, Scene changescene) {
		stage.setScene(changescene);
		stage.show();
		System.out.println("piyo");
	} 
	
	public static void main(String[] args) {
		launch(args);
	}
}
