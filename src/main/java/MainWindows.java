import javax.swing.*;

public class MainWindows extends JFrame {
    MainWindows() {
        // הגדרת חלון בסיסית
        this.add(new InitialPanel());
        this.setTitle("WhatsappBot");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //פונקצייה מובנית הבונה את גודל החלון בהתאם לגודל הפנלים
        this.pack();
        //נראות ומיקום החלון
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
