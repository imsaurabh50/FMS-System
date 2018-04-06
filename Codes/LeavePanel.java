import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 30-11-2016.
 */
public class LeavePanel extends JPanel {
    private Person p;
    private JButton back = new JButton("Back");
    private Database db;
    //private DatabaseManager dbms;

    public LeavePanel(Person p){
        this.p = p;
        setupPane();
    }

    private void setupPane(){
        this.setLayout(null);
        ArrayList<Leave> leaves = getLeaves();
        int cnt = 0;
        int y = 200;
        for (Leave p1:leaves){
            JButton i = new LeaveButton(p1,p);
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
                p.paintAccount();
            }
        });
    }

    private ArrayList<Leave> getLeaves(){
        db = Database.getDatabase();
        db.makeDatabase();
        ArrayList<Leave> leaves = db.getStaffLeaveReq();
        leaves.addAll(db.getSupLeaveReq());
        return leaves;
    }
}
