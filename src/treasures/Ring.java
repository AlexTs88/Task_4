package treasures;

public class Ring extends Treasure{
    public Ring(int id, String name, Material material, Size size) {
        super(id, name, material, size);
    }

    @Override
    public double getCost() {
        return super.getCost() * 100;
    }
}
