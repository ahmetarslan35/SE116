import java.io.*;
import java.util.Scanner;

public class Highscores {
    public static void createFile() {

        File highscores = new File("highscore.txt");
        try {
            highscores.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();


        }


    }
/* Burda da skorlar büyükten küçüğe doğru ilk 5 sıralanacak*/
    public static void readHighscores() {
        File highscores = new File("highscore.txt");
        int counter =1 ;
        try {
            Scanner reader = new Scanner(highscores);
            System.out.println("----SCORE TABLE----" );
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[]lines =line.toLowerCase().split(" ");

                System.out.println(line);
                counter++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(Hero hero,int points) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("highscore.txt", true));
            writer.newLine();
            writer.write("# "+hero.getName()+" "+points);
            System.out.println("Your score is saved.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



