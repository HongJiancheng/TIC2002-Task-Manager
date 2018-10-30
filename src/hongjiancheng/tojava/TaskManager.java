package hongjiancheng.tojava;
import java.io.IOException;

public class TaskManager {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public TaskManager(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (TaskManagerException e) {
            ui.showToUser("Problem reading file. Starting with an empty task list");
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.printWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                ui.currentTime();
                for(int i=0;i<tasks.getTaskList().size();i++){
                    if(tasks.getTaskList().get(i).getClass()==(new Deadline()).getClass()){
                        ui.reminder((Deadline)tasks.getTaskList().get(i));
                    }
                }
                String fullCommand = ui.readUserCommand();
                String commandWord = Parser.getCommandWord(fullCommand);
                switch (commandWord) {
                    case "exit":
                    case "": // exit if user input is empty
                        isExit = true;
                        break;
                    case "todo":
                        tasks.addTask(Parser.createTodo(fullCommand));
                        ui.changed();
                        break;
                    case "deadline":
                        tasks.addTask(Parser.createDeadline(fullCommand));
                        ui.changed();
                        break;
                    case "remove":
                        tasks.removeTask(Parser.getIndex(fullCommand));
                        break;
                    case "print":
                        ui.showToUser(tasks.getDescription());
                        break;
                    case "done":
                        tasks.markAsDone(Parser.getIndex(fullCommand));
                        ui.changed();
                        break;
                    default:
                        ui.showToUser("Unknown command! please try again"+System.lineSeparator());
                        break;
                }
            } catch (TaskManagerException e) {
                ui.printError(e.getMessage());
            }
        }
        if(ui.status()){
            try{
                storage.save(tasks.getTaskList());
            } catch (IOException e) {
                ui.showToUser("File not found"+System.lineSeparator());
            }
            ui.showToUser("Changes are saved."+System.lineSeparator());
        }else{
            ui.showToUser("No change made."+System.lineSeparator());
        }
	    ui.printBye();
    }

    public static void main(String[] args) {
//        assert args.length > 0 :"No arguments";
        new TaskManager("data/tasks.txt").run();
    }
}
