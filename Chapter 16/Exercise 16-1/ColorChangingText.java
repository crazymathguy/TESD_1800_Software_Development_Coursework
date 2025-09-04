import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ColorChangingText extends Application {
	@Override
	public void start(Stage primaryStage) {
		Text text = new Text("Programming is fun", 50, 50);
		Pane textPane = new Pane(text);
		BorderPane pane = new BorderPane(textPane);
		
		RadioButton rbtRed = new RadioButton("Red");
		RadioButton rbtYellow = new RadioButton("Yellow");
		RadioButton rbtBlack = new RadioButton("Black");
		RadioButton rbtOrange = new RadioButton("Orange");
		RadioButton rbtGreen = new RadioButton("Green");
		ToggleGroup group = new ToggleGroup();
		rbtRed.setToggleGroup(group);
		rbtYellow.setToggleGroup(group);
		rbtBlack.setToggleGroup(group);
		rbtOrange.setToggleGroup(group);
		rbtGreen.setToggleGroup(group);
		HBox colorButtons = new HBox(10, rbtRed, rbtYellow, rbtBlack, rbtOrange, rbtGreen);
		
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		HBox movementButtons = new HBox(10, btLeft, btRight);
		
		pane.setTop(colorButtons);
		pane.setBottom(movementButtons);
		
		Scene scene = new Scene(pane, 350, 200);
		primaryStage.setTitle("Exercise 16-1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}