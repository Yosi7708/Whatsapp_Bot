import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

     private static final int SCREEN_WIDTH = 600;//גודל הפאנל (וגודל החלון יחושב אוטומטית ע"י פונקציית pack )
     private static final int SCREEN_HEIGHT = 800;
     private static final int Elemnts_Width=200;
    ImageIcon logo = new ImageIcon("WhatsApp-Logo.jpg");
     private Font myDefaultFont = new Font("David", Font.PLAIN ,20);


    public void addComponent(Component component, int x, int y, int width, int height, Font font) {
        //פקודת יישור מימין לשמאל,ויזואלית יפה יותר ל"הוסף מספר" אבל עובדת גם בתיבות טקסט...
        component.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        component.setBounds(x, y, width, height);
        component.setFont(font);
        this.add(component);
    }
    MainPanel() {

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setBackground(new Color(255,253,208));
        this.setLayout(null);


        JTextField massageBox = new JTextField();
        massageBox.setBackground(Color.LIGHT_GRAY);
        addComponent(massageBox,(SCREEN_WIDTH-Elemnts_Width)/2,SCREEN_HEIGHT/2,Elemnts_Width,100,myDefaultFont);

        JButton sendButton = new JButton("שלח הודעה");
        addComponent(sendButton, massageBox.getX() , massageBox.getY()+massageBox.getHeight()+10,
                massageBox.getWidth(),
                massageBox.getHeight()/2, myDefaultFont);

        JButton addContactButton = new JButton("הוסף איש קשר");
        addComponent(addContactButton, SCREEN_WIDTH-160,0,150,150, myDefaultFont);

        this.revalidate();

        addContactButton.addActionListener((event) -> {
            new addContacsWindow();

        });
        JLabel report = new JLabel("Report");
        report.setSize(getWidth(),getHeight());
        report.setVisible(false);
        this.add(report);
        sendButton.addActionListener((event) -> {
            String msg= massageBox.getText();
            if(msg.equals(""))
                JOptionPane.showMessageDialog(null, "Enter your message");
            else {
                if (!addContacsWindow.checkIfContactsListEmpty()) {
                    try {
                        Main.sendMessage(addContacsWindow.getContactsList(), msg);
                        Thread.sleep(5000);
                        report.setText("<html>"+report.getText());
                        for (Contacts contacts:addContacsWindow.getContactsList()
                        ) {
                            report.setText(report.getText()+"<br>"+contacts.toString());

                        }
                        report.setText(report.getText()+"<html>");
                        report.setVisible(true);
                        addContactButton.setVisible(false);
                        massageBox.setVisible(false);
                        sendButton.setVisible(false);
                    } catch (Exception e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(),
                            "please enter contact",
                            "error",
                            JOptionPane.PLAIN_MESSAGE);
                }

            }

        });

        if(Main.isSent)
            reportScreen();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g) {
        g.drawImage(logo.getImage(),0,0,null);
      //  g.setColor(Color.GREEN);
      //  g.fillOval((SCREEN_WIDTH-Elemnts_Width)/2,0,Elemnts_Width,Elemnts_Width);
    }
    public void second(){
        JTextField massageBox = new JTextField();
        massageBox.setBackground(Color.LIGHT_GRAY);
        addComponent(massageBox,(SCREEN_WIDTH-Elemnts_Width)/2,SCREEN_HEIGHT/2,Elemnts_Width,100,myDefaultFont);

        JButton sendButton = new JButton("שלח הודעה");
        addComponent(sendButton, massageBox.getX() , massageBox.getY()+massageBox.getHeight()+10,
                massageBox.getWidth(),
                massageBox.getHeight()/2, myDefaultFont);

        JButton addContactButton = new JButton("הוסף איש קשר");
        addComponent(addContactButton, SCREEN_WIDTH-160,0,150,150, myDefaultFont);
    }
    public void reportScreen(){
        this.removeAll();
        this.add(new JLabel("Done"));
        this.revalidate();
    }










}
