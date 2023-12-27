package PROSTO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class INFOCENTER {
    public static void main(String[] args) {
Model model = new Model();
Model1 model1 = new Model1();
Visual visual = new Visual(model,model1);
Controller controller = new Controller(model,model1,visual);
    }

}
class Model {
    private String info;
    public void setInfo(String info){
        this.info=info;
    }
}
class Model1{
    private String info;
    public void setInfo(String info){
        this.info=info;
    }
}
class Visual extends JFrame {
    private JButton button;
    private JButton button1;
    private Controller controller;
    private JTextArea text;
    public Visual(Model model, Model1 model1){
        super("Info");
        button=new JButton();
        button.setText("CS");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        controller.CSBut();
            }
        });
        button1=new JButton();
        button1.setText("LoL");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        controller.LoLBut();
            }
        });

        text = new JTextArea();
        setSize(1200,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(button);
        getContentPane().add(button1);
        getContentPane().add(text);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void setController(Controller controller){
        this.controller=controller;
    }
    public void EditInfo(String csinfo){text.setText(csinfo);}
    public void EditInfo1(String lolinfo){text.setText(lolinfo);}
}
class Controller {
    private Model model;
    private Model1 model1;
    private Visual visual;

    public Controller(Model model, Model1 model1, Visual visual) {
        this.model = model;
        this.model1 = model1;
        this.visual = visual;
        visual.setController(this);
    }
    public void CSBut(){
        String info = "Counter-Strike  — багатокористувацька відеогра, шутер від першої особи, розроблений та випущений для Windows американською компанією Valve.";
        model.setInfo(info);
        visual.EditInfo(info);
    }
    public void LoLBut(){
        String info = "League of Legends (укр. Ліга Легенд, вживається скорочення LoL) — відеогра жанру MOBA (багатокористувацька онлайн бойова арена), створена командою розробників Riot Games.";
    model1.setInfo(info);
    visual.EditInfo(info);
    }
}