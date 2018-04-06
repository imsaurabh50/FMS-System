import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class AdminAccountPanel extends SupAccountPanel {

        private JButton Sup = new JButton("Supervisors");
        private Person p;
        private MainFrame MainFrame;

        public AdminAccountPanel(Person p){
            super(p);
            this.p = p;
            doModifications();
        }

        private void doModifications(){
            changeBounds();
            changeTexts();
            changeFonts();
            Sup.setHorizontalAlignment(JButton.CENTER);
            Sup.setBackground(Color.CYAN);
            this.add(Sup);
            addCompAction();
        }

        private void changeBounds(){
            Task.setBounds(10,200,200,50);
            Leave.setBounds(210,200,200,50);
            ReqLogistics.setBounds(410,200,200,50);
            Staffs.setBounds(610,200,200,50);
            Sup.setBounds(810,200,200,50);
            Logout.setBounds(1010,200,200,50);
        }

        private void changeTexts(){
            Leave.setText("Leave Reqs");
            ReqLogistics.setText("Log Reqs");
        }

        private void changeFonts(){
            Task.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            Leave.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            Logout.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            ReqLogistics.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            Staffs.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
            Sup.setFont(new Font(Font.MONOSPACED,Font.PLAIN,15));
        }

        private void addCompAction(){
            Sup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    paintSupPanel();
                }
            });

            for( ActionListener al : Leave.getActionListeners() ) {
                Leave.removeActionListener( al );
            }

            Leave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    paintLeavePanel();
                }
            });

            for( ActionListener al : ReqLogistics.getActionListeners() ) {
                ReqLogistics.removeActionListener( al );
            }

            ReqLogistics.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    paintLogPanel();
                }
            });
        }

        private void paintSupPanel(){
            JPanel SupListPanel = new SupPanel(p);
            MainFrame = MainFrame.getMainFrame();
            MainFrame.setFrame(SupListPanel);
            MainFrame.setTitle(p.getName());
        }

        private void paintLeavePanel(){
            JPanel LeaveListPanel = new LeavePanel(p);
            MainFrame = MainFrame.getMainFrame();
            MainFrame.setFrame(LeaveListPanel);
            MainFrame.setTitle(p.getName());
        }

        private void paintLogPanel(){
            JPanel LogListPanel = new LogPanel(p);
            MainFrame = MainFrame.getMainFrame();
            MainFrame.setFrame(LogListPanel);
            MainFrame.setTitle(p.getName());
        }

//        public static void main(String[] args){
//        Person p = new Person("Admin","0000","admin","admin","admin@fms.com","Admin","all");
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
//        f.setContentPane(new AdminAccountPanel(p));
//        f.revalidate();
//    }

}
