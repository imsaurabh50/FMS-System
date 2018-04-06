import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class DatabaseManager {
    private static DatabaseManager DatabaseManager;
    private Database db;
    private DatabaseManager(){
        db = Database.getDatabase();
        db.makeDatabase();
    }

    public static DatabaseManager getDatabaseManager(){
        if(DatabaseManager == null){
            DatabaseManager = new DatabaseManager();
        }
        return DatabaseManager;
    }

    public boolean AddPersonReq(Person p){
        db.makeDatabase();
        boolean personIsthere = false;
        ArrayList<Person> pendingPersons = db.getPendingPersons();
        ArrayList<Person> persons = db.getPersons();
        for(Person p1:pendingPersons){
            if(p1.getUsername().equals(p.getUsername())){
                personIsthere = true;
                break;
            }
        }
        for(Person p1:persons){
            if(p1.getUsername().equals(p.getUsername())){
                personIsthere = true;
                break;
            }
        }
        if(personIsthere == false){
            pendingPersons.add(p);
            ReadWriteFiles.writePersonToPendingPersonFile(p);
            return true;
        }
        return false;
    }

    public boolean updateTask(Task t, ArrayList<Task> taskArray, String filename){
        boolean taskFound = false;
        int count = 0;
        for(Task t1:taskArray){
            if(t1.getTitle().equals(t.getTitle())){
                taskFound = true;
                taskArray.remove(count);
                taskArray.add(t);
                break;
            }
            count++;
        }
        if(taskFound){
            ReadWriteFiles.WriteToTaskDb(filename,taskArray);
            return true;
        }
        return false;
    }

    public void AddTask(Task t, ArrayList<Task> taskArray, String filename){
        taskArray.add(t);
        ReadWriteFiles.WriteToTaskDb(filename,taskArray);
    }

    public boolean updateLeaveReq(Leave l, ArrayList<Leave> leaves, String filename){
        boolean leavereqFound = false;
        int count = 0;
        for(Leave l1:leaves){
            if(l1.getLeaveTitle().equals(l.getLeaveTitle())){
                leavereqFound = true;
                leaves.remove(count);
                leaves.add(l);
                break;
            }
            count++;
        }
        if(leavereqFound){
            ReadWriteFiles.WriteToLeaveDb(filename,leaves);
            return true;
        }
        return false;
    }

    public boolean updateLogReq(LogReq l, ArrayList<LogReq> logReqs, String filename){
        boolean logReqFound = false;
        int count = 0;
        for(LogReq l1:logReqs){
            if(l1.getTitle().equals(l.getTitle())){
                logReqFound = true;
                logReqs.remove(count);
                logReqs.add(l);
                break;
            }
            count++;
        }
        if(logReqFound){
            ReadWriteFiles.WriteToLogDb(filename,logReqs);
            return true;
        }
        return false;
    }

}
