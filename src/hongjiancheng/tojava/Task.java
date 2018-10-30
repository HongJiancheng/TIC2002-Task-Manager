package hongjiancheng.tojava;

abstract public class Task {
    protected String text;
    public Task(){
    }
    public Task(String s){
        text=s;
    }
    public String print(){
        return text;
    }
    abstract public void setDone(boolean isDone);
    abstract public boolean getDone();
    public String getText(){
        return text;
    }
}
