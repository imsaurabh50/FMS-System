import java.io.File;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Department {
    private final String name;
    private final File databaseFile;
    private Supervisor supervisor;

    File getDatabaseFile(){
        return this.databaseFile;
    }

    Department(String depName, String fileName, Supervisor supervisor){
        this.databaseFile = new File(fileName);
        this.supervisor = supervisor;
        this.name = depName;
    }

}
