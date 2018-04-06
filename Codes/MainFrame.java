import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class MainFrame {
    private JFrame Frame;
    private JLabel label;
    private JButton login;
    private JButton register;
    private static MainFrame MainFrame;

    private MainFrame(){
        this.Frame = new JFrame();
        this.label = new JLabel();
        this.login = new JButton("Login");
        this.register = new JButton("Register");
        setFrameProperties();
        setLableProperties();
        setButtonProperties();
        this.Frame.getContentPane().add(label);
        this.Frame.getContentPane().add(login);
        this.Frame.getContentPane().add(register);
    }

    private void setFrameProperties(){
        this.Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.Frame.setTitle("FMS System");
        this.Frame.setResizable(false);
        this.Frame.getContentPane().setBackground(Color.ORANGE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        this.Frame.setSize((9*screenWidth)/10,(9*screenHeight)/10);
        this.Frame.setLayout(null);
        this.Frame.setLocationByPlatform(true);
        this.Frame.setVisible(true);
    }

    private void setLableProperties(){
        this.label.setText("Facility Management Services System");
        this.label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,60));
        this.label.setBounds(350,200,2000,100);
    }

    private void setButtonProperties(){
        login.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        login.setFocusPainted(false);
        register.setFocusPainted(false);
        login.setBounds(800,500,100,35);
        register.setBounds(800,550,100,35);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.getLogin().paintLoginScreen();
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register.getRegister().paintRegisterScreen();
            }
        });
    }

    public void setTitle(String s){
        this.Frame.setTitle(s);
    }

    public void setFrame(Container c){
        this.Frame.setContentPane(c);
        //this.Frame.getContentPane().removeAll();
        //this.Frame.add(c);
        this.Frame.revalidate();
        //this.Frame.repaint();
    }

    public void dispose(){
        this.Frame.dispose();
    }

    public static MainFrame getMainFrame(){
        if(MainFrame == null){
            MainFrame = new MainFrame();
        }

        return MainFrame;
    }

    public static void main(String[] args){
        getMainFrame();
    }
}
