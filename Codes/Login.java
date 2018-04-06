import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Login {
    private static Login Login;
    private Database db;
    private JPanel loginCanvas;
    private JTextField username;
    private JTextField password;
    private MainFrame MainFrame;
    private JButton next;
    private JButton exit;
    private JLabel login;
    private JLabel msg;
    boolean userFound = false;
    public boolean login(String username, String password){
        db = Database.getDatabase();
        db.makeDatabase();
        if(username.equals("admin") && password.equals("admin")){
            Admin.paintAdminAccount();
            userFound = true;
            return true;
        }
        for(Person p:db.getPersons()){
            if(p.getUsername().equals(username)){
                userFound = true;
                if(p.getPassword().equals(password)) {
                    p.paintAccount();
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        for(Person p:db.getPendingPersons()){
            if(p.getUsername().equals(username)){
                userFound = true;
                if(p.getPassword().equals(password)){
                    //p.setType("null");
                    p.paintAccount();
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public void setMsg(String s){
        msg.setText(s);
    }

    public void paintLoginScreen(){
        loginCanvas = new JPanel();
        setLoginScreenProperties();
        setLoginScreenContent();
        setUpButtons();
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(loginCanvas);
        MainFrame.setTitle("Login");
    }

    private Login(){};

    public JPanel getLoginCanvas(){
        return this.loginCanvas;
    }

    public static Login getLogin(){
        if(Login == null){
            Login = new Login();
        }
        return Login;
    }

    private void setLoginScreenProperties(){
        loginCanvas.setBackground(Color.ORANGE);
        loginCanvas.setLayout(null);
    }

    private void setLoginScreenContent(){
        username = new JTextField("Enter Username");
        password = new JTextField("Enter Password");
        next = new JButton("Next");
        exit = new JButton("Exit");
        login = new JLabel("Login");
        msg = new JLabel();
        username.setBounds(700,300,300,50);
        username.setHorizontalAlignment(JTextField.CENTER);
        username.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        username.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                username.setText("");
            }
        });
        password.setBounds(700,400,300,50);
        password.setHorizontalAlignment(JTextField.CENTER);
        password.setFont(new Font(Font.MONOSPACED,Font.PLAIN,20));
        password.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                password.setText("");
            }
        });
        next.setBounds(700,525,300,50);
        next.setFont(new Font(Font.MONOSPACED,Font.PLAIN,25));
        next.setHorizontalAlignment(JButton.CENTER);
        next.setBackground(Color.CYAN);
        exit.setBounds(700,600,300,50);
        exit.setFont(new Font(Font.MONOSPACED,Font.PLAIN,25));
        exit.setHorizontalAlignment(JButton.CENTER);
        exit.setBackground(Color.PINK);
        login.setHorizontalAlignment(JLabel.CENTER);
        login.setFont(new Font(Font.MONOSPACED,Font.PLAIN,80));
        login.setBounds(700,100,300,90);
        msg.setBounds(700,700,500,50);
        msg.setFont(new Font(Font.MONOSPACED,Font.PLAIN,30));

        loginCanvas.add(username);
        loginCanvas.add(password);
        loginCanvas.add(next);
        loginCanvas.add(exit);
        loginCanvas.add(login);
        loginCanvas.add(msg);
    }

    private void setUpButtons(){
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("pressed");
                String Username = username.getText();
                String Password = password.getText();
                msg.setText("");
                if(Username.equals("") || Password.equals("")){
                    username.setText("Please enter username");
                    password.setText("Please enter password");
                }
                else{
                    boolean f = login(Username,Password);
                    if(f == false && userFound == true ){
                        msg.setText("Invalid Credentials!");
                    }
                    else if(f == false && userFound == false){
                        msg.setText("No such user found!");
                    }
                    else if(f==true){
                        msg.setText("Logged In!");
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().dispose();
            }
        });
    }
}
