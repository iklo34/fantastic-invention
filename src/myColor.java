import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myColor extends JFrame implements ActionListener {
    private int R;
    private int G;
    private int B;
    Color con;

    public Color getCon() {
        return con;
    }

    public void myColor(){
        setSize(400,400);setVisible(true);setLayout(null);
        JLabel name=new JLabel("RGB of your color");name.setBounds(130,0,120,15);add(name);
        JLabel namer=new JLabel("R");namer.setBounds(10,20,30,20);add(namer);
        JLabel nameg=new JLabel("G");nameg.setBounds(10,40,30,20);add(nameg);
        JLabel nameb=new JLabel("B");nameb.setBounds(10,60,30,20);add(nameb);
        JTextField whichr=new JTextField();whichr.setBounds(60,20,100,20);add(whichr);whichr.addActionListener(this);
        JTextField whichg=new JTextField();whichg.setBounds(60,40,100,20);add(whichg);whichg.addActionListener(this);
        JTextField whichb=new JTextField();whichb.setBounds(60,60,100,20);add(whichb);whichb.addActionListener(this);
        JButton apply=new JButton("Apply");apply.setBounds(200,20,70,40);add(apply);
        apply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                R=Integer.parseInt(whichr.getText());
                G=Integer.parseInt(whichg.getText());
                B=Integer.parseInt(whichb.getText());
               con=new Color(R,G,B);

            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

