package com.hongJC;

import hongjiancheng.tojava.Deadline;
import hongjiancheng.tojava.Parser;
import hongjiancheng.tojava.TaskManagerException;
import hongjiancheng.tojava.ToDo;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class ParserTest {

    @Test
    public void getCommandWord() {
        assertEquals("todo", Parser.getCommandWord("todo lol"));
        assertEquals("deadline", Parser.getCommandWord("deadline dada"));
        assertEquals("print", Parser.getCommandWord("print"));
        assertEquals("", Parser.getCommandWord(""));
    }

    @Test
    public void createTodo() throws TaskManagerException {
        ToDo actual = Parser.createTodo("todo read book");
        ToDo expected= new ToDo("read book");
        assertEquals(expected.print(), actual.print());
    }

    @Test
    public void createDeadline() throws TaskManagerException {
        Deadline actual = Parser.createDeadline("deadline read book /by now");
        Deadline expected = new Deadline("read book", "now");
        assertEquals(expected.print(), actual.print());
    }
}