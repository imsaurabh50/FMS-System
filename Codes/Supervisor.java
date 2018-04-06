import java.io.File;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Supervisor extends Person{

    private Department department;
    private File database;

    public Supervisor(String name, String UID, String username, String password, String email, String type, String dep,String status, Department department) {
        super(name, UID, username, password, email, type,dep,status);
        this.department = department;
        this.database = department.getDatabaseFile();
    }
}
