package hongjiancheng.tojava;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.List;

public class Ui {
    private Date now;
    private boolean isChanged=false;
    public Ui(){}
    public void printWelcome(){
        System.out.println("Welcome to TaskManager!");
    }
    public void printBye(){System.out.println("Bye!");}
    public String readUserCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public void showToUser(String s){
        System.out.println(s);
    }
    public void printError(String s){
        System.out.println("Error: "+s);
    }
    public void changed(){
        isChanged=true;
    }
    public boolean status(){
        return isChanged;
    }
    public void reminder(Deadline deadline){
        now=new Date();
        long misDif = deadline.getDeadline().getTime()-now.getTime();
        int min = (int) Math.ceil(misDif/60000);
        if((misDif<=1800000) && !deadline.getDone()){
            if(min<0) {
                System.out.println("[REMINDER]");
                System.out.println("You have missed the deadline of Task:");
            }else if(min<=1){
                System.out.print("[REMINDER]" + System.lineSeparator()+ "There is ");
                System.out.print(min);
                System.out.println(" min left to the deadline of Task:");
            }else {
                System.out.print("[REMINDER]" + System.lineSeparator()+ "There are ");
                System.out.print(min);
                System.out.println(" mins left to the deadline of Task:");
            }
            System.out.println(deadline.getText());
        }
    }
    public void currentTime(){
        now=new Date();
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        System.out.println("Current Time: "+ time_formatter.format(now.getTime()));
    }
    public void saveCopy(Storage store, List<Task> tasks){
        store.save(tasks);
        showToUser("Changes are saved."+System.lineSeparator());
    }
    public void saveNow(Storage store, List<Task> changed){
        if(isChanged){
            saveCopy(store,changed);
        }else{
            showToUser("No change made."+System.lineSeparator());
        }
    }
    public void setPath(Storage store, String newPath){
        store.changePath(newPath);
    }
}
