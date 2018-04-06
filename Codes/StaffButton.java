import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class StaffButton extends JButton {
    private Person p;
    private Person cp;
    private MainFrame MainFrame;

    public StaffButton(Person p1,Person p2){
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
                paintStaffScreen();
            }
        });
    }

    private void paintStaffScreen(){
        JPanel StaffScreen = new StaffScreen(p,cp);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(StaffScreen);
        MainFrame.setTitle(p.getName());
    }
}
