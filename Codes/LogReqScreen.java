import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class LogReqScreen extends JPanel {
    private Person p;
    private JTextField msg = new JTextField("Log Reqs");
    private JTextField dep = new JTextField("Department");
    //private JTextField type = new JTextField("Req");
    private JTextField title = new JTextField("Title");
    private JButton request = new JButton("Request");
    private JButton cancle = new JButton("Cancle");
    private DatabaseManager dbms;
    private MainFrame MainFrame;

    public LogReqScreen(Person p){
        this.p = p;
        this.add(msg);
        this.add(dep);
        this.add(title);
        this.add(request);
        this.add(cancle);
        AddAction();
    }

    private void AddAction(){
        request.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = msg.getText();
                String d = dep.getText();
                String t = title.getText();

                if(!(m.equals("") || d.equals("") || t.equals(""))){
                    Database db = Database.getDatabase();
                    db.makeDatabase();
                    if(p.getType().equals("sup")) {
                        LogReq l = new LogReq(m, d, p.getType(), "requested", t);
                        dbms = DatabaseManager.getDatabaseManager();
                        dbms.updateLogReq(l,db.getSupLogReq(),"SupLogReqDb.csv");
                        paintRequestedScreen();
                    }
                    else{
                        LogReq l = new LogReq(m, d, p.getType(), "requested", t);
                        dbms = DatabaseManager.getDatabaseManager();
                        dbms.updateLogReq(l,db.getStaffLogReq(),"SupLogReqDb.csv");
                        paintRequestedScreen();
                    }
                }
            }
        });

        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.paintAccount();
            }
        });
    }

    private void paintRequestedScreen(){
        JPanel R = new JPanel();
        JLabel req = new JLabel("Requested!");
        JButton b = new JButton("Back");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.paintAccount();
            }
        });
        R.add(b);
        R.add(req);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(R);
        MainFrame.setTitle(p.getName());
    }
}
