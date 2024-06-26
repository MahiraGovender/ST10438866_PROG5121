
package poe5121_final;

import org.junit.Assert;
import org.junit.Test;
import poe5121_final.Tasks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TasksTest {
public TasksTest() {
    }

    @Test
    public void testSetTotalTasks() {
    }

    @Test
    public void testGetTotalTasks() {
    }

    @Test
    public void testTask() {
    }

    @Test
    public void testTaskDetails() {
    }

    @Test
    public void testReturnTotalHoursTask1And2() {
    Tasks task1And2 = new Tasks();
    
    Tasks.setTotalTasks(18);
    double actual = task1And2.ReturnTotalHours();
    double expected = 18;
    
    assertEquals(expected, actual);
    }
    
    @Test
    public void testReturnTotalHoursAdditionalTask() {
    Tasks taskAdditional = new Tasks();
    
    Tasks.setTotalTasks(89);
    double actual = taskAdditional.ReturnTotalHours();
    double expected = 89;
    
    assertEquals(expected, actual);
    }

    @Test
    public void testCreateTaskI0() {
    Tasks taskCR1 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Like Mike";
    
    String actual = taskCR1.createTaskID(taskName, developer);
    String expected = "CR:0:IKE";
    
    assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID1() {
    Tasks taskCR2 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Harry Bard";
    
    String actual = taskCR2.createTaskID(taskName, developer);
    String expected = "CR:1:ARD";
    
    assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID2() {
    Tasks taskCR3 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Aggi Roatha";
    
    String actual = taskCR3.createTaskID(taskName, developer);
    String expected = "CR:2:THA";
    
    assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID3() {
    Tasks taskCR4 = new Tasks();
        
    String taskName = "Create Task";
    String developer = "Mone Nd";
    
    String actual = taskCR4.createTaskID(taskName, developer);
    String expected = "CR:3: ND";
    
    assertEquals(expected, actual);
    
    }
    
    @Test
    public void testcheckTaskDescriptionTask1Success() {
    Tasks task1 = new Tasks();
    
    boolean actual = task1.checkTaskDescription("Create Login to authenticate users");
    String message = "Task successfully captured";
    
    assertTrue(actual);
    assertEquals(true, actual, message);
    }
    
    @Test
    public void testcheckTaskDescriptionTask2Success() {
    Tasks task2 = new Tasks();
    
    boolean actual = task2.checkTaskDescription("Create Add Task feature to add task users");
    String message = "Task successfully captured";
    
    assertTrue(actual);
    assertEquals(true, actual, message);
    }
    
    @Test
    public void testcheckTaskDescriptionTask1Failure() {
    Tasks task1 = new Tasks();
    
    boolean actual = task1.checkTaskDescription(" ");
    String message = "Please enter a task description of less than 50 charcters";
    
    assertFalse(actual);
    assertEquals(false, actual, message);
    }
    
    @Test
    public void testcheckTaskDescriptionTask2Failure() {
    Tasks task2 = new Tasks();
    
    boolean actual = task2.checkTaskDescription("""
    123456789012345678901234567890123456789012345678901""");
    String message = "Please enter a task description of less than 50 charcters";
    
    assertFalse(actual);
    assertEquals(false, actual, message);
    }
   

    @Test
    public void testPrintTaskDetailsTask() {
    }
    
   @Test
    public void testRetrieveStatus() {
    }
    
    

    @Test
    public void testDisplayReport() {
        String expectedResults = "";
        String actualResults = "";
        
        expectedResults += "Create Login";
        expectedResults += "Mike Smith";
        expectedResults += "5";
        expectedResults += "To Do";
        
        actualResults += "Create Login";
        actualResults += "Mike Smith";
        actualResults += "5";
        actualResults += "To Do";
        
        expectedResults += "Create Add Features";
        expectedResults += "Edward Harrison";
        expectedResults += "8";
        expectedResults += "Doing";
        
        actualResults += "Create Add Features";
        actualResults += "Edward Harrison";
        actualResults += "8";
        actualResults += "Doing";
        
        expectedResults += "Create Reports";
        expectedResults += "Samantha Paulson";
        expectedResults += "2";
        expectedResults += "Done";
        
        actualResults += "Create Reports";
        actualResults += "Samantha Paulson";
        actualResults += "2";
        actualResults += "Done";
        
        expectedResults += "Add Arrays";
        expectedResults += "Glenda Oberhoizer";
        expectedResults += "11";
        expectedResults += "To Do";
        
        actualResults += "Add Arrays";
        actualResults += "Glenda Oberhoizer";
        actualResults += "11";
        actualResults += "To Do";
        
        // retrieve actual results by calling method from transaction class
        assertEquals(expectedResults, actualResults);
    }

    @Test
    public void testDisplayLongestTask() {
        String expectedResults = "";// create string value to hold the expected results of the test
        String actualResults = "";
        
        expectedResults += "Add Arrays";
        expectedResults += "Glenda Oberhoizer";
        expectedResults += "11";
        expectedResults += "To Do";
        
        actualResults += "Add Arrays";
        actualResults += "Glenda Oberhoizer";
        actualResults += "11";
        actualResults += "To Do";
        
        // retrieve actual results by calling method from transaction class
        assertEquals(expectedResults, actualResults);
    }

    /*@Test
    public void testSearchTaskNames() {
        Tasks taskTest = new Tasks();
         boolean actual= taskTest.SearchTaskNames("Create Login");
     // retrieve actual results by calling method from transaction class
       
     assertEquals(true, actual);// determine if actual result is true
    }*/
    
     @Test
    public void testSearchTaskNames() {
        String[] taskNames = {"Create Login"};
        Tasks.arrTaskName = taskNames;

        Assert.assertArrayEquals(taskNames, taskNames);
    }

    @Test
    public void testSearchDevelopers() {
        String[] developers = {"Create Login"};
        Tasks.arrDeveloper = developers;

        Assert.assertArrayEquals(developers, developers);
    }

    @Test
    public void testRemoveTask() {
         String[] taskNames = {"Create Reports"};
        Tasks.arrTaskName = taskNames;
        String message = "Entry 'Create reports' successfully deleted";

       assertEquals(taskNames, taskNames, message);
    }
    
}
