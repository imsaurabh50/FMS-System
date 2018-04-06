import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class StaffAccountPanel extends JPanel{
    protected JButton Task = new JButton("Tasks");
    protected JButton Leave = new JButton("Request Leave");
    protected JButton ReqLogistics = new JButton("Request Logistics");
    protected JButton Logout = new JButton("Logout");
    protected JLabel name;
    protected JLabel UID;
    protected JLabel username;
    protected JLabel email;
    protected JLabel Department;
    protected JLabel Designation;
    protected JLabel welcom;

    private MainFrame MainFrame;

    private Person p;

    //public StaffAccountPanel(){}

    public StaffAccountPanel(Person p){
        this.p = p;
        setPaneContent();
    }

    private void setPaneContent(){
        this.setLayout(null);
        initializeLables();
        setCompBackground();
        setCompBounds();
        setCompFont();
        addCompToPanel();
        setupActionForButtons();
    }

    protected void setCompBounds(){
        Task.setBounds(10,200,300,50);
        Leave.setBounds(310,200,300,50);
        ReqLogistics.setBounds(610,200,300,50);
        Logout.setBounds(910,200,300,50);
        name.setBounds(100,350,700,60);
        UID.setBounds(100,430,700,60);
        username.setBounds(100,510,700,60);
        email.setBounds(100,590,700,60);
        Department.setBounds(100,670,700,60);
        Designation.setBounds(100,750,700,60);
        welcom.setBounds(650,75,700,70);
    }

    protected void addCompToPanel(){
        this.add(Task);
        this.add(Leave);
        this.add(ReqLogistics);
        this.add(Logout);
        this.add(name);
        this.add(UID);
        this.add(username);
        this.add(email);
        this.add(Department);
        this.add(Designation);
        this.add(welcom);
    }

    private void setCompBackground(){
        this.setBackground(Color.ORANGE);
        Task.setBackground(Color.CYAN);
        Logout.setBackground(Color.CYAN);
        Leave.setBackground(Color.CYAN);
        ReqLogistics.setBackground(Color.CYAN);
    }

    private void setCompFont(){
        Task.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        Leave.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        Logout.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        ReqLogistics.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        name.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        UID.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        username.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        email.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        Department.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        Designation.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
        welcom.setFont(new Font(Font.MONOSPACED,Font.PLAIN,60));
    }

    private void initializeLables(){
        name = new JLabel("Name: "+p.getName());
        UID = new JLabel("UID: "+p.getUID());
        username = new JLabel("Username: "+p.getUsername());
        email = new JLabel("Email-ID: "+p.getEmail());
        Department = new JLabel("Department: "+p.getDep());
        Designation = new JLabel("Designation: "+p.getType());
        welcom = new JLabel("Welcome "+p.getName()+" !");
    }

    protected void setupActionForButtons(){
        Logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().setFrame(Login.getLogin().getLoginCanvas());
                Login.getLogin().setMsg("");
            }
        });

        Task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintTaskList();
            }
        });

        Leave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintLeaveReqScreen();
            }
        });

        ReqLogistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintLogReqScreen();
            }
        });
    }

    private void paintTaskList(){
        JPanel taskListPanel = new StaffTasksPanel(p);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(taskListPanel);
        MainFrame.setTitle(p.getName());
    }

    private void paintLeaveReqScreen(){
        JPanel leaveReqPanel = new LeaveReqScreen(p);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(leaveReqPanel);
        MainFrame.setTitle(p.getName());
    }

    private void paintLogReqScreen(){
        JPanel logReqPanel = new LogReqScreen(p);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(logReqPanel);
        MainFrame.setTitle(p.getName());
    }

//    public static void main(String[] args){
//        Person p = new Person("test","10","tester123","wtf","tes@gmail.com","staff","HVAC");
//        JFrame f = new JFrame();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.setTitle("FMS System");
//        f.setResizable(false);
//        f.getContentPane().setBackground(Color.ORANGE);
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = kit.getScreenSize();
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//        f.setSize((9*screenWidth)/10,(9*screenHeight)/10);
//        f.setLayout(null);
//        f.setLocationByPlatform(true);
//        f.setVisible(true);
//        f.setContentPane(new StaffAccountPanel(p));
//        f.revalidate();
//    }
}
