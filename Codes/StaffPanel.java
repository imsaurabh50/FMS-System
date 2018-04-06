import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class StaffPanel extends JPanel {
    private Person p;
    private JButton back = new JButton("Back");
    private Database db;
    //private DatabaseManager dbms;

    public StaffPanel(Person p){
        this.p = p;
        setupPane();
    }

    private void setupPane(){
        this.setLayout(null);
        ArrayList<Person> staffs = getStaffs();
        int cnt = 0;
        int y = 200;
        for (Person p1:staffs){
            JButton i = new StaffButton(p1,p);
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
        back.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        back.setHorizontalAlignment(JButton.CENTER);
        back.setBackground(Color.PINK);
        back.setBounds(900,100,300,50);
        this.add(back);
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

    private ArrayList<Person> getStaffs(){
        db = Database.getDatabase();
        db.makeDatabase();
        ArrayList<Person> staffs = db.getPersons();
        staffs.addAll(db.getPendingPersons());
        ArrayList<Person> specificStaffs = new ArrayList<>();
        if(!p.getType().equals("Admin")) {
            for (Person p1 : staffs) {
                if (p1.getDep().equals(p.getDep()) && p1.getType().equals("staff")) {
                    specificStaffs.add(p1);
                }
            }
            return specificStaffs;
        }
        else{
            for (Person p1 : staffs) {
                if (p1.getType().equals("staff")) {
                    specificStaffs.add(p1);
                }
            }
            return specificStaffs;
        }
    }
}
