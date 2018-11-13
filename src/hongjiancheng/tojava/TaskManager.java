package hongjiancheng.tojava;
import java.io.FileNotFoundException;
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
        }
    }

    public void run() {
        ui.printWelcome();

        boolean isExit = false;
        while (!isExit) {
            try {
                ui.currentTime();
                if(tasks.getTaskList().isEmpty()){
                    ui.showToUser("There is no record, please add your tasks!"+System.lineSeparator());
                } else {
                    for (int i = 0; i < tasks.getTaskList().size(); i++) {
                        if (tasks.getTaskList().get(i).getClass() == (new Deadline()).getClass()) {
                            ui.reminder((Deadline) tasks.getTaskList().get(i));
                        }
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
                        ui.changed();
                        break;
                    case "print":
                        ui.showToUser(tasks.getDescription());
                        break;
                    case "done":
                        tasks.markAsDone(Parser.getIndex(fullCommand));
                        ui.changed();
                        break;
                    case "save":
                        ui.saveNow(storage,tasks.getTaskList());
                        break;
                    case "saveTo":
                        ui.setPath(storage,Parser.getPath(fullCommand));
                        ui.saveCopy(storage,tasks.getTaskList());
                        break;
                    case "loadFrom":
                        ui.setPath(storage,Parser.getPath(fullCommand));
                        try {
                            tasks = new TaskList(storage.load());
                        } catch (TaskManagerException e) {
                            ui.showToUser("Problem reading file. Starting with an empty task list");
                        }
                        break;
                    default:
                        ui.showToUser("Unknown command! please try again"+System.lineSeparator());
                        break;
                }
            } catch (TaskManagerException e) {
                ui.printError(e.getMessage());
            }
        }
        ui.saveNow(storage,tasks.getTaskList());
	    ui.printBye();
    }

    public static void main(String[] args) {
        new TaskManager("/data/tasks.txt").run();
    }
}
