/**
 * Created by Saurabh Kumar on 28-11-2016.
 */
public class Task {
    private String Deadline;
    private String AssignTo;
    private String AssignP_Type;
    private String Dep;
    private String title;
    private String Msg;
    private String status;

    public Task(String deadline, String assignTo, String assignP_Type, String dep, String title, String msg, String status) {
        this.Deadline = deadline;
        this.AssignTo = assignTo;
        this.AssignP_Type = assignP_Type;
        this.Dep = dep;
        this.title = title;
        this.Msg = msg;
        this.status = status;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getAssignTo() {
        return AssignTo;
    }

    public void setAssignTo(String assignTo) {
        AssignTo = assignTo;
    }

    public String getAssignP_Type() {
        return AssignP_Type;
    }

    public void setAssignP_Type(String assignP_Type) {
        AssignP_Type = assignP_Type;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String dep) {
        Dep = dep;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return Deadline + "," +
                AssignTo + "," +
                AssignP_Type + "," +
                Dep + "," +
                title + "," +
                Msg+","+status;
    }
}
