import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Пару функцій ще не дороблені, але вже вийшло прикольно,і якщо ви хочете свій колір після того як ви ввели його трба натиснути апплай і потім рефреш
public class paint extends JFrame implements MouseMotionListener, KeyListener, ActionListener {
    public static void main(String[] args) {

    }
    private int x;private int y;float lineStroke = 1.0f;
    Color color=Color.BLACK;

    myColor color1=new myColor();

    paint(){
        setSize(1400,1400);JFrame.setDefaultLookAndFeelDecorated(true);
        setVisible(true);setLayout(null);
        JPanel lol=new JPanel();lol.setBackground(Color.WHITE);
        ColBut but=new ColBut("black",Color.BLACK);but.setBounds(0,0,30,30);add(but);but.addActionListener(this);
        ColBut but1=new ColBut("gray",Color.GRAY);but1.setBounds(30,0,30,30);add(but1);but1.addActionListener(this);
        ColBut but2=new ColBut("brown",color=new Color(97, 28, 1));but2.setBounds(60,0,30,30);add(but2);but2.addActionListener(this);
        ColBut but3=new ColBut("red",Color.RED);but3.setBounds(90,0,30,30);add(but3);but3.addActionListener(this);
        ColBut but4=new ColBut("orange",Color.ORANGE);but4.setBounds(120,0,30,30);add(but4);but4.addActionListener(this);
        ColBut but5=new ColBut("yellow",Color.YELLOW);but5.setBounds(150,0,30,30);add(but5);but5.addActionListener(this);
        ColBut but6=new ColBut("green",Color.GREEN);but6.setBounds(180,0,30,30);add(but6);but6.addActionListener(this);
        ColBut but7=new ColBut("cyan",Color.CYAN);but7.setBounds(210,0,30,30);add(but7);but7.addActionListener(this);
        ColBut but8=new ColBut("blue",Color.BLUE);but8.setBounds(240,0,30,30);add(but8);but8.addActionListener(this);
        ColBut but9=new ColBut("purple",color=new Color(90, 20, 120));but9.setBounds(270,0,30,30);add(but9);but9.addActionListener(this);
        JButton bu=new JButton("my own col");bu.setBounds(300,0,100,30);add(bu);bu.addActionListener(this);
        JButton bunt=new JButton("delete");bunt.setBounds(1300,0,100,50);add(bunt);bunt.addActionListener(this);
        JButton refr=new JButton("refresh color");refr.setBounds(1150,0,150,50);add(refr);refr.addActionListener(this);
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
color1.myColor();
            }
        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(this);
        addKeyListener(this);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics2D g2d = (Graphics2D) getGraphics();
        if (x==0 && y ==0){
            x =e.getX();
            y = e.getY();
            return;
        }
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(lineStroke));
        g2d.drawLine(x, y, e.getX(), e.getY());

        x =e.getX();
        y = e.getY();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        x=0;y=0;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                lineStroke += 1.0f;
                break;
            case KeyEvent.VK_S:
                if(lineStroke>1.0) {
                    lineStroke -= 1.0f;
                    break;
                }}
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Graphics g=getGraphics();
        g.setColor(color);
        g.fillOval(x,y,30,30);
    }
    public void refresh(myColor color1){
        color=color1.getCon();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "red": color=Color.RED;break;
            case "blue":color=Color.BLUE;break;
            case "black":color=Color.BLACK;break;
            case "gray":color=Color.GRAY;break;
            case "brown":color=new Color(97, 28, 1);break;
            case "orange":color=Color.ORANGE;break;
            case "yellow":color=Color.YELLOW;break;
            case "green":color=Color.GREEN;break;
            case "cyan":color=Color.CYAN;break;
            case "purple":color=new Color(90, 20, 120);break;
            case "delete":repaint();
            case "refresh color":refresh(color1);

        }
    }
}