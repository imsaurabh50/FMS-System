import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 30-11-2016.
 */
public class SupButton extends JButton{
    private Person p;
    private Person cp;
    private MainFrame MainFrame;

    public SupButton(Person p1,Person p2){
        this.p = p1;
        this.cp = p2;
        intiallize();
        AddAction();
    }

    private void intiallize(){
        this.setText(p.getName() + " : " + p.getUsername());
        this.setHorizontalAlignment(JButton.CENTER);
        this.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
    }

    private void AddAction(){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintSupScreen();
            }
        });
    }

    private void paintSupScreen(){
        JPanel SupScreen = new SupScreen(p,cp);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(SupScreen);
        MainFrame.setTitle(p.getName());
    }
}
