import java.io.*;
import java.util.Scanner;

public class Highscores {
    public static void createFile() {

        File highscores = new File("D:\\githubprojects\\se116\\highscores\\highscores.txt");
        try {
            highscores.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();


        }


    }
/* Burda da skorlar büyükten küçüğe doğru ilk 5 sıralanacak*/
    public static void readHighscores() {
        File highscores = new File("D:\\githubprojects\\se116\\highscores\\highscores.txt");
        try {
            Scanner reader = new Scanner(highscores);
            System.out.println("Highscores: " );
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(Hero hero /* Itemlerin değerini eklemek lazım skor olarak ama parametre bulamadım*/) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\githubprojects\\se116\\highscores\\highscores.txt", true));
            writer.newLine();
            writer.write(hero.getName()+": ");
            System.out.println("Your score is saved.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



