import java.io.*;
import java.util.ArrayList;

/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class ReadWriteFiles {

    public static ArrayList<Person> readAddedPersonfileMakePersonDb(){
        ArrayList<Person> Persons = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("personAddedInfo.csv"))){
            String[] temp;
            String LineToSplit;
            while((LineToSplit = reader.readLine()) != null){
                temp = LineToSplit.split(",");
                Person p = new Person(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]);
                Persons.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Persons;
    }

    public static ArrayList<Person> readAddReqPersonfileMakePendingPersonDb(){
        ArrayList<Person> pendingPersons = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("personAddReqInfo.csv"))){
            String[] temp;
            String LineToSplit;
            while((LineToSplit = reader.readLine()) != null){
                //System.out.println(LineToSplit);
                temp = LineToSplit.split(",");
                Person p = new Person(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7]);
                pendingPersons.add(p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pendingPersons;
    }

    public static ArrayList<Task> readTaskDb(String filename){
        ArrayList<Task> pendingTasks = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String[] temp;
            String LineToSplit;
            while((LineToSplit = reader.readLine()) != null){
                //System.out.println(LineToSplit);
                temp = LineToSplit.split(",");
                Task t = new Task(temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6]);
                pendingTasks.add(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pendingTasks;
    }

    public static void WriteToTaskDb(String filename,ArrayList<Task> tasks){
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(Task t:tasks){
                writer.println(t);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writePersonToPendingPersonFile(Person p){
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("personAddReqInfo.csv",true)))){
            writer.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Leave> readLeaveDb(String filename){
        ArrayList<Leave> Leaves = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String[] temp;
            String LineToSplit;
            while((LineToSplit = reader.readLine()) != null){
                //System.out.println(LineToSplit);
                temp = LineToSplit.split(",");
                Leave l = new Leave(temp[0],temp[1],temp[2],temp[3],temp[4]);
                Leaves.add(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Leaves;
    }

    public static void WriteToLeaveDb(String filename,ArrayList<Leave> leaves){
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(Leave l:leaves){
                writer.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteToLogDb(String filename,ArrayList<LogReq> logReqs){
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(LogReq l:logReqs){
                writer.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<LogReq> readLogDb(String filename){
        ArrayList<LogReq> logReqs = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String[] temp;
            String LineToSplit;
            while((LineToSplit = reader.readLine()) != null){
                //System.out.println(LineToSplit);
                temp = LineToSplit.split(",");
                LogReq l = new LogReq(temp[0],temp[1],temp[2],temp[3],temp[4]);
                logReqs.add(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logReqs;
    }
}
