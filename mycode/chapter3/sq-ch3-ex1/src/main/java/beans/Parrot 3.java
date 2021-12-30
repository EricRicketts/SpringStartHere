package beans;

public class Parrot {
    private String name;

    public Parrot() { this.name = "Polly"; }
    public Parrot(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return "Parrot : " + name; }
}
