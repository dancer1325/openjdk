package javap;

import java.awt.*;

import javax.swing.*;

public class Main extends JFrame {
    String message = "Hello World!";
    public Main() {
        setContentPane(new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawString(message, 15, 30);
            }
        });
        setSize(100, 100);
    }
    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}
