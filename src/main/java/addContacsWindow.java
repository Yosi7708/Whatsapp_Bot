import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class addContacsWindow extends JFrame {


    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;
    private Font myDefaultFont = new Font("David", Font.PLAIN ,20);
   protected static LinkedList<Contacts> contactsList = new LinkedList<Contacts>();


    public void addComponent(Component component, int x, int y, int width, int height, Font font) {
        //פקודת יישור מימין לשמאל,ויזואלית יפה יותר ל"הוסף מספר" אבל עובדת גם בתיבות טקסט...
        component.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        component.setBounds(x, y, width, height);
        component.setFont(font);
        MainPanel main = new MainPanel();
        this.add(main);
        this.add(component);
    }

    public void addNumber(JButton button,JTextField name, JTextField number) {
        button.addActionListener((event) -> {
            String userName= name.getText();
            String userNumber = number.getText();
            if (userName.length()<2) {
                JOptionPane.showMessageDialog(null, "Enter valid Name");
            }
            else if(userNumber.charAt(0)!=0 && userNumber.charAt(1)!=5 && userNumber.length()<10) {
                JOptionPane.showMessageDialog(null, "Enter valid Number");
            }
            else{
                this.contactsList.add(new Contacts(userName, userNumber));
            }
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


        JLabel name = new JLabel(" הכנס שם");
        addComponent(name, WIDTH / 2-75, 20, 150, 50,myDefaultFont);

        JTextField nameFiled = new JTextField();
        addComponent(nameFiled, name.getX(), name.getY() + name.getHeight(), name.getWidth(), name.getHeight()+20, myDefaultFont);
        nameFiled.setBackground(Color.LIGHT_GRAY);

        JLabel number = new JLabel(" הכנס  מספר");
        addComponent(number, nameFiled.getX(), nameFiled.getY() + nameFiled.getHeight(), nameFiled.getWidth(), name.getHeight(),myDefaultFont);

        JTextField numFiled = new JTextField();
        addComponent(numFiled, number.getX(), number.getY() + number.getHeight(), number.getWidth(), number.getHeight()+20, myDefaultFont);
        numFiled.setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);


        JButton saveButton = new JButton("שמור והוסף");
        addComponent(saveButton, numFiled.getX() , numFiled.getY()+numFiled.getHeight()+10,
                numFiled.getWidth(),
                numFiled.getHeight(), new Font("David", Font.ITALIC, 20));


        addNumber(saveButton ,nameFiled, numFiled);


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
