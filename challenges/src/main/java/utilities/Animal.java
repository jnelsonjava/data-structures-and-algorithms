package utilities;

public class Animal {
    String name = "";
    String type = "";

    public Animal(){}

    @Override
    public String toString() {
        return String.format("%s %s", name, type);
    }
}
