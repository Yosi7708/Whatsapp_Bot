import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class GUI extends JFrame {


    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;
    private LinkedList<Contacts> contactsList = new LinkedList<Contacts>();


    public void addComponent(Component component, int x, int y, int width, int height, Font font) {
        component.setBounds(x, y, width, height);
        component.setFont(font);
        this.add(component);
    }

    public void addNumber(JButton button, JTextField name, JTextField number) {

        button.addActionListener((event) -> {
            String userName = name.getText();
            String userNum = number.getText();
            this.contactsList.add(new Contacts(userNum, userName));

        });

    }


    public GUI() {

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        JLabel msg = new JLabel("הכנס מספר");
        addComponent(msg, WIDTH / 2, 20, 150, 150, new Font("David", Font.ITALIC, 20));

        JTextField numFiled = new JTextField();
        addComponent(numFiled, msg.getX(), msg.getY() + msg.getHeight(), msg.getWidth(), msg.getHeight(), new Font("David", Font.ITALIC, 20));
        numFiled.setBackground(Color.LIGHT_GRAY);


        JTextField nameFiled = new JTextField();
        addComponent(numFiled, numFiled.getX(), numFiled.getY() + numFiled.getHeight(), numFiled.getWidth(), numFiled.getHeight(), new Font("David", Font.ITALIC, 20));
        numFiled.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);


        JButton saveButton = new JButton("שמור והוסף");
        addComponent(saveButton, numFiled.getX() + 20,
                numFiled.getY() + numFiled.getHeight() + 20,
                numFiled.getWidth(),
                numFiled.getHeight(), new Font("David", Font.ITALIC, 20));
        addNumber(saveButton, numFiled, nameFiled);


    }

    public static void main(String[] args) {
        new GUI();
    }

}
