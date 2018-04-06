import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class TaskButton extends JButton {
    private Task t;
    private MainFrame MainFrame;
    private JPanel taskScreen;
    private Person p;

    public TaskButton(Task t, Person p){
        this.t = t;
        this.p = p;
        intiallize();
        AddAction();
    }

    private void intiallize(){
        this.setText(t.getTitle()+"  Deadline: "+t.getDeadline());
        this.setHorizontalAlignment(JButton.CENTER);
        this.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
    }

    private void AddAction(){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintTaskScreen();
            }
        });
    }

    private void paintTaskScreen(){
        taskScreen = new TaskScreen(t,p);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(taskScreen);
        MainFrame.setTitle(t.getTitle());
    }
}
