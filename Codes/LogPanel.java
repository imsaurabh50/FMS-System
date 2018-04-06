import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 30-11-2016.
 */
public class LogPanel extends JPanel {
    private Person p;
    private JButton back = new JButton("Back");
    private Database db;
    //private DatabaseManager dbms;

    public LogPanel(Person p){
        this.p = p;
        setupPane();
    }

    private void setupPane(){
        this.setLayout(null);
        ArrayList<LogReq> logs = getLogs();
        int cnt = 0;
        int y = 200;
        for (LogReq p1:logs){
            JButton i = new LogReqButton(p1,p);
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

    private ArrayList<LogReq> getLogs(){
        db = Database.getDatabase();
        db.makeDatabase();
        ArrayList<LogReq> logs = db.getStaffLogReq();
        logs.addAll(db.getSupLogReq());
        return logs;
    }
}
