package edu.sdccd.cisc191;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Arrays;

import static javafx.scene.text.FontWeight.BOLD;

public class labelShow extends Label  {


    public labelShow(String name , Color color, int size) {
        super(name);
        this.setTextFill(color);
        this.setFont(Font.font("Times New Roman",BOLD,size));


    }
}