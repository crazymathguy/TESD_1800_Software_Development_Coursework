/* 
 * Author: Sean Briggs
 * Date Created: 9/4/25
 * 
 * This program creates text that moves and changes color
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ColorChangingText extends Application {
	@Override
	public void start(Stage primaryStage) {
		Text text = new Text(50, 50, "Programming is fun");
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
		colorButtons.setAlignment(Pos.CENTER);
		
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");
		HBox movementButtons = new HBox(10, btLeft, btRight);
		movementButtons.setAlignment(Pos.CENTER);
		
		pane.setTop(colorButtons);
		pane.setBottom(movementButtons);

		rbtRed.setOnAction(e -> text.setStroke(Color.RED));
		rbtYellow.setOnAction(e -> text.setStroke(Color.YELLOW));
		rbtBlack.setOnAction(e -> text.setStroke(Color.BLACK));
		rbtOrange.setOnAction(e -> text.setStroke(Color.ORANGE));
		rbtGreen.setOnAction(e -> text.setStroke(Color.GREEN));

		rbtBlack.setSelected(true);
		text.setFont(new Font("Times-new-roman", 18));
		text.setStroke(Color.BLACK);

		btLeft.setOnAction(e -> text.setX(text.getX() > 10 ? text.getX() - 10 : text.getX()));
		btRight.setOnAction(e -> text.setX(
			text.getX() < textPane.getWidth() - text.getLayoutBounds().getWidth() - 10 ?
			text.getX() + 10 : text.getX()));
		
		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setTitle("Exercise 16-1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}