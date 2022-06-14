import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class initialPanel extends JPanel implements ActionListener {


    static final int SCREEN_WIDTH = 350;//גודל הפאנל (וגודל החלון יחושב אוטומטית ע"י פונקציית pack )
    static final int SCREEN_HEIGHT = 750;
    static boolean running= false;



    initialPanel() {
        JPanel jPanel= new JPanel();
        this.add(jPanel);
        jPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        jPanel.setBackground(new Color(245,245,220));
        JButton connect= new JButton("conect");
        jPanel.add(connect);
        connect.setBounds(jPanel.getX()/2,jPanel.getHeight()/2,150,100);
        connect.setVisible(true);
        this.setFocusable(true);

        try{
            Thread.sleep(5000);
        }catch(Exception e){

        }




        connect.addActionListener((event) -> {
            try {

//                Main.openBrowser();
                // לחלק את הפונקציה של שליחת הודעה ל2 אחד לפתיחת דפדפן ואחד לשליחת ההודעות
            }catch (Exception e){

            }




        });




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
    public void secondwindow(Graphics g){
        this.setBackground(Color.MAGENTA);
        g.setColor(Color.GREEN);
    }

    public void draw(Graphics g) {

        if (running) {
            //מסך פתיחה
            Welcome(g);
            this.setBackground(Color.orange);


        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            repaint();

        }
    }
}









