import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Database {
    private static Database Database;
    private ArrayList<Person> persons;
    private ArrayList<Person> pendingPersons;
    private ArrayList<Task> elecStaffTasks;
    private ArrayList<Task> roomStaffTasks;
    private ArrayList<Task> hvacStaffTasks;
    private ArrayList<Task> mediaStaffTasks;
    private ArrayList<Task> secStaffTasks;
    private ArrayList<Task> elecSupTasks;
    private ArrayList<Task> roomSupTasks;
    private ArrayList<Task> hvacSupTasks;
    private ArrayList<Task> mediaSupTasks;
    private ArrayList<Task> secSupTasks;
    private ArrayList<Leave> supLeaveReq;
    private ArrayList<Leave> staffLeaveReq;
    private ArrayList<LogReq> supLogReq;
    private ArrayList<LogReq> staffLogReq;

    public ArrayList<Person> getPendingPersons() {
        return this.pendingPersons;
    }

    public void makeDatabase(){
        this.persons = ReadWriteFiles.readAddedPersonfileMakePersonDb();
        this.pendingPersons = ReadWriteFiles.readAddReqPersonfileMakePendingPersonDb();
        this.elecStaffTasks = ReadWriteFiles.readTaskDb("elecStaffTaskDb.csv");
        this.roomStaffTasks = ReadWriteFiles.readTaskDb("houseStaffTaskDb.csv");
        this.hvacStaffTasks = ReadWriteFiles.readTaskDb("hvacStaffTaskDb.csv");
        this.mediaStaffTasks = ReadWriteFiles.readTaskDb("mediaStaffTaskDb.csv");
        this.secStaffTasks = ReadWriteFiles.readTaskDb("securityStaffTaskDb.csv");
        this.elecSupTasks = ReadWriteFiles.readTaskDb("elecSupTaskDb.csv");
        this.roomSupTasks = ReadWriteFiles.readTaskDb("houseSupTaskDb.csv");
        this.hvacSupTasks = ReadWriteFiles.readTaskDb("hvacSupTaskDb.csv");
        this.mediaSupTasks = ReadWriteFiles.readTaskDb("mediaSupTaskDb.csv");
        this.secSupTasks = ReadWriteFiles.readTaskDb("securitySupTaskDb.csv");
        this.supLeaveReq = ReadWriteFiles.readLeaveDb("SupLeaveReqDb.csv");
        this.staffLeaveReq = ReadWriteFiles.readLeaveDb("StaffLeavReqDb.csv");
        this.supLogReq = ReadWriteFiles.readLogDb("SupLogReqDb.csv");
        this.staffLogReq = ReadWriteFiles.readLogDb("StaffLogReqDb.csv");
    }

    public ArrayList<Person> getPersons(){
        return persons;
    }

    public ArrayList<Task> getElecStaffTasks() {
        return elecStaffTasks;
    }

    public ArrayList<Task> getRoomStaffTasks() {
        return roomStaffTasks;
    }

    public ArrayList<Task> getHvacStaffTasks() {
        return hvacStaffTasks;
    }

    public ArrayList<Task> getMediaStaffTasks() {
        return mediaStaffTasks;
    }

    public ArrayList<Task> getSecStaffTasks() {
        return secStaffTasks;
    }

    public ArrayList<Task> getElecSupTasks() {
        return elecSupTasks;
    }

    public ArrayList<Task> getRoomSupTasks() {
        return roomSupTasks;
    }

    public ArrayList<Task> getHvacSupTasks() {
        return hvacSupTasks;
    }

    public ArrayList<Task> getMediaSupTasks() {
        return mediaSupTasks;
    }

    public ArrayList<Task> getSecSupTasks() {
        return secSupTasks;
    }

    public ArrayList<LogReq> getSupLogReq() {
        return supLogReq;
    }

    public ArrayList<LogReq> getStaffLogReq() {
        return staffLogReq;
    }

    public ArrayList<Leave> getSupLeaveReq() {
        return supLeaveReq;
    }

    public ArrayList<Leave> getStaffLeaveReq() {
        return staffLeaveReq;
    }

    private Database(){}

    public static Database getDatabase(){
        if(Database == null){
            Database = new Database();
        }
        return Database;
    }

//    public static void main(String[] args){
//        Database db = new Database();
//        db.makeDatabase();
//        ArrayList<Person> persons = db.getPersons();
//        System.out.println(persons.get(0).getName());
//    }
}
