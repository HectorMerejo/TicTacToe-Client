package com.thegame.tictactoe.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

public class TicTacToeMain extends Application{

        public static void main(String[] args) {
            Application.launch(args);
        }

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/TicTacToeView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Tic Tac Toe | Merejo, Hector " + new Date());
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        }
    }

