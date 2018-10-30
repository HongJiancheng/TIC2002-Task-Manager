package hongjiancheng.tojava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    private Parser(){}
    public static String getCommandWord(String fullCommand){
        String command = fullCommand.split(" ")[0];
        return command;
    }
    public static int getIndex(String fullCommand){
        return Integer.parseInt(fullCommand.split(" ")[1]);
    }
    public static ToDo createTodo(String fullCommand) throws TaskManagerException {
        if(fullCommand.substring(5).isEmpty()){
            throw new TaskManagerException("Empty description for TODO");
        }
        return new ToDo(fullCommand.substring(5));
    }
    public static Date convertDeadline(String deadline) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd_HH:mm:ss");
        Date t;
        try {
            t = ft.parse(deadline);
            return t;
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
            return new Date();
        }
    }
    public static Deadline createDeadline(String fullCommand) throws TaskManagerException {
        String text=fullCommand.substring(9).split(" /by ")[0];
        String due=fullCommand.substring(9).substring(text.length()+5);
        Date dueDate=convertDeadline(due), now=new Date();
        if (text.isEmpty()){
            throw new TaskManagerException("Empty description for DEADLINE");
        }else if(!fullCommand.contains(" /by ")){
            throw new TaskManagerException("Missing keyword /by for DEADLINE");
        }else if(dueDate.compareTo(now)<0){
            throw new TaskManagerException("Deadline is passed");
        }
        return new Deadline(text, convertDeadline(due));
    }
}
