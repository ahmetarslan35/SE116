

public class Main {
    public static void main(String[] args) {
        Weapons dagger = new Weapons("Dagger", 4, 4, 7, 2);
        Weapons smallAxe = new Weapons("Small Axe", 5, 7, 9, 3);
        Weapons axe = new Weapons("Axe", 7, 10, 13, 4);
        Weapons broadAxe = new Weapons("BroadAxe", 10, 15, 15, 5);

        Weapons shortSword = new Weapons("Short Sword", 8, 8, 12, 4);
        Weapons longSword = new Weapons("Long Sword", 12, 12, 15, 6);
        Weapons shortBow = new Weapons("Short Bow", 6, 4, 6, 8);
        Weapons longBow = new Weapons("Long Bow", 9, 6, 9, 10);
        Weapons compositeBow = new Weapons("Composite Bow", 11, 9, 12, 12);

        Clothings lightClothing = new Clothings("Light Clothing", 6, 5, 10);
        Clothings leatherArmor = new Clothings("Leather Armor", 7, 7, 15);
        Clothings chainmailArmor = new Clothings("Chainmail Armor", 10, 9, 20);

        GameLogic.items.add(GameLogic.allWeapons);
        GameLogic.items.add(GameLogic.allClothings);
        GameLogic.allWeapons.add(dagger);
        GameLogic.allWeapons.add(smallAxe);
        GameLogic.allWeapons.add(axe);
        GameLogic.allWeapons.add(broadAxe);
        GameLogic.allWeapons.add(shortSword);
        GameLogic.allWeapons.add(longSword);
        GameLogic.allWeapons.add(shortBow);
        GameLogic.allWeapons.add(longBow);
        GameLogic.allWeapons.add(compositeBow);
        GameLogic.allClothings.add(lightClothing);
        GameLogic.allClothings.add(leatherArmor);
        GameLogic.allClothings.add(chainmailArmor);

        boolean inGame = true ,startGame = true ;
        int choice ;

        while (startGame){
            System.out.println("-----HERO OF THE DUNGEON------");
            Hero hero = new Hero();
            System.out.println("Enter name :");
            String name = GameLogic.scanner.nextLine();
            hero.setName(name);
            System.out.println();
            while(inGame){
                GameLogic.printOptions(hero);
                String action =GameLogic.scanner.nextLine();
                String[]actions = action.toLowerCase().split(" ",5) ;
                if(actions[0].equals("open")){
                    boolean exit = true;

                    while(exit){
                         choice = GameLogic.getOption("[1]Equitments on Hero\n" +
                                 "[2]Weapon Inventory\n" +
                                 "[3]Clothing Inventory\n" +
                                 "[4]Exit",4);
                         if(choice==1){
                             boolean flag= true;
                             while (flag){
                                 int option = GameLogic.getOption("[1]Equipment Info\n" +
                                         "[2]Return",2);
                                 if(option==1){
                                     hero.getEquipment().get(0).showEquipments(hero.getEquipment().get(0));
                                     hero.getEquipment().get(0).showEquipments(hero.getEquipment().get(1));

                                 }
                                 else if(option==2){
                                     flag =false;
                                 }
                             }
                         }
                         else if(choice==2){
                             boolean flag1=true ;
                             while(flag1){
                                 int option =GameLogic.getOption("[1]Show weapon inventory\n" +
                                         "[2]Swap weapon with current weapon\n" +
                                         "[3]Drop weapon\n" +
                                         "[4]Return",4);
                                 if(option==1){
                                     hero.getInventory().get(0).showInventory(hero.getInventory().get(0));

                                 }
                                 else if(option==2){
                                     System.out.println("Enter name of the weapon that in the inventory:");
                                     String weaponName =GameLogic.scanner.nextLine();
                                     Weapons weapons =(Weapons)GameLogic.getItem(0,weaponName);
                                     hero.getInventory().get(0).swapWeapons(hero.getInventory().get(0),hero.getEquipment().get(0), (Weapons) hero.getEquipment().get(0).get(0),weapons);

                                 }// swap sıkıntılı
                                 else if(option==3){

                                 }
                                 else if(option==4){
                                     flag1=false;

                                 }
                             }


                         }
                         else if(choice==4){
                             exit =false;

                         }



                     } // inventory loop
                }
                else if(actions[0].equals("move") && actions[1].contains("r")){
                    hero.move(actions[1]);
                }
                else if(actions[0].equals("attack")){
                    hero.getHealthPoint();

                }// add monsters
                else if(actions.length>1){
                    if (actions[1].equals("up"))
                        hero.moveUpperLevel();
                }
                else if(actions.length>1){
                    if(actions[1].equals("down"))
                        hero.moveLowerLevel();
                }
                else if(actions[0].equals("rescue")){

                }
                else if(actions[0].equals("exit")){
                    inGame =false ;
                    startGame= false ;
                    break ;

                }






            }


        }















    }
}
