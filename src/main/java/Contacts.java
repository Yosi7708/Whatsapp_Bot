public class Contacts {
    private String number;
    private String name;
    private boolean isSent;

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
        this.isSent = false;

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
