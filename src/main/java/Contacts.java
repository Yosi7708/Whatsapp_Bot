public class Contacts {
    private String number;
    private String name;

    public Contacts(String number, String name) {
        this.number = number;
        this.name = name;
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
