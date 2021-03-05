package treasures;

public class Stone extends Treasure{
    public Stone(int id, String name, Material material, Size size) {
        super(id, name, material, size);
    }

    @Override
    public double getCost() {
        return super.getCost() * 150;
    }
}
