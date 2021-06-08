
public class Items {
    private String name;
    private int value;
    private int weight;


    public Items(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;


    }

    public void showInfo() {
        System.out.println("The name of this item is: " + name);
        if (value >= 10) {
            System.out.println("This one seems like a lot of money. It costs: " + value + " coins.");
        } else {
            System.out.println("This one seems a little cheap. It costs: " + value + " coins.");
        }
        if (weight >= 10) {
            System.out.println("This one looks a bit heavy.You must be strong to carry this. It weighs: " + weight);
        } else {
            System.out.println("Seems easy to carry. It weighs: " + weight);
        }

    }

    //overriding the toString method to get the contents of the Items object instead of the memory locations
    public String toString() {
        return "[" + name + "]";
    }

}

