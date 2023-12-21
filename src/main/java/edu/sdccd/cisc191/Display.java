package edu.sdccd.cisc191;
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Display extends Application {

    @Override
        public void start(Stage stage) throws IOException {


        BorderPane root = new BorderPane();
        HBox top = new HBox();
        Scene scene = new Scene(root);
        GridPane diaryPage = new GridPane();
        GridPane goalsPage = new GridPane();
        GridPane homePage = new GridPane();
        getDay day = new getDay();

        // Calls quotes class to homepage
        // display date
        // quotes if the day
        //and app title
        Quotes quotes1 = new Quotes("src/main/resources/quotesbank.txt");
        String toDisplay = quotes1.getRandomQuote();
        labelShow Lb1 = new labelShow(toDisplay, Color.ALICEBLUE, 25);
        labelShow Lb3 = new labelShow(day.getDay(), Color.LIGHTCORAL, 40);
        labelShow Lb2 = new labelShow("My Diary", Color.BLACK, 50);


        VBox vBox1 = new VBox();
        homePage.add(vBox1, 0, 0);
        homePage.setAlignment(Pos.CENTER);
        vBox1.getChildren().addAll(Lb2, Lb3, Lb1);

        //creates Menu,MenuBar and Menu items
        Menu menu = new Menu("Main Menu");
        MenuButton s1 = new MenuButton("Home", homePage, root);
        MenuButton s2 = new MenuButton("Diary", diaryPage, root);
        MenuButton s3 = new MenuButton("Goals", goalsPage, root);
        menu.getItems().add(s1);
        menu.getItems().add(s2);
        menu.getItems().add(s3);
        MenuBar mbd = new MenuBar();

        mbd.getMenus().add(menu);
        root.setTop(mbd);




        String[] moods = {"Happy", "Sad", "Excited", "Angry", "Loved", "Lonely"};

        Arrays.sort(moods);

        ToggleGroup group = new ToggleGroup();
        VBox moodRow = new VBox();


        Arrays.stream(moods).forEach(x->
                {

            RadioButton moodButton = new RadioButton(x);
           moodRow.getChildren().add(moodButton);
            moodButton.setToggleGroup(group);
            moodButton.setStyle("-fx-text-fill:rgb(117,132,178)");
            moodButton.setFont(Font.font("Time New Roman",20));
        });
            diaryPage.add(moodRow,1,0);



        //Diary Page
        // Using Grid pane and
        VBox diaryPageBox = new VBox(diaryPage);
        VBox entrySpace   = new VBox();
        root.setCenter(diaryPageBox);
        TextArea textField = new TextArea();
        ArrayList<Diary> savedEntry = new ArrayList<>();


        //Sets  up table to store entries

        TableView tableView = new TableView<>();
        TableColumn<Diary,String> moodColumn   = new TableColumn<>("Mood");
        TableColumn<Diary,String> entryColumn  =  new TableColumn<>("Entry");
        tableView.getColumns().addAll(entryColumn,moodColumn);

        moodColumn.setCellValueFactory(
                new PropertyValueFactory<>("Mood")
        );
        entryColumn.setCellValueFactory(
                new PropertyValueFactory<>("Text")
        );


        //  lamb
        diaryPage.setMinSize(250, 250);
        Button diaryEntry = new Button("Create New Entry");
        diaryEntry.setOnAction(event -> {
           String selectedMood= ((RadioButton)(group.getSelectedToggle())).getText();;
            System.out.println(textField.getText());
            tableView.getItems().add(new Diary(textField.getText(), selectedMood));
            textField.clear();
        });

            diaryPage.add(tableView,0,3);
        diaryEntry.setMinSize(25, 25);
        diaryEntry.setPadding(new Insets(10, 10, 10, 10));
        diaryPage.add(diaryEntry, 0, 0);



        textField.setMinSize(200, 200);
        diaryPage.add(textField, 0, 1);





         TextArea textArea = new TextArea();
        VBox goalPageBox = new VBox(goalsPage);
        root.setCenter(homePage);
        Button goalsEntry = new Button("Create New Goal ");
        goalsPage.setMinSize(250, 250);
        goalsPage.setPadding(new Insets(10, 10, 10, 10));
        goalsPage.add(goalsEntry, 0, 20);

        textArea.setMinSize(200,200);
        goalsPage.add(textArea,0,1);




        // Creating BackGround
        BackgroundImage image = new BackgroundImage(new Image("/craiyon_212250_open_book_with_darkblue_feather.png", 1400, 800, false, false),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // backround image
        root.setBackground(new Background(image));


        stage.setTitle("Self Love");
        stage.setScene(scene);
        stage.show();

    }



    //attempting to make different scene
    public static void main(String[] args) {
      launch(args);

    }




    }



