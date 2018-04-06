import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class StaffScreen extends JPanel{
    private Person p;
    private Person cp;
    private JLabel name;
    private JLabel status;
    private JButton AssignTask = new JButton("Assign Task");
    private JButton back = new JButton("Back");
    private MainFrame MainFrame;
    //private JButton delete = new JButton("Delete it!");

    public StaffScreen(Person p1,Person p2){
        this.p = p1;
        this.cp = p2;
        setpane();
    }

    private void setpane(){
        name = new JLabel(p.getName());
        status = new JLabel(p.getStatus());
        this.add(name);
        this.add(status);
        this.add(AssignTask);
        this.add(back);
        AddAction();
    }

    private void AddAction(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.paintAccount();
            }
        });

        AssignTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintTaskForm();
            }
        });
    }

    private void paintTaskForm(){
        JPanel taskForm = new TaskForm(p,cp);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(taskForm);
        MainFrame.setTitle(p.getName());
    }

}
