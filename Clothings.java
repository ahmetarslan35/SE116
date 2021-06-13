public class Clothings extends Items {
    public Clothings(String name, int value, int weight, int protectionRate) {
        super(name, value, weight);
        this.protectionRate = protectionRate;
    }

    private int protectionRate;


    public void showInfo() {
        super.showInfo();
        System.out.println("This clothing not only looks good but also protects you from enemy attacks. It gives: " + protectionRate + " armor.");
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
