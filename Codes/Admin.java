/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Admin extends Person{

    private Supervisor ElecSup;
    private Supervisor HVACSup;
    private Supervisor MediaSup;
    private Supervisor SecuritySup;
    private Supervisor HouseKeepSup;
    private static MainFrame MainFrame;

    public Admin(String name, String UID, String username, String password, String email, String type,String dep, String status) {
        super(name, UID, username, password, email, type,dep,status);
    }

    public static void paintAdminAccount(){
        Person p = new Person("Admin","0000","admin","admin","admin@fms.com","Admin","all","busy");
        MainFrame = MainFrame.getMainFrame();
        MainFrame.setFrame(new AdminAccountPanel(p));
        MainFrame.setTitle(p.getName());
    }
}
