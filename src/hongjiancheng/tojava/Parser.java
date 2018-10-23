package hongjiancheng.tojava;

public class Parser {
    private Parser(){}
    public static String getCommandWord(String fullCommand){
        String command = fullCommand.split(" ")[0];
        return command;
    }
    public static ToDo createTodo(String fullCommand) throws TaskManagerException {
        if(fullCommand.substring(5).isEmpty()){
            throw new TaskManagerException("Empty description for TODO");
        }
        return new ToDo(fullCommand.substring(5));
    }
    public static Deadline createDeadline(String fullCommand) throws TaskManagerException {
        String text=fullCommand.substring(9).split(" /by ")[0];
        String due=fullCommand.substring(9).substring(text.length()+5);
        if (text.isEmpty()){
            throw new TaskManagerException("Empty description for DEADLINE");
        }else if(!fullCommand.contains(" /by ")){
            throw new TaskManagerException("Missing keyword /by for DEADLINE");
        }
        return new Deadline(text, due);
    }
}
