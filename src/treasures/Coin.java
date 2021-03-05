package treasures;

public class Coin extends Treasure{
    public Coin(int id, String name, Material material, Size size) {
        super(id, name, material, size);
    }

    @Override
    public double getCost() {
        return super.getCost() * 50;
    }
}
