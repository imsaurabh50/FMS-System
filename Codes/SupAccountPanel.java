import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class SupAccountPanel extends StaffAccountPanel {
    private Person p;
    private MainFrame MainFrame;
    protected JButton Staffs = new JButton("Staffs");

   // public SupAccountPanel(){}

    public SupAccountPanel(Person p){
        super(p);
        this.p = p;
        setSupPanel();
    }

    private void setSupPanel(){
        setStCompBounds();
        setCompFonts();
        setCompBackColor();
        setCompAlignment();
        addStCompToPanel();
        addAction();
    }

    private void setStCompBounds(){
        Staffs.setBounds(1210,200,300,50);
    }

    private void setCompFonts(){
        Staffs.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
    }

    private void setCompBackColor(){
        Staffs.setBackground(Color.CYAN);
    }

    private void setCompAlignment(){
        Staffs.setHorizontalAlignment(JButton.CENTER);
    }

    private void addStCompToPanel(){
        this.add(Staffs);
    }

    private void addAction(){
        Staffs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintStaffPanel();
            }
        });
    }

    private void paintStaffPanel(){
        JPanel StaffListPanel = new StaffPanel(p);
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(StaffListPanel);
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
//        f.setContentPane(new SupAccountPanel(p));
//        f.revalidate();
//    }
}
