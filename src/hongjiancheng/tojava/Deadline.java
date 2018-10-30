package hongjiancheng.tojava;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Deadline extends ToDo{
    private Date deadline;
    public Deadline(){
        super();
    }
    public Deadline(String s){
        super(s);
    }
    public Deadline(String s, boolean isDone){
        super(s,isDone);
    }
    public Deadline(String s, Date deadline){
        super(s);
        this.deadline=deadline;
    }
    public Deadline(String s, boolean isDone, Date deadline){
        super(s,isDone);
        this.deadline=deadline;
    }
    public String print(){
        return super.print()+System.lineSeparator()+"     do by: "+getDue();
    }
    public void setDone(boolean isDone){
        super.setDone(isDone);
    }
    public boolean getDone(){
        return super.getDone();
    }
    public Date getDeadline(){
        return this.deadline;
    }
    public String getText(){
        return super.getText();
    }
    public String getDue(){
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        return time_formatter.format(deadline.getTime());
    }
}
