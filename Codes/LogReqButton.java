import javax.swing.*;
import java.awt.*;

/**
 * Created by Saurabh Kumar on 30-11-2016.
 */
public class LogReqButton extends JButton{
    private LogReq l;
    private Person cp;
    private MainFrame MainFrame;

    public LogReqButton(LogReq l1,Person p2){
        this.l = l1;
        this.cp = p2;
        intiallize();
        //AddAction();
    }

    private void intiallize(){
        this.setText(l.getTitle());
        this.setHorizontalAlignment(JButton.CENTER);
        this.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
    }
}
