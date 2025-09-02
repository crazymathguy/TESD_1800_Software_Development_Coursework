/* 
 * Author: Sean Briggs
 * Date Created: 9/02/25
 * 
 * This program creates a rectangle that is moved around the screen following a pentagonal path
 */

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RectangleAnimation extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle(0, 0, 50, 30);
        rectangle.setFill(Color.ORANGE);

        Polygon path = new Polygon();
		path.setFill(Color.WHITE);
		path.setStroke(null);
		ObservableList<Double> pathList = path.getPoints();
		
		double centerX = pane.getWidth() / 2, centerY = pane.getHeight() / 2;
		double radius = Math.min(pane.getWidth(), pane.getHeight()) * 0.4;
		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		int s = 5;
		// Add points to the polygon list
		for (int i = 0; i < s; i++) {
			pathList.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
			pathList.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
		}
		path.setRotate(180 / s);

        pane.getChildren().addAll(path, rectangle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(path);
        pt.setNode(rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft = new FadeTransition(
            Duration.millis(4000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        path.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                pt.play();
                ft.play();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                pt.pause();
                ft.pause();
            }
        });

        // Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 350);
		primaryStage.setTitle("Exercise 15-Animation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}
