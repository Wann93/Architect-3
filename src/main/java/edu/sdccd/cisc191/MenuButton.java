package edu.sdccd.cisc191;


import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class MenuButton extends MenuItem{

    private Node item;

    private BorderPane borderPane;

    //lambda expression
    public MenuButton(String text ,Node item, BorderPane borderPane){
        super(text);
        this.item = item;
        this.borderPane = borderPane;
        this.setOnAction(event->handleClick());

    }
    // activate the scene changes
    public void handleClick(){
        borderPane.setCenter(item);

    }

}
