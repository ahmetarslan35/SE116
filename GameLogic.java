import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    public static int getOption(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);

            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Invalid Value");


            }


        }
        while (input < 1 || input > userChoices);


        return input;
    }


}
