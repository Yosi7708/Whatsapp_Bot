public class Contacts {
    private String number;
    private String name;

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;

    }
    public Contacts(Contacts other) {
        this.number = other.number;
        this.name = other.name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: "+name+" Number: "+number;
    }
}
