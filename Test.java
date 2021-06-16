public class Test {
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

        Hero hero = new Hero() ;
         hero.getEquipment().get(0).get(0).showInfo();


    }
}
