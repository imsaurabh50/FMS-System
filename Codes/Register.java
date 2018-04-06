import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Register {
    private static Register Register;
    private JPanel registerCanvas;
    private MainFrame MainFrame;
    private DatabaseManager dbms;
    private JLabel msg;
    private JButton doRgister;
    private JButton exit;
    private Register(){
        this.msg = RegisterForm.getRegisterForm().getMsg();
        this.doRgister = RegisterForm.getRegisterForm().getDoRegister();
        this.exit = RegisterForm.getRegisterForm().getExit();
    }

    public static Register getRegister(){
        if(Register == null){
            Register = new Register();
        }
        return Register;
    }

    private boolean register(Person p){
        dbms = DatabaseManager.getDatabaseManager();
        boolean addedForApproval = dbms.AddPersonReq(p);
        if(addedForApproval){
            //REpaintRegisterScreen();
            return true;
        }
        else{
            msg.setText("User exists or has registered!");
            return false;
        }
    }

    public void paintRegisterScreen(){
        registerCanvas = RegisterForm.getRegisterForm().getRegisterCanvas();
        setUpButtons();
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(registerCanvas);
        MainFrame.setTitle("Register");
    }

    private void setUpButtons(){
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().dispose();
            }
        });

        doRgister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean typeSelected = false;
                boolean depSelected = false;
                String name = RegisterForm.getRegisterForm().name.getText();
                String username = RegisterForm.getRegisterForm().username.getText();
                String password = String.valueOf(RegisterForm.getRegisterForm().password.getPassword());
                String email = RegisterForm.getRegisterForm().email.getText();
                String type = "null";
                String dep = "null";
                if(!(RegisterForm.getRegisterForm().TypeGroup.getSelection()==null)){
                    if(RegisterForm.getRegisterForm().Staff.isSelected()){
                        type = "staff";
                    }
                    else{
                        type = "sup";
                    }
                    typeSelected = true;
                }
                if(!(RegisterForm.getRegisterForm().DepGroup.getSelection()==null)){
                    dep = getDep();
                    depSelected = true;
                }
                boolean safeCheck = checkCredentials(name,username,password,email,typeSelected,depSelected);
                if(safeCheck){
                    Person p = new Person(name,RegisterForm.getRegisterForm().IDgenerator(),username
                    ,password,email,type,dep,"free");
                    boolean hasregistered = register(p);
                    if(hasregistered){
                        msg.setText("User Registered!");
                    }
                }
            }
        });
    }

    private boolean checkCredentials(String name, String username, String password, String email, boolean typeselected, boolean depSelected){
        if(typeselected == false || depSelected == false ||
                name.equals("") || username.equals("") || password.equals("") ||
                email.equals("")){

            RegisterForm.getRegisterForm().name.setText("Enter Name!");
            RegisterForm.getRegisterForm().username.setText("Enter Username!");
            RegisterForm.getRegisterForm().password.setText("Enter Password!");
            RegisterForm.getRegisterForm().email.setText("Enter Email!");

            return false;
        }
        return true;
    }

    private String getDep(){
        RegisterForm rf = RegisterForm.getRegisterForm();
        if(rf.HVAC.isSelected()){
            return "HVAC";
        }
        else if(rf.elec.isSelected()){
            return "elec";
        }
        else if(rf.room.isSelected()){
            return "room";
        }
        else if(rf.media.isSelected()){
            return "media";
        }
        else{
            return "security";
        }
    }



//    public static void main(String[] args){
//        Register rg = Register.getRegister();
//        String s = rg.IDgenerator();
//        System.out.println(s);
//    }
}
