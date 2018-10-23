package hongjiancheng.tojava;

import java.util.Scanner;

public class Ui {
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
}
