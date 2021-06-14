import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Random rand =new Random();

    public static ArrayList<ArrayList> items = new ArrayList<>();
    public static ArrayList<Weapons> allWeapons =new ArrayList<>();
    public static ArrayList<Clothings> allClothings =new ArrayList<>();




    public static Items getItem(int Category,int index){

        return (Items) items.get(Category).get(index);

    }


    public static Items getWeapon(String itemName){
        Items tempItem = null;
        for (int i = 0; i <items.get(0).size() ; i++) {
            tempItem=(Items) items.get(0).get(i) ;
            if(tempItem.getName().toLowerCase().equals(itemName)){
                return tempItem;
            }
        }

        return tempItem;

    }
    public static Items getClothing(String itemName){
        Items tempItem = null;
        for (int i = 0; i <items.get(1).size() ; i++) {
            tempItem=(Items) items.get(1).get(i) ;
            if(tempItem.getName().equals(itemName)){
                return tempItem;
            }
        }

        return tempItem;

    }


    public static void printOptions(Hero hero){
        System.out.println("----------------");
        System.out.println("Hero :"+hero.getName());
        System.out.println("Current Level:"+hero.getCurrentLevel().getName());
        System.out.println("Current Room:"+hero.getCurrentRoom().getName());
        System.out.println("----------------");
        System.out.println("OPTIONS:");
        System.out.println("Open Inventory (open)");
        for (int i = 0; i < hero.getCurrentRoom().arrayList.size(); i++) {
            System.out.println(hero.getCurrentRoom().arrayList.get(i).getName()+"(move r"+hero.getCurrentRoom().arrayList.get(i).getId()+")");
        }
        if(hero.getCurrentRoom().hasAMonster()){
            System.out.println("Attack Monster");
        }

        if(hero.getCurrentRoom().hasAUpstairs()){
            System.out.println("Upper Level(move up)");
        }
        if(hero.getCurrentRoom().hasADownStairs()){
            System.out.println("Lower Level(move down)");
        }
        if(hero.getCurrentRoom().hasATownsPeople()){
            System.out.println("Rescue Townspeople(rescue)");
        }
        System.out.println("Exit(exit)");

        System.out.println("----------------");
    }
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
