/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class Leave {
    private String from;
    private String to;
    private String why;
    private String status;
    private String leaveTitle;

    public Leave(String from, String to, String why, String status, String title) {
        this.from = from;
        this.to = to;
        this.why = why;
        this.status = status;
        this.leaveTitle = title;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLeaveTitle() {
        return leaveTitle;
    }

    public void setLeaveTitle(String leaveTitle) {
        this.leaveTitle = leaveTitle;
    }

    @Override
    public String
    toString() {
        return from + "," +
                to + "," + why + "," +
                status;
    }
}
