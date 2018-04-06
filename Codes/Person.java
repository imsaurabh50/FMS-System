import javax.swing.*;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Person {
    protected String name;
    protected String UID;
    protected String username;
    protected String password;
    protected String email;
    protected String type = "null";
    protected String dep = "null";
    protected String status;
    private MainFrame MainFrame;
    //protected personAccount personAccount;

    public Person(String name, String UID, String username, String password, String email, String type, String dep, String status) {
        this.name = name;
        this.UID = UID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
        this.dep = dep;
        this.status = status;
//        if(!type.equals("sup")) {
//            this.personAccount = new StaffAccountPanel(this);
//        }
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public String getName() {
        return name;
    }

    public String getUID() {
        return UID;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void paintAccount(){
        if(this.type.equals("staff")) {
            MainFrame = MainFrame.getMainFrame();
            MainFrame.setFrame(new StaffAccountPanel(this));
            MainFrame.setTitle(this.getName());
        }
        else if(this.getType().equals("Admin")){
            Admin.paintAdminAccount();
        }
        else{
            MainFrame = MainFrame.getMainFrame();
            MainFrame.setFrame(new SupAccountPanel(this));
            MainFrame.setTitle(this.getName());
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "" +
                name + "," +
                UID + "," +
                username + "," +
                password + "," +
                email + "," +
                type+ "," +
                dep;
    }

    public String getDep() {
        return dep;

    }
}
