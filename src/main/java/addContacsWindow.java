import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class addContacsWindow extends JFrame {


    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;
    private static LinkedList<Contacts> contactsList = new LinkedList<Contacts>();


    public void addComponent(Component component, int x, int y, int width, int height, Font font) {
        //פקודת יישור מימין לשמאל,ויזואלית יפה יותר ל"הוסף מספר" אבל עובדת גם בתיבות טקסט...
        component.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        component.setBounds(x, y, width, height);
        component.setFont(font);
        this.add(component);
    }

    public void addNumber(JButton button, JTextField name, JTextField number) {
        button.addActionListener((event) -> {
            String userName= name.getText();
            String userNum = number.getText();


            this.contactsList.add(new Contacts(userName, userNum));
            name.setText("");
            number.setText("");
            //הדפסת הרשימה העכשווית לקונסוך לצוקך בדיקה בלבד
            print();

        });



    }
    public void print(){
        System.out.println(contactsList.toString());
    }


    public addContacsWindow() {

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);


        JLabel msg = new JLabel(" הכנס מספר");
        addComponent(msg, WIDTH / 2-75, 20, 150, 100, new Font("David", Font.ITALIC, 20));

        JTextField nameFiled = new JTextField();
        addComponent(nameFiled, msg.getX(), msg.getY() + msg.getHeight(), msg.getWidth(), msg.getHeight(), new Font("David", Font.ITALIC, 20));
        nameFiled.setBackground(Color.LIGHT_GRAY);


        JTextField numFiled = new JTextField();
        addComponent(numFiled, nameFiled.getX(), nameFiled.getY() + nameFiled.getHeight()+10, nameFiled.getWidth(), nameFiled.getHeight(), new Font("David", Font.ITALIC, 20));
        numFiled.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);


        JButton saveButton = new JButton("שמור והוסף");
        addComponent(saveButton, numFiled.getX() , numFiled.getY()+numFiled.getHeight()+10,
                numFiled.getWidth(),
                numFiled.getHeight()/2, new Font("David", Font.ITALIC, 20));
        addNumber(saveButton, numFiled, nameFiled);


    }
    public static boolean checkIfContactsListEmpty(){
        return contactsList.isEmpty();
    }
    public static LinkedList<Contacts> getContactsList(){
        return contactsList;
    }

    public static void main(String[] args) throws Exception {
            new addContacsWindow();


    }

}
