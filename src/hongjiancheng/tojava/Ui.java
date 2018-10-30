package hongjiancheng.tojava;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ui {
    private Date now;
    private boolean isChanged=false;
    public Ui(){}
    public void printWelcome(){
        System.out.println("Welcome to TaskManager-Level6!");
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
    public void currentTime(){
        now=new Date();
        SimpleDateFormat time_formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        System.out.println("Current Time: "+ time_formatter.format(now.getTime()));
    }
}
