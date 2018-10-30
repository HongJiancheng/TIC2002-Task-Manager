package hongjiancheng.tojava;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static List<Task> tasks;
    public TaskList(){

    }
    public TaskList(List<Task> input) throws TaskManagerException{
        if(input.isEmpty()){
            throw new TaskManagerException("Empty String");
        }
        tasks=input;
    }
    public static void addTask(Task t) {
        tasks.add(t);
        System.out.println("Tasks in the list: "+tasks.size());
    }
    public static void removeTask(int i){
        tasks.remove(i-1);
        System.out.println("Tasks in the list: " + tasks.size());
    }
    public static String getDescription(){
        List<String> out = new ArrayList<>();
        for(int i=0;i<tasks.size();i++) {
            if(i==0) {
                out.add("[" + (i + 1) + "] " + tasks.get(i).print());
            }else{
                out.add(out.get(i-1)+System.lineSeparator()+"[" + (i + 1) + "] " + tasks.get(i).print());
            }
        }
        return out.get(out.size()-1);
    }
    public static void markAsDone(int index) {
        tasks.get(index - 1).setDone(true);
        System.out.println("Tasks in the list: " + tasks.size());
    }
    public static List<Task> getTaskList(){
        return tasks;
    }

}
