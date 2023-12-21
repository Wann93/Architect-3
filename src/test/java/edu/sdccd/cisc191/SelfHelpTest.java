package edu.sdccd.cisc191;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SelfHelpTest {


        String diaryTestEntry = "The number 42 is the answer to the ultimate question of life, " +
                "the universe, and everything";
        String mood = "Hateful";
        String testFileText = "Test Quote 1";
        String filePath = "src/test/resources/testFile.txt";

        // Test creation of a diary entry by providing a text and mood
        @Test
        void testCreate() {
            Diary testEntry = new Diary(null, null);
            testEntry.setText(diaryTestEntry);
            testEntry.setMood(mood);
            Assertions.assertEquals(testEntry.getText(), diaryTestEntry);
            Assertions.assertEquals(testEntry.getMood(), mood);
        }

        // Open a file
        // Assert file can be opened from specified directory
        // Assert information read from file matches expected
        @Test
        void testFile(){
            Quotes testFile = new Quotes(filePath);
            Assertions.assertNotNull(testFile);
            Assertions.assertEquals(testFile.getRandomQuote(), testFileText);
        }

        //For this test to work
        // UPDATE TO CURRENT DAY
        @Test
        void testGetDay() {
            getDay testGetDay = new getDay();
            Assertions.assertEquals(testGetDay.getDay(),"Wednesday,December 20 2023");
        }
}
