import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 30-11-2016.
 */
public class LeaveButton extends JButton {
    private Leave l;
    private Person cp;
    private MainFrame MainFrame;

    public LeaveButton(Leave l1,Person p2){
        this.l = l1;
        this.cp = p2;
        intiallize();
        //AddAction();
    }

    private void intiallize(){
        this.setText(l.getLeaveTitle());
        this.setHorizontalAlignment(JButton.CENTER);
        this.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
    }

//    private void AddAction(){
//        this.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                paintStaffScreen();
//            }
//        });
//    }

//    private void paintStaffScreen(){
//        JPanel StaffScreen = new StaffScreen(p,cp);
//        MainFrame = MainFrame.getMainFrame();
//        MainFrame.setFrame(StaffScreen);
//        MainFrame.setTitle(p.getName());
//    }
}
