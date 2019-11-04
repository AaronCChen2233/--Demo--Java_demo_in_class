import javax.swing.*;
import java.awt.*;

public class ElasticCollisionTestWindow extends JFrame {
    private Timer timer;
    private JPanel mainPanel;
    private JPanel playPanel;

    public ElasticCollisionTestWindow() {
//        add(mainPanel);
        setTitle("Pong");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainPanel.setLayout(new GridLayout(305, 548));
        MyPanel my=new MyPanel();
        add(my);
        Thread t=new Thread(my);
        t.start();
    }

    public static void main(String[] args) {
        ElasticCollisionTestWindow pong = new ElasticCollisionTestWindow();
        pong.setVisible(true);
    }

    class MyPanel extends Panel implements Runnable {
        int x = 0, y = 0;
        int flyx = 1, flyy = 1;

        public void paint(Graphics g) {
            g.setColor(Color.black);
            g.fillOval(x, y, 70, 70);
            //  System.out.println("23");
            if (flyx == 1) {
                x++;
            }
            if (flyx == 2) {
                x--;
            }
            if (flyy == 1) {
                y++;
            }
            if (flyy == 2) {
                y--;
            }
            if (x > 730) {
                flyx = 2;
            }
            if (x < 0) {
                flyx = 1;
            }
            if (y < 0) {
                flyy = 1;
            }
            if (y > 530) {
                flyy = 2;
            }
        }

        public void run() {
            while (true) {
                repaint();
                try {

                    Thread.sleep(10);
                } catch (Exception e) {

                }
            }
        }


//    class ball{
//        int x;
//        int y;
//        int width;
//        int height;
//        public void imp(){
//            if(addX){
//                x+=3;
//            }else{
//                x-=3;
//            }
//
//            if(addY){
//                y+=6;
//            }else{
//                y-=6;
//            }
//            if(x<=0||x>=(width-50)){
//                addX=!addX;
//            }
//
//            if(y<=0||y>=(height-50)){
//                addY=!addY;
//            }
//
//        }
//    }
    }
}
