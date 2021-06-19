import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileReader {
    private static Scanner input ;


    public static void closeFile() {
        if(input!=null)
            input.close();
    }

    public static void readRecords() {
        System.out.printf("%-10s%-12s%-12s%n","#","PLAYER","SCORE");
        try {
            System.out.printf("%-10s%-12s%-12d%n",input.next(),input.next(),input.nextInt());

        }catch (NoSuchElementException noSuchElementException){
            System.err.println("File improperly formed");

        }catch (IllegalStateException illegalStateException){
            System.err.println("Error reading from file");

        }

    }

    public static void openFile(){
        try {
            input= new Scanner(Paths.get("highscore.txt"));

        }catch (IOException ioException){
            System.err.println("Error opening file");


        }

    }
}
