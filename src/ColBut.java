import javax.swing.*;
import java.awt.*;

public class ColBut extends JButton {
    Color color;
public ColBut(String text,Color color){
    super(text);
    this.color=color;
}

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
   public void paint(Graphics g){
    g.setColor(color);
    g.fillRect(0,0,getWidth(),getHeight());
}
}
