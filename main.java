package Bob;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButMod mod = new ButMod();
                ButMod1 mod1 = new ButMod1();
                MainScreen screen = new MainScreen(mod,mod1);
                MainController controller = new MainController(mod,mod1,screen);}
        });
    }
}
class ButMod {
    private String buttonText;

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
class ButMod1 {
    private String buttonText;
    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
class MainScreen extends JFrame{
    private JButton button;
    private JButton button1;
    private MainController controller;
    public MainScreen(ButMod butMod, ButMod1 butMod1){
        super("Edit text");
        button= new JButton();
        button.setText("change text");
        button.addActionListener(new ActionListener() {
                                     @Override
                                     public void actionPerformed(ActionEvent e) {
                                         controller.ClickOnBut();
                                     }
                                 }
        );
        button1= new JButton();
        button1.setText("Change super text");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.ClickOnSecBut();
            }
        });

        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(button);
        getContentPane().add(button1);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void EditText(String newText){
        button.setText(newText);
    }
    public void EditText1(String newText){button1.setText(newText);}
    public void setController(MainController controller){
        this.controller=controller;
    }

}
class MainController {
    private ButMod butMod;
    private ButMod1 butMod1;
    private MainScreen mainScreen;

    public MainController(ButMod butMod,ButMod1 butMod1, MainScreen mainScreen) {
        this.butMod = butMod;
        this.mainScreen = mainScreen;
        this.butMod1 = butMod1;
        mainScreen.setController(this);
    }
    public void ClickOnBut(){
        String buttonText = "New Edited text trololo";
        butMod.setButtonText(buttonText);
        mainScreen.EditText(buttonText);
    }
    public void ClickOnSecBut(){
        String buttonText = "Super puper new text";
        butMod1.setButtonText(buttonText);
        mainScreen.EditText1(buttonText);
    }
}