package treasures;

public abstract class Treasure implements Valuable{
    int id;
    String name;
    Material material;
    Size size;

    public Treasure(int id, String name, Material material, Size size) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.size = size;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public double getCost() {
        return (getMaterial().ordinal() + 1) * (getSize().ordinal() + 1);
    }

    @Override
    public String toString() {
        return  id + ". " + name +
                ", material=" + material +
                ", size=" + size +
                ", cost=" + getCost();
    }
}