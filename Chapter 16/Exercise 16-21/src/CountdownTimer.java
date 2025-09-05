/*
 * Author: Sean Briggs
 * Date: 9/05/2025
 * 
 * Description: This class represents a countdown timer.
 */

import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CountdownTimer extends Application {
    private int seconds = 0;

    @Override
    public void start(Stage primaryStage) {
        MediaPlayer music = new MediaPlayer(new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3"));
        music.setCycleCount(Animation.INDEFINITE);

        TextField timer = new TextField("0");
        timer.setPrefWidth(300);
        timer.setPrefHeight(100);
        timer.setStyle("-fx-font-size: 48px; -fx-alignment: center;");

        Pane pane = new Pane(timer);

        // Create timeline to count down every second
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), _ -> {
                    if (seconds > 0) {
                        seconds--;
                        timer.setText(String.valueOf(seconds));
                    } else {
                        // Timer has reached zero, play sound
                        music.play();
                    }
                }
            )
        );

        timer.setOnAction(_ -> {
            music.stop();
            try {
                seconds = Math.max(0, Integer.parseInt(timer.getText()));
            } catch (NumberFormatException ex) {}
            timer.setText(String.valueOf(seconds));
            timeline.stop();
            timeline.setCycleCount(seconds + 1);
            timeline.play();
        });

        // Create window and set title
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Countdown Timer");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
