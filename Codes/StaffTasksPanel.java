import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class StaffTasksPanel extends JPanel {

    private JLabel reads = new JLabel("Tasks");
    private JButton back = new JButton("Back");
    private Person p;

    public StaffTasksPanel(Person p){
        this.p = p;
        setPane();
    }

    private void setPane(){
        this.setLayout(null);
        ArrayList<Task> tasks = getTasks();
        int cnt = 0;
        int y = 200;
        for (Task t:tasks){
            JButton i = new TaskButton(t,p);
            i.setBounds(10,y,910,30);
            this.add(i);
            y+=30;
            if(cnt%2==0){
                i.setBackground(Color.GRAY);
            }
            else{
                i.setBackground(Color.DARK_GRAY);
            }
            cnt++;
        }
        this.setBackground(Color.ORANGE);
        reads.setFont(new Font(Font.MONOSPACED,Font.PLAIN,60));
        reads.setBounds(50,40,300,100);
        back.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        back.setHorizontalAlignment(JButton.CENTER);
        back.setBackground(Color.PINK);
        back.setBounds(900,100,300,50);
        this.add(back);
        this.add(reads);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!p.getType().equals("Admin")) {
                    p.paintAccount();
                }
                else{
                    Admin.paintAdminAccount();
                }
            }
        });
    }

    private ArrayList<Task> getTasks(){
        String type = p.getType();
        //System.out.println(type);
        String dep = p.getDep();
        //System.out.println(dep);
        Database db = Database.getDatabase();
        db.makeDatabase();
        ArrayList<Task> StaffSpecificTask = new ArrayList<>();
        ArrayList<Task> GeneralTasks;
        if(type.equals("staff")){
            if(dep.equals("elec")){
                GeneralTasks =  db.getElecStaffTasks();
            }
            else if(dep.equals("HVAC")){
                GeneralTasks = db.getHvacStaffTasks();
            }
            else if(dep.equals("room")){
                GeneralTasks = db.getRoomStaffTasks();
            }
            else if(dep.equals("media")){
                GeneralTasks = db.getMediaStaffTasks();
            }
            else{
                GeneralTasks = db.getSecStaffTasks();
            }

            //System.out.println(GeneralTasks);

            for(Task t:GeneralTasks){
                if(t.getAssignTo().equals(p.getUsername())){
                    StaffSpecificTask.add(t);
                    //System.out.println("Assigned Task: "+t.getTitle());
                }
            }

            return StaffSpecificTask;
        }
        else if(type.equals("sup")){
            if(dep.equals("elec")){
                GeneralTasks =  db.getElecSupTasks();
            }
            else if(dep.equals("HVAC")){
                GeneralTasks = db.getHvacSupTasks();
            }
            else if(dep.equals("room")){
                GeneralTasks = db.getRoomSupTasks();
            }
            else if(dep.equals("media")){
                GeneralTasks = db.getMediaSupTasks();
            }
            else{
                GeneralTasks = db.getSecSupTasks();
            }

            for(Task t:GeneralTasks){
                if(t.getAssignTo().equals(p.getUsername())){
                    StaffSpecificTask.add(t);
                }
            }

            return StaffSpecificTask;
        }
        else if(type.equals("Admin")){
            StaffSpecificTask.addAll(db.getElecStaffTasks());
            StaffSpecificTask.addAll(db.getElecSupTasks());
            StaffSpecificTask.addAll(db.getHvacStaffTasks());
            StaffSpecificTask.addAll(db.getHvacSupTasks());
            StaffSpecificTask.addAll(db.getRoomStaffTasks());
            StaffSpecificTask.addAll(db.getRoomSupTasks());
            StaffSpecificTask.addAll(db.getMediaStaffTasks());
            StaffSpecificTask.addAll(db.getMediaSupTasks());
            StaffSpecificTask.addAll(db.getSecStaffTasks());
            StaffSpecificTask.addAll(db.getSecSupTasks());
            return StaffSpecificTask;
        }
        else{
            return StaffSpecificTask;
        }
    }
}
