import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.Timer;

public class InitialPanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;//גודל הפאנל (וגודל החלון יחושב אוטומטית ע"י פונקציית pack )
    private  static final int SCREEN_HEIGHT = 800;
    private static boolean running= false;
    ImageIcon logo = new ImageIcon("WhatsApp-Logo.jpg");

    InitialPanel() {
        JLabel connected=new JLabel("YOURE SUCCSSEFULY CONNECTED!");
        JPanel jPanel= new JPanel();
        this.add(jPanel);
        jPanel.setLayout(null);
        jPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        jPanel.setBackground(new Color(245,245,220));
        JButton connect= new JButton("connect");
        jPanel.add(connect).setBounds(SCREEN_WIDTH/2-100,SCREEN_HEIGHT/2-50,200,100);
        connect.setVisible(true);
        this.setFocusable(true);

        try{
            Thread.sleep(2000);
        }catch(Exception e){

        }
        connect.addActionListener((event) -> {
            try{
                Main.openBrowser();
                jPanel.add(connected).setBounds(connect.getX(),connect.getY()+connect.getHeight(),connect.getWidth(),connect.getHeight());
                jPanel.revalidate();
                Thread.sleep(5000);


            }catch (Exception e){

            }
            Main.checkIfConnected();
            if (Main.isConnected) {
                try {
                    secondPanel();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
    public void successPanel() throws InterruptedException {
        this.setLayout(new java.awt.BorderLayout());
        this.removeAll();

        JLabel jLabel=new JLabel("succcessful");
        this.add(jLabel);
        jLabel.setVisible(true);
        jLabel.setBounds(600,400,100,100);
        this.revalidate();

        secondPanel();

    }
    public void secondPanel() throws InterruptedException {
        JOptionPane.showMessageDialog(null,"successful");
        this.removeAll();
        this.add(new MainPanel());
        this.revalidate();

    }

    public void returnTrue(){
        Scanner s= new Scanner(System.in);
        if(s.nextInt()==1)
            running=true;
        repaint();
    }
    public void mainWindow(Graphics g){

        repaint();
    }
    //אתחול המשתנים בתחילת המשחק ובמקרה של פסילה
    public void ResetGame() {
        repaint();
    }
    // מסך פתיחה

    public void Welcome(Graphics g) {
        g.setColor(Color.blue);
        JLabel hiMessage = new JLabel("hi");
        this.add(hiMessage);
    }

    // פונקציות הציור למסך

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }
    public void secondWindow(Graphics g){
        this.setBackground(Color.MAGENTA);
        g.setColor(Color.GREEN);
    }

    public void draw(Graphics g) {
        g.drawImage(logo.getImage(),0,0,null);
        if (running) {
            //מסך פתיחה
            Welcome(g);
            this.setBackground(Color.orange);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {


        }
    }
}









