import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class LeaveReqScreen extends JPanel {
    private Person p;
    private JLabel reads = new JLabel("Request Leave");
    private JTextField from = new JTextField("Form:");
    private JTextField to = new JTextField("To:");
    private JTextField why = new JTextField("Why?");
    private JButton request = new JButton("Request");
    private JButton cancle = new JButton("Cancle");
    private DatabaseManager dbms;
    private MainFrame MainFrame;

    public LeaveReqScreen(Person p){
        this.p = p;
        setPane();
    }

    private void setPane(){
        this.setLayout(null);
        setCompFormat();
        setCompBounds();
        setCompBackColor();
        setCompAlignment();
        addCompToPane();
        addAction();
    }

    private void setCompFormat(){
        from.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        to.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        why.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        request.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        cancle.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        reads.setFont(new Font(Font.MONOSPACED,Font.PLAIN,60));
    }

    private void setCompBounds(){
        reads.setBounds(50,50,900,100);
        from.setBounds(700,300,300,50);
        to.setBounds(700,400,300,50);
        why.setBounds(700,500,1000,200);
        request.setBounds(650,750,300,50);
        cancle.setBounds(1000,750,300,50);
    }

    private void setCompBackColor(){
        request.setBackground(Color.CYAN);
        cancle.setBackground(Color.PINK);
    }

    private void setCompAlignment(){
        from.setHorizontalAlignment(JTextField.CENTER);
        to.setHorizontalAlignment(JTextField.CENTER);
        why.setHorizontalAlignment(JTextField.CENTER);
        request.setHorizontalAlignment(JButton.CENTER);
        cancle.setHorizontalAlignment(JButton.CENTER);
    }

    private void addCompToPane(){
        this.add(from);
        this.add(to);
        this.add(why);
        this.add(request);
        this.add(cancle);
        this.add(reads);
    }

    private void addAction(){
        request.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String f = from.getText();
                String t = to.getText();
                String w = why.getText();
                if(f.equals("") || t.equals("")){
                    from.setText("Enter From!");
                    to.setText("Enter TO!");
                }
                else{
                    if(p.getType().equals("sup")){
                        dbms = DatabaseManager.getDatabaseManager();
                        Database db = Database.getDatabase();
                        db.makeDatabase();
                        Leave l1 = new Leave(f,t,w,"requested",f+t);
                        dbms.updateLeaveReq(l1,db.getSupLeaveReq(),"SupLeaveReqDb.csv");
                        painRequestedScreen();
                    }
                    else{
                        dbms = DatabaseManager.getDatabaseManager();
                        Database db = Database.getDatabase();
                        db.makeDatabase();
                        Leave l2 = new Leave(f,t,w,"requested",f+t);
                        dbms.updateLeaveReq(l2,db.getStaffLeaveReq(),"StaffLeavReqDb.csv");
                        painRequestedScreen();
                    }
                }
            }
        });
        from.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                from.setText("");
            }
        });
        to.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                to.setText("");
            }
        });
        why.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                why.setText("");
            }
        });

        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.paintAccount();
            }
        });
    }

    private void painRequestedScreen(){
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
