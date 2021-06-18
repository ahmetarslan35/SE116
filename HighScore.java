import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;


public class HighScore {
    public static Formatter output ;

    public static void openFile() {

        try {
            output = new Formatter("highscore.txt");

        }catch (SecurityException securityException){
            System.out.println("Write permission denied");
            System.exit(1);

        }catch (FileNotFoundException fileNotFoundException){
            System.out.println("Error opening file ");
            System.exit(1);
        }



    }
    public static void addRecords(Hero hero ,int points) {
        try {
            output.format("%s: %d",hero.getName(),points);
        }catch (FormatterClosedException formatterClosedException){
            System.out.println("Error writing to file.");

        }




    }
    public static void closeFile() {
        if(output!=null)
            output.close();
    }





}
