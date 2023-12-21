package edu.sdccd.cisc191;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Quotes {
    String directory = "./src/main/resources/";

   public ArrayList< ArrayList<String>> quotes = new ArrayList<ArrayList<String>>();
    String dailyQuote;
    String line;
    String banner = "Quote Of The Day";







    // Opens Files (TextIO)
    //Reads from the file
    // stores  quotes in an array list
    public  Quotes(String filepath ) {
        BufferedReader buff = null;
        try {
            FileReader reader = new FileReader(filepath);
            buff = new BufferedReader(reader); // PASSES FILE READER THROUGH BUFFER READER
        } catch (
                FileNotFoundException e) {
            System.out.println("Failed to read from file");
        }

        try {
            ArrayList<String> quoteMoods = null;
            while ((line = buff.readLine()) != null) {
                if (line.contains("#")) {
                    quoteMoods = new ArrayList<String>();
                    quotes.add(quoteMoods);
                    line = buff.readLine();
                }
                quoteMoods.add(line);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }






    }
    // this will get random quotes
    public String getRandomQuote() {
        int moodNumber;
        int quoteNumber;
        Random rand = new Random();   // random class to generate quotes

       moodNumber = rand.nextInt(quotes.size());
       quoteNumber = rand.nextInt(quotes.get(moodNumber).size());
         dailyQuote = quotes.get(moodNumber).get(quoteNumber);
         System.out.println(banner);
         System.out.println(dailyQuote);
        return dailyQuote;
    }



}