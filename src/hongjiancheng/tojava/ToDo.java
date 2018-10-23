package hongjiancheng.tojava;

public class ToDo extends Task {
    public ToDo(){
        super();
    }
    public ToDo(String s){
        super(s);
    }
    public ToDo(String s, boolean isDone){
        super(s,isDone);
    }
    public String print(){
        if(isDone) {
            return super.print() + System.lineSeparator() + "     is done? " + "Yes";
        }else{
            return super.print() + System.lineSeparator() + "     is done? " + "No";
        }
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
}
