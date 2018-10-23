package hongjiancheng.tojava;

public class Deadline extends ToDo{
    private String deadline;
    public Deadline(){
        super();
    }
    public Deadline(String s){
        super(s);
    }
    public Deadline(String s, boolean isDone){
        super(s,isDone);
    }
    public Deadline(String s, String deadline){
        super(s);
        this.deadline=deadline;
    }
    public Deadline(String s, boolean isDone, String deadline){
        super(s,isDone);
        this.deadline=deadline;
    }
    public String print(){
        return super.print()+System.lineSeparator()+"     do by: "+deadline;
    }
    public void setDone(boolean isDone){
        super.setDone(isDone);
    }
    public boolean getDone(){
        return super.getDone();
    }
    public String getText(){
        return super.getText();
    }
    public String getDue(){
        return deadline;
    }
}
