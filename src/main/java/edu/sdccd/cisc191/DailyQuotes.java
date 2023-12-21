package edu.sdccd.cisc191;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class DailyQuotes {
    public static void main(String[] args) throws IOException {

         String todaysQuotes;


        String[] moods = {"happy", "Sad", "Excited", "Angry", "Loved", "Lonely"};
        Arrays.sort(moods);

       Scanner Usertext = new Scanner(System.in);



        getDay dayOfWeek = new getDay();
        String currentDay = dayOfWeek.getDay();
        System.out.println(currentDay);

        Quotes giveQuotes = new Quotes("src/main/resources/quotesbank.txt");
        giveQuotes.getRandomQuote();


        // creates new goal
        //Goals newGoal = new Goals();

       //TODO Fix hard code
        Diary newEntry = new Diary("Happy", "happy");


        // TODO fix tree
        DiaryNode yourDiary = new DiaryNode(newEntry);
        DiaryNode root = yourDiary;
        for (int i = 0; i < 10; i++) {
            DiaryNode nextNode = new DiaryNode(newEntry);
            yourDiary.add(nextNode);
            yourDiary = nextNode;


        }


        SearchEntries search = new SearchEntries();
        DiaryNode temp1 = search.contains(root, "Happy");
        DiaryNode temp2 = search.contains(root, "Sad");
        DiaryNode temp3 = search.contains(root, "Loved");
        DiaryNode temp4 = search.contains(root, "Angry");
        DiaryNode temp5 = search.contains(root, "Lonely");
        DiaryNode temp6 = search.contains(root, "Excited");


        serialization(root);
        DiaryNode root2 = deserialize("testOutput.txt");








        // end main
    }
    // Mod 7 IO stream

    public static void serialization(Object target) throws IOException {
        String fileName = "testOutput.txt";
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream object = new ObjectOutputStream(file);

            object.writeObject(target);

            object.close();
            file.close();

        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }
        public static DiaryNode deserialize(String fileName) throws IOException {
            DiaryNode Obj1 = null;
            try {
                FileInputStream file2 = new FileInputStream(fileName);
                ObjectInputStream Obj2 = new ObjectInputStream(file2);
                Obj1 = (DiaryNode)Obj2.readObject();

                Obj2.close();
                file2.close();
                
            } catch (IOException | ClassNotFoundException ex) {

                System.out.println("blues");
            }


            return Obj1;
        }

}
