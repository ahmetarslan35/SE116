import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class FileCreator {
    private static Formatter output ;

    public static void closeFile() {
        if(output!= null)
            output.close();

    }

    public static void addRecords(Hero hero ,int points) {





        try {
            output.format("%s %s %d","#",hero.getName(),points);

        }
        catch (FormatterClosedException formatterClosedException){
            System.err.println("Error writing to file");
        }




    }

    public static void openFile() {
        try {
            output = new Formatter("highscore.txt");
        }catch (SecurityException securityException){
            System.err.println("Write permission denied ");
            System.exit(1);
        }catch (FileNotFoundException fileNotFoundException){
            System.err.println("Error opening file");
            System.exit(1);
        }



    }


}
