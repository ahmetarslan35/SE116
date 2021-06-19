import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Random rand =new Random();

    public static ArrayList<ArrayList> items = new ArrayList<>();
    public static ArrayList<Weapons> allWeapons =new ArrayList<>();
    public static ArrayList<Clothings> allClothings =new ArrayList<>();
    public static ArrayList<ValuableItems> valuableItems = new ArrayList<>();




    public static Items getItem(int Category,int index){

        return (Items) items.get(Category).get(index);

    }

    public static void printOptions(Hero hero){
        System.out.println();

        System.out.println("Current Room:"+hero.getCurrentRoom().getName());
        System.out.println("----------------");
        System.out.println("OPTIONS:");
        System.out.println("Character Info(info)");
        System.out.println("Open Inventory (open)");
        for (int i = 0; i < hero.getCurrentRoom().arrayList.size(); i++) {
            System.out.println(hero.getCurrentRoom().arrayList.get(i).getName()+"(move r"+hero.getCurrentRoom().arrayList.get(i).getId()+")");
        }
        if(hero.getCurrentRoom().hasAMonster()){
            for (int i = 0; i <hero.getCurrentRoom().getMonsterArrayList().size() ; i++) {
                System.out.println("Monster"+hero.getCurrentRoom().getMonsterArrayList().get(i).getId()+"(attack m"+hero.getCurrentRoom().getMonsterArrayList().get(i).getId()+")");

            }

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

    public static void printInfo(Hero hero ,int points){
        Weapons weapon =(Weapons)hero.getEquipment().get(0).get(0) ;
        Clothings heroClothing = (Clothings) hero.getEquipment().get(1).get(0);
        int x = calculatePoint(hero)+points ;
        System.out.println("TOTAL SCORE :"+x);

        System.out.println("Hero Name:"+hero.getName());
        System.out.println("Current Level:"+hero.getCurrentLevel().getName());
        System.out.println("Health Point:"+hero.getHealthPoint());

        System.out.println("Total Attack Point:"+(hero.getAttackPoint()+ weapon.getDamage()));
        System.out.println();
        System.out.println("Current Weapon:"+weapon.getName()+" |DAMAGE:"+weapon.getDamage()+"|VALUE:"+weapon.getValue()+"|RANGE:"+weapon.getRange()+"|");
        System.out.println("Current Clothing:"+heroClothing.getName()+" |PROTECTION RATE:"+heroClothing.getProtectionRate()+"|VALUE:"+heroClothing.getValue()+"|");


    }

    public static int calculatePoint(Hero hero){
        int counter =0 ;
        for (int i = 0; i < hero.getInventory().get(0).size(); i++) {
            counter +=hero.getInventory().get(0).get(i).getValue();

        }
        for (int i = 0; i < hero.getInventory().get(1).size(); i++) {
            counter +=hero.getInventory().get(1).get(i).getValue();

        }
        for (int i = 0; i < hero.getInventory().get(2).size(); i++) {
            counter +=hero.getInventory().get(2).get(i).getValue();

        }
        counter+=hero.getEquipment().get(0).get(0).getValue();
        counter+=hero.getEquipment().get(1).get(0).getValue();
        return counter ;

    }

    public static int levelID(Hero hero){
        int i ;
        do{
            try {
                i= Integer.parseInt(hero.getCurrentLevel().getName().substring(6));
            }catch (Exception e){
                System.out.println("Invalid");
                i =0;
            }
        }while (i<1);



        return i ;
    }


}
