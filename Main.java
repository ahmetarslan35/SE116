import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        int choice;
        boolean flag = true, inGame = true;
        int x;


        while (flag) {
            System.out.println("-----HERO OF THE DUNGEON------");
            Hero hero = new Hero();
            System.out.println("Enter name :");
            String name = GameLogic.scanner.next();
            hero.setName(name);
            Highscores.createFile();
            Highscores.readHighscores();
            while (inGame) {
                GameLogic.printOptions(hero);
                String action = GameLogic.scanner.next();
                choice = GameLogic.getOption(" ", action, hero);
                String[] actions = action.toLowerCase().split(" ", 5);
                switch (choice) {
                    case 0: {
                        System.out.println("Invalid input!");

                    }
                    case 1: {
                        hero.move(actions[3]);

                    }
                    case 2: {


                    }
                    case 3: {
                        hero.moveUpperLevel();

                    }
                    case 4: {
                        hero.moveLowerLevel();

                    }
                    case 5: {


                    }
                    case 6: {


                    }
                }
                Highscores.writeFile(hero);
            }


        }


    }
}
