/**
 * Created by Saurabh Kumar on 29-11-2016.
 */
public class LogReq {
    String msg;
    String dep;
    String requestiType;
    String status;
    String title;

    public LogReq(String msg, String dep, String requestiType, String status, String title) {
        this.msg = msg;
        this.dep = dep;
        this.requestiType = requestiType;
        this.status = status;
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getRequestiType() {
        return requestiType;
    }

    public void setRequestiType(String requestiType) {
        this.requestiType = requestiType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return msg + "," + dep + "," +
                requestiType + "," +
                status + "," +
                title;
    }
}
