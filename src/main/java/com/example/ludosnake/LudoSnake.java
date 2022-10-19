package com.example.ludosnake;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class LudoSnake extends Application {

    private Group tileGroup = new Group();
    public static final int tileSize = 40;
    int height = 10;
    int width = 10;
    int xLine = 40;
    int yLine = 430;
    public Pane createContent(){
        Pane root = new Pane();
        root.setPrefSize(width*tileSize, height*tileSize+80);
        root.getChildren().addAll(tileGroup);

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Tile tile = new Tile(tileSize, tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                tileGroup.getChildren().addAll(tile);
            }
        }

        Button player1Button = new Button("Player One");
        player1Button.setTranslateX(10);
        player1Button.setTranslateY(yLine);

        Button player2Button = new Button("Player Two");
        player2Button.setTranslateX(300);
        player2Button.setTranslateY(yLine);

        Button startButton = new Button("Start Game");
        startButton.setTranslateX(150);
        startButton.setTranslateY(yLine);

       Image img = new Image("C:\\Users\\PolashBiswas\\IdeaProjects\\LudoSnake\\src\\istockphoto-531466314-1024x1024.jpg");
        //Image //img = new Image("C:\\Users\\PolashBiswas\\IdeaProjects\\LudoSnake\\src\\Snakes_And_Ladders_US_Letter2 (1).jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitHeight(tileSize*height);
        boardImage.setFitWidth(tileSize*width);

        tileGroup.getChildren().addAll(boardImage,player1Button, player2Button, startButton);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(LudoSnake.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Ludo Snake");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}