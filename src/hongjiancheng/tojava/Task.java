package hongjiancheng.tojava;

public class Task {
    protected String text;
    protected boolean isDone;
    public Task(){
        isDone=false;
    }
    public Task(String s){
        text=s;
        isDone=false;
    }
    public Task(String s, boolean isDone){
        text=s;
        this.isDone=isDone;
    }
    public String print(){
        return text;
    }
    public void setDone(boolean isDone){
        this.isDone=isDone;
    }
    public boolean getDone(){
        return isDone;
    }
    public String getText(){
        return text;
    }
}
