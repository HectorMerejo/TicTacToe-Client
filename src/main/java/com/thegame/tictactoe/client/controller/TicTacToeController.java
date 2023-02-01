package com.thegame.tictactoe.client.controller;

import com.jbbwebsolutions.http.utility.JSONGet;
import com.thegame.tictactoe.client.model.TicTacToeResults;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;


public class TicTacToeController {

    @FXML
    private Label lblTitle;

    @FXML
    private FlowPane fpMoves;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblURL;

    @FXML
    //represents everytime something is clicked
    void xOrO(MouseEvent event) {
        //downcast object source to Label
        //Now represents a label
        var source = (Label) event.getSource();

        //This if statement means that if its equal to N
        //Don't do letter logic underneath
        //Also if letter is clicked more than once an lblMessage will display
        lblMessage.setText(""); //Will erase lblMessage once player keeps playing
        if (!source.getText().equals("N")){
            lblMessage.setText("Invalid move was made!");
            return;
        }

        //if X is equal to true it'll put an X in letter variable
        //if false it'll return O
        var letter= isX ? "X": "O";
        source.setText(letter);

        //negating the isX means if !isX is true it'll return false
        //if its false it'll return true
        isX = !isX;

        //builds url and displays it on the bottom
        String url =  "http://localhost:9215/tictactoe?position=" + getMoves();

        //gets JSON results
        var results = JSONGet.submitGet(url, TicTacToeResults.class);
        lblURL.setText(url + " " + results);

        if (results.isStatus()){

            //gets all the winning info
            int p1 = results.getP1();
            int p2 = results.getP2();
            int p3 = results.getP3();

            //gets the label children
            //returning a stream of nodes
            //turns it into a list
            var moves = fpMoves.getChildren().stream().toList();

            //turns the winning positions to the color in css .winner
            moves.get(p1).getStyleClass().add("winner");
            moves.get(p2).getStyleClass().add("winner");
            moves.get(p3).getStyleClass().add("winner");

            //label.getStyleClass().add("winner");
        }
    }

    //gets the children to make the url and adds equals it to position up top
    private String getMoves() {
        //.map converts every row out of e to a label.
        //label then gets the Text from the row
        //text turns into an array
        var moves = fpMoves.getChildren().stream()
                .map(e-> ((Label)e).getText()).toArray(String[]::new);

        //x variable grabs the moves and joins it as a string
        var x = String.join("",moves);

        return x;
    }

    private boolean isX = true;

    @FXML
    void reset(ActionEvent event) {

        //resets everything back to N
        //gets children from fxml file
        //e represents the current object thats in the children
        fpMoves.getChildren().forEach(e ->{
            Label label = (Label)e;
            label.setText("N");
            //removes winner class after reset
            label.getStyleClass().remove("winner");

        });

        //erases lblMessage and lblURL once reset is clicked
        lblMessage.setText("");
        lblURL.setText("");
    }

}
