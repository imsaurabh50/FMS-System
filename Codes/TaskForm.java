import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 30-11-2016.
 */
public class TaskForm extends JPanel{
//    Deadline;
//    private String AssignTo;
//    private String AssignP_Type;
//    private String Dep;
//    private String title;
//    private String Msg;
//    private String status

    private Person p;
    private Person cp;

    private JTextField deadline = new JTextField("Deadline");
    private JTextField assignTo;
    private JTextField assignP_Type;
    private JTextField dep;
    private JTextField title = new JTextField("Title");
    private JTextField Msg = new JTextField("Message");
    private JTextField status = new JTextField("assigned");
    private JButton back = new JButton("Back");
    private JButton assign = new JButton("Assign");
    private DatabaseManager dbms;
    private MainFrame MainFrame;

    public TaskForm(Person p, Person cp){
        this.p = p;
        this.cp = cp;
        setupPane();
    }

    private void setupPane(){
        initialize();
        AddComp();
        AddAction();
    }

    private void initialize(){
        assignTo = new JTextField(p.getName());
        assignP_Type = new JTextField(p.getType());
        dep = new JTextField(p.getDep());
        assignTo.setEditable(false);
        assignP_Type.setEditable(false);
        dep.setEditable(false);
        status.setEditable(false);
    }

    private void AddComp(){
        this.add(deadline);
        this.add(assignTo);
        this.add(assignP_Type);
        this.add(dep);
        this.add(title);
        this.add(Msg);
        this.add(status);
        this.add(back);
        this.add(assign);
    }

    private void AddAction(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.paintAccount();
            }
        });

        assign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String d = deadline.getText();
                String t = title.getText();
                String m = Msg.getText();
                if(!(d.equals("") || t.equals("") || m.equals(""))){
                    Database db = Database.getDatabase();
                    db.makeDatabase();
                    Task t1 = new Task(d,p.getUsername(),p.getType(),p.getDep(),t,m,"assigned");
                    dbms = DatabaseManager.getDatabaseManager();
                    dbms.AddTask(t1,getDepTaskArray(p),getDepTaskFile(p));
                    paintTaskAssignedScreen();
                }
            }
        });
    }

    private ArrayList<Task> getDepTaskArray(Person p){
        Database db = Database.getDatabase();
        db.makeDatabase();
        if(p.getDep().equals("HVAC") && p.getType().equals("staff")){
            return db.getHvacStaffTasks();
        }
        else if(p.getDep().equals("elec") && p.getType().equals("staff")){
            return db.getElecStaffTasks();
        }
        else if(p.getDep().equals("room") && p.getType().equals("staff")){
            return db.getRoomStaffTasks();
        }
        else if(p.getDep().equals("media") && p.getType().equals("staff")){
            return db.getMediaStaffTasks();
        }
        else if(p.getDep().equals("security") && p.getType().equals("staff")){
            return db.getSecStaffTasks();
        }
        else if(p.getDep().equals("HVAC") && p.getType().equals("sup")){
            return db.getHvacSupTasks();
        }
        else if(p.getDep().equals("elec") && p.getType().equals("sup")){
            return db.getElecSupTasks();
        }
        else if(p.getDep().equals("room") && p.getType().equals("sup")){
            return db.getRoomSupTasks();
        }
        else if(p.getDep().equals("media") && p.getType().equals("sup")){
            return db.getMediaSupTasks();
        }
        else{
            return db.getSecSupTasks();
        }
    }

    private String getDepTaskFile(Person p){
        Database db = Database.getDatabase();
        db.makeDatabase();
        if(p.getDep().equals("HVAC") && p.getType().equals("staff")){
            return "hvacStaffTaskDb.csv";
        }
        else if(p.getDep().equals("elec") && p.getType().equals("staff")){
            return "elecStaffTaskDb.csv";
        }
        else if(p.getDep().equals("room") && p.getType().equals("staff")){
            return "houseStaffTaskDb.csv";
        }
        else if(p.getDep().equals("media") && p.getType().equals("staff")){
            return "mediaStaffTaskDb.csv";
        }
        else if(p.getDep().equals("security") && p.getType().equals("staff")){
            return "securityStaffTaskDb.csv";
        }
        else if(p.getDep().equals("HVAC") && p.getType().equals("sup")){
            return "hvacSupTaskDb.csv";
        }
        else if(p.getDep().equals("elec") && p.getType().equals("sup")){
            return "elecSupTaskDb.csv";
        }
        else if(p.getDep().equals("room") && p.getType().equals("sup")){
            return "houseSupTaskDb.csv";
        }
        else if(p.getDep().equals("media") && p.getType().equals("sup")){
            return "mediaSupTaskDb.csv";
        }
        else{
            return "securitySupTaskDb.csv";
        }
    }

    private void paintTaskAssignedScreen(){
        JPanel R = new JPanel();
        JLabel req = new JLabel("Task Assigned!");
        JButton b = new JButton("Back");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.paintAccount();
            }
        });
        R.add(b);
        R.add(req);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(R);
        MainFrame.setTitle(p.getName());
    }
}
