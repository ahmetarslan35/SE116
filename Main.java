public class Main {
    public static void main(String[] args) {
        int pointCalculator = 0 ;

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
        ValuableItems goldenRing = new ValuableItems("Golden Ring",400,2);
        ValuableItems diamond = new ValuableItems("Diamond",1000,3);
        ValuableItems ancientBracelet = new ValuableItems("Ancient Bracelet",2000,10);
        ValuableItems bronzeNecklace = new ValuableItems("Bronze Necklace",200,1);
        ValuableItems pearl = new ValuableItems("Pearl",1500,1);




        GameLogic.items.add(GameLogic.allWeapons);
        GameLogic.items.add(GameLogic.allClothings);
        GameLogic.items.add(GameLogic.valuableItems);
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
        GameLogic.valuableItems.add(goldenRing);
        GameLogic.valuableItems.add(diamond);
        GameLogic.valuableItems.add(ancientBracelet);
        GameLogic.valuableItems.add(bronzeNecklace);
        GameLogic.valuableItems.add(pearl);


        boolean inGame ;
        int choice ;

        while (true){
            inGame =true;
            System.out.println("-----HERO OF THE DUNGEON------");
            Hero hero = new Hero();

            System.out.println("Enter name :");

            String name = GameLogic.scanner.nextLine();
            if(name.equals(""))
                name = GameLogic.scanner.nextLine();
            hero.setName(name);
            System.out.println();
            int baseHealth =hero.getHealthPoint();

            while(inGame){

                GameLogic.printOptions(hero);
                String action =GameLogic.scanner.nextLine();
                if(action.equals("")){
                    action= GameLogic.scanner.nextLine();
                }
                String[]actions = action.toLowerCase().split(" ",5) ;


                if(actions[0].equals("open")) {
                    boolean exit = true;
                    while (exit){
                        choice = GameLogic.getOption("""
                                        [1]Equipments on Hero
                                        [2]Weapon Inventory
                                        [3]Clothing Inventory
                                        [4]Valuable Items Inventory
                                        [5]Exit""", 5);
                        if (choice == 1) {
                            hero.getEquipment().get(0).showEquipments(hero.getEquipment().get(0));
                            hero.getEquipment().get(0).showEquipments(hero.getEquipment().get(1));
                        }
                        else if (choice == 2) {
                                    boolean flag1 = true;
                                    while (flag1) {
                                        int option = GameLogic.getOption("""
                                                [1]Show weapon inventory
                                                [2]Swap weapon with current weapon
                                                [3]Drop weapon
                                                [4]Return""", 4);
                                        if (option == 1) {
                                            hero.getInventory().get(0).showInventory(hero.getInventory().get(0));
                                        } else if (option == 2) {
                                            hero.getInventory().get(0).indexOfItems(hero.getInventory().get(0));
                                            if (hero.getInventory().get(0).size() > 0) {
                                                int x = GameLogic.getOption("Pick a weapon for swap with current weapon", hero.getInventory().get(0).size());
                                                hero.getInventory().get(0).swapWeapons(hero.getInventory().get(0), hero.getEquipment().get(0), (Weapons) hero.getInventory().get(0).get(x - 1), (Weapons) hero.getEquipment().get(0).get(0));

                                            } else System.out.println("There is no item in the inventory");


                                        } else if (option == 3) {
                                            hero.getInventory().get(0).indexOfItems(hero.getInventory().get(0));
                                            if (hero.getInventory().get(0).size() > 0) {
                                                int x = GameLogic.getOption("Pick a weapon to drop", hero.getInventory().get(0).size());
                                                System.out.println(hero.getInventory().get(0).get(x - 1).getName() + " removed from inventory");
                                                hero.getInventory().get(0).remove(x - 1);


                                            }


                                        } else if (option == 4) {
                                            flag1 = false;

                                        }
                                    }


                                }
                        else if (choice == 3) {
                                    boolean flag1 = true;
                                    while (flag1) {
                                        int option = GameLogic.getOption("""
                                                [1]Show clothing inventory
                                                [2]Swap clothing with current clothing
                                                [3]Drop clothing
                                                [4]Return""", 4);
                                        if (option == 1) {
                                            hero.getInventory().get(1).showInventory(hero.getInventory().get(1));
                                        } else if (option == 2) {
                                            hero.getInventory().get(1).indexOfItems(hero.getInventory().get(1));
                                            if (hero.getInventory().get(1).size() > 0) {
                                                int x = GameLogic.getOption("Pick a weapon for swap with current weapon", hero.getInventory().get(1).size());
                                                hero.getInventory().get(1).swapClothings(hero.getInventory().get(1), hero.getEquipment().get(1), (Clothings) hero.getInventory().get(1).get(x - 1), (Clothings) hero.getEquipment().get(1).get(0));

                                            } else System.out.println("There is no item in the inventory");


                                        } else if (option == 3) {
                                            hero.getInventory().get(1).indexOfItems(hero.getInventory().get(1));
                                            if (hero.getInventory().get(1).size() > 0) {
                                                int x = GameLogic.getOption("Pick a clothing to drop", hero.getInventory().get(1).size());
                                                System.out.println(hero.getInventory().get(1).get(x - 1).getName() + " removed from inventory");
                                                hero.getInventory().get(1).remove(x - 1);


                                            } else System.out.println("There is no item to drop");


                                        } else if (option == 4) {
                                            flag1 = false;

                                        }
                                    }


                                }
                        else if (choice == 4) {
                            boolean flag1 = true;
                            while (flag1) {
                                int option = GameLogic.getOption("""
                                                [1]List items
                                                [2]Return""", 2);
                                if (option == 1) {
                                    hero.getInventory().get(2).showInventory(hero.getInventory().get(2));
                                }
                                else if (option == 2) {
                                    flag1 = false;

                                }
                            }


                        }
                        else if (choice == 5)
                            exit = false;




                    } // inventory loop
                }
                else if(actions[0].equals("exit"))
                    System.exit(0);
                else if(actions[0].equals("info"))
                    GameLogic.printInfo(hero,pointCalculator);
                else if(actions[0].equals("rescue") ){
                    if(!hero.getCurrentRoom().hasAMonster()){
                        System.out.println("He is very pleasant for being rescued");
                        int x = GameLogic.rand.nextInt(101);
                        if(x<71){
                            ValuableItems valuableItems =(ValuableItems) GameLogic.items.get(2).get(GameLogic.rand.nextInt(GameLogic.items.get(2).size()));
                            System.out.println("He is dying because of his wounds and he wants to give you "+valuableItems.getName());
                            System.out.println("This precious item seems very valuable");
                            int anInt = GameLogic.getOption("[1]Take [2]Move on",2);
                            if(anInt==1){
                                hero.getInventory().get(2).add(valuableItems);
                            }

                        }
                        if(x>70 && x<81){
                            Weapons weapons =(Weapons) GameLogic.items.get(0).get(GameLogic.rand.nextInt(GameLogic.items.get(0).size()));
                            System.out.println("He felt very indebted and he wants to give you "+weapons.getName());
                            System.out.println("This weapon was his father's and he says it may help you through your journey");
                            int anInt = GameLogic.getOption("[1]Take [2]Move on",2);
                            if(anInt==1){
                                hero.getInventory().get(0).add(weapons);
                            }





                        }
                        if(x>80 && x<91){
                            Clothings clothings =(Clothings) GameLogic.items.get(1).get(GameLogic.rand.nextInt(GameLogic.items.get(1).size()));
                            System.out.println("He felt very indebted and he wants to give you "+clothings.getName());
                            System.out.println("This item may protect you from some of the possible dangers");
                            int anInt = GameLogic.getOption("[1]Take [2]Move on",2);
                            if(anInt==1){
                                hero.getInventory().get(1).add(clothings);
                            }


                        }
                        System.out.println("...and he gives you a bandage to heal yourself");
                        hero.setHealthPoint(baseHealth);
                        System.out.println("+400 points for rescuing folks");
                        hero.getCurrentRoom().setHasATownsPeople(false);




                    }
                    else System.out.println("You cannot rescue townspeople until the room was cleaned");

                }

                else if(actions.length>1){
                    if(hero.getCurrentRoom().hasAUpstairs() && actions[1].equals("up") && actions[1].length()>1){
                        int anInt = GameLogic.levelID(hero);
                        if(anInt ==16){
                            System.out.println("YOU WON!!!");
                            System.out.println();
                            pointCalculator+=GameLogic.calculatePoint(hero);
                            System.out.println("PLAYER:"+hero.getName());
                            System.out.println("TOTAL SCORE :"+pointCalculator);
                            int decision = GameLogic.getOption("[1]Restart [2]Quit",2);
                            if(decision==1){
                                break;
                            }
                            if(decision==2)
                                System.exit(1);

                        }
                        else hero.moveUpperLevel();
                    }


                    else if(hero.getCurrentRoom().hasADownStairs()&& actions[1].equals("down") && actions[1].length()>1)
                        hero.moveLowerLevel();

                    else if(actions[0].equals("move") && actions[1].contains("r") && actions[1].length()>1){
                        hero.move(actions[1]);
                    }
                    else if(actions[0].equals("attack") && actions[1].contains("m") && hero.chooseMonster(actions[1])!= null){
                        Monster monster =hero.chooseMonster(actions[1]);
                        int monsterHp = monster.getHealthPoint();

                        int heroHealthPoint = hero.getHealthPoint();
                        Weapons heroWeapon = (Weapons) hero.getEquipment().get(0).get(0);
                        Clothings heroClothing = (Clothings) hero.getEquipment().get(1).get(0);

                        int heroAttackPoint =hero.getAttackPoint()+heroWeapon.getDamage();
                        boolean returnRoom =false;


                        while (monsterHp>0){
                            System.out.println("Your HP :"+heroHealthPoint);
                            System.out.println("Monsters HP:"+monsterHp);

                            int x=GameLogic.getOption("[1]Attack\n" +
                                    "[2]Return Room",2);
                            if(x==1){
                                heroHealthPoint=heroHealthPoint-(monster.getAttackPoint()-heroClothing.getProtectionRate());
                                monsterHp-=heroAttackPoint;
                                hero.setHealthPoint(heroHealthPoint);
                                monster.setHealthPoint(monsterHp);
                                System.out.println(monster.getAttackPoint()-heroClothing.getProtectionRate()+" damage received and you deal "+heroAttackPoint);


                            }
                            else if(x==2){
                                returnRoom = true;
                                break;
                            }
                            if(hero.getHealthPoint()<1){
                                System.out.println("GAME OVER!!!!");
                                System.out.println();
                                pointCalculator+=GameLogic.calculatePoint(hero);
                                System.out.println("PLAYER:"+hero.getName());
                                System.out.println("TOTAL SCORE :"+pointCalculator);
                                int option = GameLogic.getOption("[1]Restart [2]Exit",2);
                                if(option==1){
                                    inGame =false;
                                    break;

                                }
                                if(option==2)
                                    System.exit(0);
                            }







                        }
                        if(heroHealthPoint>0 && !returnRoom){
                            System.out.println("You killed Monster"+monster.getId());
                            hero.getCurrentRoom().getMonsterArrayList().remove(monster);
                            if(hero.getCurrentRoom().getMonsterArrayList().size()==0){
                                hero.getCurrentRoom().setHasAMonster(false);
                                System.out.println("+100 points for cleaning room");
                                pointCalculator+=100;

                            }
                            int x = GameLogic.rand.nextInt(101);
                            if(x<51){
                                int possibility =GameLogic.rand.nextInt(GameLogic.items.get(2).size());
                                ValuableItems valuableItems =(ValuableItems) GameLogic.items.get(2).get(possibility);
                                System.out.println("Monster dropped "+valuableItems.getName());
                                int anInt = GameLogic.getOption("[1]Take [2]Move on",2);
                                if(anInt==1){
                                    hero.getInventory().get(2).add(valuableItems);
                                }


                            }
                            if(x<61&& x>50){
                                int possibility= GameLogic.rand.nextInt(GameLogic.items.get(0).size());

                                Weapons weapons =(Weapons) GameLogic.items.get(0).get(possibility);
                                System.out.println("Monster dropped "+weapons.getName());
                                int anInt = GameLogic.getOption("[1]Take [2]Move on",2);
                                if(anInt==1){
                                    hero.getInventory().get(0).add(weapons);
                                }

                            }
                            if(x>60 &&x<71){
                                int possibility= GameLogic.rand.nextInt(GameLogic.items.get(1).size());

                                Clothings clothings =(Clothings) GameLogic.items.get(1).get(possibility);
                                System.out.println("Monster dropped "+clothings.getName());
                                int anInt = GameLogic.getOption("[1]Take [2]Move on",2);
                                if(anInt==1){
                                    hero.getInventory().get(1).add(clothings);
                                }

                            }


                        }



                    }

                }

                }







            }


        }





 }

