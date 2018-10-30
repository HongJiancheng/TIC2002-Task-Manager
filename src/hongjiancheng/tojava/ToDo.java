package hongjiancheng.tojava;

public class ToDo extends Task {
    protected boolean isDone;
    public ToDo(){
        super();
    }
    public ToDo(String s){
        super(s);
    }
    public ToDo(String s, boolean isDone){
        super(s);
        this.isDone=isDone;
    }
    public String print(){
        if(isDone) {
            return super.print() + System.lineSeparator() + "     is done? " + "Yes";
        }else{
            return super.print() + System.lineSeparator() + "     is done? " + "No";
        }
    }
    public void setDone(boolean isDone){
        this.isDone=isDone;
    }
    public boolean getDone(){
        return this.isDone;
    }
    public String getText(){
        return super.getText();
    }
}
