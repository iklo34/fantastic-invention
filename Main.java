package Anim;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main m = new Main();
        });

    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            init();
        }
    };
    ActionListener actionListener2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            init2();
        }
    };
    ActionListener actionListener3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frog.pause();
        }
    };
    ActionListener actionListener4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frog.resume();
        }
    };

    public BufferedImage sprite;
    Anim frog ;

    public Main() {
        JPanel panel = new JPanel();
        panel.setSize(800, 700);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        add(panel);

        Button a1 = new Button("Animation 1");
        a1.addActionListener(actionListener);
        a1.setBounds(350,500,70,40);
        a1.setVisible(true);
        panel.add(a1);

        Button a2 = new Button("Animation 2");
        a2.addActionListener(actionListener2);
        a2.setBounds(350,540,70,40);
        a2.setVisible(true);
        panel.add(a2);

        Button pause = new Button("Pause");
        pause.addActionListener(actionListener3);
        pause.setBounds(420,500,70,40);
        pause.setVisible(true);
        panel.add(pause);

        Button resume = new Button("Resume");
        resume.addActionListener(actionListener4);
        resume.setBounds(420,540,70,40);
        resume.setVisible(true);
        panel.add(resume);


        panel.setVisible(true);
        setVisible(true);
    }

    private void init() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            BufferedImage image = loader.loadImage("src/Anim/R.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sprite = loader.loadImage("src/Anim/R.png");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpriteSheet ss = new SpriteSheet("src/Anim/R.png");
        ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
        sprites.add(ss.getSprite(428, 94, 40, 70));
        sprites.add(ss.getSprite(464, 94, 40, 70));
        sprites.add(ss.getSprite(508, 94, 40, 70));
        sprites.add(ss.getSprite(561, 94, 40, 70));
        sprites.add(ss.getSprite(608, 94, 40, 70));
        sprites.add(ss.getSprite(661, 94, 40, 70));
        sprites.add(ss.getSprite(10, 160, 40, 70));
        sprites.add(ss.getSprite(59, 160, 40, 70));




        frog = new Anim(sprites);
        frog.setSpeed(100);
        frog.start();
    }
    private void init2() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
            BufferedImage image = loader.loadImage("src/Anim/R.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sprite = loader.loadImage("src/Anim/R.png");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        SpriteSheet ss1 = new SpriteSheet("src/Anim/R.png");
        ArrayList<BufferedImage> sprites1 = new ArrayList<BufferedImage>();
        sprites1.add(ss1.getSprite(350, 366, 40, 50));
        sprites1.add(ss1.getSprite(395, 366, 40, 50));
        sprites1.add(ss1.getSprite(441, 366, 40, 50));
        sprites1.add(ss1.getSprite(579, 366, 40, 50));
        sprites1.add(ss1.getSprite(14, 431, 40, 50));
        sprites1.add(ss1.getSprite(63, 431, 40, 50));
        sprites1.add(ss1.getSprite(106, 431, 40, 50));
        sprites1.add(ss1.getSprite(149, 431, 40, 50));
        sprites1.add(ss1.getSprite(195, 431, 40, 50));
        sprites1.add(ss1.getSprite(243, 431, 40, 50));
        sprites1.add(ss1.getSprite(285, 431, 40, 50));
        sprites1.add(ss1.getSprite(332, 431, 40, 50));
        sprites1.add(ss1.getSprite(376, 431, 40, 50));
        sprites1.add(ss1.getSprite(422, 431, 40, 50));




        frog = new Anim(sprites1);
        frog.setSpeed(100);
        frog.start();
    }
    Image dbImage;
    Graphics dbg;
    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void paintComponent(Graphics g) {
        if(frog!=null) {
            frog.update(System.currentTimeMillis());
            g.drawImage(frog.sprite,400,100,100,100,null);}
        repaint();
    }


}



class Anim {
    private  ArrayList<BufferedImage> frames;
    public BufferedImage sprite;
    private volatile boolean running = false;
    private long  previousTime,speed;
    private int frameAtPause, currentFrame;
    public void setSpeed(long speed){
        this.speed=speed;
    }

    public Anim(ArrayList<BufferedImage> frames) {
        this.frames = frames;
    }


    public void update(long time){
        if (running){
            if (time-previousTime>speed){
                currentFrame++;
                try {
                    sprite = frames.get(currentFrame);
                }catch (IndexOutOfBoundsException e){
                    currentFrame = 0;
                    sprite = frames.get(currentFrame);
                }
                previousTime=time;
            }
        }
    }
    public void start(){
        running=true;
        previousTime=0;
        frameAtPause=0;
        currentFrame=0;
    }
    public void stop(){
        running=false;
        previousTime=0;
        frameAtPause=0;
        currentFrame=0;
    }
    public void pause(){
        frameAtPause=currentFrame;
        running=false;
    }
    public void resume(){
        currentFrame=frameAtPause;
        running=true;
    }
}
class BufferedImageLoader {
    public BufferedImage loadImage(String path) throws IOException {

        BufferedImage image = null;
        File file = new File(path);
        image = ImageIO.read(file);
        return image;
    }

}
class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(String path) {
        try {
            sheet = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int width, int height) {
        BufferedImage sprite = sheet.getSubimage(x, y, width, height);
        return sprite;
    }

}

