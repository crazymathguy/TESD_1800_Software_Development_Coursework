/* 
 * Author: Sean Briggs
 * Date Created: 9/02/25
 * 
 * This program creates a ball that can be moved around the screen using buttons
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BallWithListeners extends Application {
    @Override
    public void start(Stage primaryStage) {
        BallPane ball = new BallPane();

        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        HBox buttons = new HBox(10, btLeft, btRight, btUp, btDown);
        buttons.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane(ball);
        pane.setBottom(buttons);

        btLeft.setOnAction(e -> {
            ball.moveLeft();
        });
        btRight.setOnAction(e -> {
            ball.moveRight();
        });
        btUp.setOnAction(e -> {
            ball.moveUp();
        });
        btDown.setOnAction(e -> {
            ball.moveDown();
        });

        // Create a scene and place it in the stage
		Scene scene = new Scene(pane, 400, 350);
		primaryStage.setTitle("Exercise 15-3"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class BallPane extends Pane {
    private Circle ball;

    public BallPane() {
        ball = new Circle(200, 150, 20);
        getChildren().add(ball);
    }

    public void moveLeft() {
        ball.setCenterX(ball.getCenterX() > 30 ? ball.getCenterX() - 10 : 30);
    }

    public void moveRight() {
        ball.setCenterX(ball.getCenterX() < getWidth() - 30 ?
            ball.getCenterX() + 10 : ball.getCenterX());
    }

    public void moveUp() {
        ball.setCenterY(ball.getCenterY() > 30 ? ball.getCenterY() - 10 : 30);
    }

    public void moveDown() {
        ball.setCenterY(ball.getCenterY() < getHeight() - 30 ?
            ball.getCenterY() + 10 : ball.getCenterY());
    }
}
