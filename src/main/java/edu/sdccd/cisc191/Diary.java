package edu.sdccd.cisc191;

import java.io.Serializable;
import java.time.LocalDate;

public class Diary implements Serializable {
    private String Mood;
    private String Text;
    private LocalDate date;
    public Diary (String text, String selectedMood){
        this.date =LocalDate.now();
        this.Text=text;
        this.Mood = selectedMood;


    }
    public String getMood(){
        return Mood;
    }

    public void setMood(String mood) {
        Mood = mood;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getText() {
        return Text;
    }
}
