import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class TaskScreen extends JPanel {
    private Task t;
    private JLabel deadline;
    private JLabel title;
    private JTextField msg;
    private JLabel status;
    private JLabel reads = new JLabel("Task Detail");
    private JButton back = new JButton("Back");
    private Person p;
    private MainFrame MainFrame;
    private JRadioButton inProg = new JRadioButton("IN PROGRESS");
    private JRadioButton done = new JRadioButton("DONE");
    private JLabel changeStatus = new JLabel("Change Status");
    private DatabaseManager dbms;

    public TaskScreen(Task t, Person p){
        this.p = p;
        this.t = t;
        setPane();
    }

    private void  setPane(){
        this.setLayout(null);
        initialize();
        setCompFonts();
        setCompBounds();
        addComp();
        addAction();
    }

    private void initialize(){
        deadline = new JLabel("Deadline: "+t.getDeadline());
        title = new JLabel("Title: "+t.getTitle());
        msg = new JTextField("Details: "+t.getMsg());
        msg.setBackground(Color.ORANGE);
        msg.setEditable(false);
        status = new JLabel("Status: "+t.getStatus());
        this.setBackground(Color.ORANGE);
        back.setBackground(Color.PINK);
        inProg.setBackground(Color.ORANGE);
        done.setBackground(Color.ORANGE);
        ButtonGroup bg = new ButtonGroup();
        bg.add(inProg);
        bg.add(done);
    }

    private void setCompFonts(){
        deadline.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        title.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        msg.setFont(new Font(Font.MONOSPACED,Font.PLAIN,40));
        status.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        reads.setFont(new Font(Font.MONOSPACED,Font.PLAIN,60));
        back.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        inProg.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        done.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        changeStatus.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
    }

    private void setCompBounds(){
        reads.setBounds(50,40,500,100);
        back.setBounds(900,100,300,50);
        title.setBounds(100,200,1000,60);
        deadline.setBounds(100,290,1000,60);
        status.setBounds(100,380,1000,60);
        msg.setBounds(100,470,1000,200);
        changeStatus.setBounds(100,770,500,40);
        inProg.setBounds(150,820,300,50);
        done.setBounds(500,820,300,50);
    }

    private void addComp(){
        this.add(reads);
        this.add(title);
        this.add(deadline);
        this.add(status);
        this.add(msg);
        this.add(back);
        this.add(inProg);
        this.add(done);
        this.add(changeStatus);
    }

    private void paintTaskList(){
        JPanel taskList = new StaffTasksPanel(p);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(taskList);
        MainFrame.setTitle(p.getName());
    }

    private ArrayList<Task> getDepTaskArray(Task t){
        Database db = Database.getDatabase();
        db.makeDatabase();
        if(t.getDep().equals("HVAC") && t.getAssignP_Type().equals("staff")){
            return db.getHvacStaffTasks();
        }
        else if(t.getDep().equals("elec") && t.getAssignP_Type().equals("staff")){
            return db.getElecStaffTasks();
        }
        else if(t.getDep().equals("room") && t.getAssignP_Type().equals("staff")){
            return db.getRoomStaffTasks();
        }
        else if(t.getDep().equals("media") && t.getAssignP_Type().equals("staff")){
            return db.getMediaStaffTasks();
        }
        else if(t.getDep().equals("security") && t.getAssignP_Type().equals("staff")){
            return db.getSecStaffTasks();
        }
        else if(t.getDep().equals("HVAC") && t.getAssignP_Type().equals("sup")){
            return db.getHvacSupTasks();
        }
        else if(t.getDep().equals("elec") && t.getAssignP_Type().equals("sup")){
            return db.getElecSupTasks();
        }
        else if(t.getDep().equals("room") && t.getAssignP_Type().equals("sup")){
            return db.getRoomSupTasks();
        }
        else if(t.getDep().equals("media") && t.getAssignP_Type().equals("sup")){
            return db.getMediaSupTasks();
        }
        else{
            return db.getSecSupTasks();
        }
    }

    private String getDepTaskFile(Task t){
        Database db = Database.getDatabase();
        db.makeDatabase();
        if(t.getDep().equals("HVAC") && t.getAssignP_Type().equals("staff")){
            return "hvacStaffTaskDb.csv";
        }
        else if(t.getDep().equals("elec") && t.getAssignP_Type().equals("staff")){
            return "elecStaffTaskDb.csv";
        }
        else if(t.getDep().equals("room") && t.getAssignP_Type().equals("staff")){
            return "houseStaffTaskDb.csv";
        }
        else if(t.getDep().equals("media") && t.getAssignP_Type().equals("staff")){
            return "mediaStaffTaskDb.csv";
        }
        else if(t.getDep().equals("security") && t.getAssignP_Type().equals("staff")){
            return "securityStaffTaskDb.csv";
        }
        else if(t.getDep().equals("HVAC") && t.getAssignP_Type().equals("sup")){
            return "hvacSupTaskDb.csv";
        }
        else if(t.getDep().equals("elec") && t.getAssignP_Type().equals("sup")){
            return "elecSupTaskDb.csv";
        }
        else if(t.getDep().equals("room") && t.getAssignP_Type().equals("sup")){
            return "houseSupTaskDb.csv";
        }
        else if(t.getDep().equals("media") && t.getAssignP_Type().equals("sup")){
            return "mediaSupTaskDb.csv";
        }
        else{
            return "securitySupTaskDb.csv";
        }
    }

    private void addAction(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintTaskList();
            }
        });

        inProg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("Status: IN PROGRESS");
                Task t2 = new Task(t.getDeadline(),t.getAssignTo(),t.getAssignP_Type(),t.getDep(),t.getTitle(),t.getMsg(),"IN PROGRESS");
                dbms = DatabaseManager.getDatabaseManager();
                dbms.updateTask(t2,getDepTaskArray(t),getDepTaskFile(t));
            }
        });

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                status.setText("Status: DONE");
                Task t2 = new Task(t.getDeadline(),t.getAssignTo(),t.getAssignP_Type(),t.getDep(),t.getTitle(),t.getMsg(),"DONE");
                dbms = DatabaseManager.getDatabaseManager();
                dbms.updateTask(t2,getDepTaskArray(t),getDepTaskFile(t));
            }
        });
    }
}
