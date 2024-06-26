package poe5121_final;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Tasks {
    
    private String taskName;
    private String description;
    public static int arrTaskNumber = 0;
    public static int taskNumber = -1;
    private String developer;
    private double numTasks; 
    public static double totalTasks = 0;
    private String TaskID;
    private String Status;

    public Tasks(String taskName, String description, String developer, double numTasks, String Status) {
        this.taskName = taskName;
        this.description = description;
        this.developer = developer;
        this.numTasks = numTasks;
        this.Status = Status;
    }
    
    public Tasks(){}
    
    

 // create arrays to hold transaction values 
    static String[] arrTaskName;  // contains the names of all the tasks
    static String[] arrDeveloper ; // contains the names of all the developers
    static String[] arrTaskID  ; // contains the generated task ID's for all tasks
    static double[] arrNumTasks; // contains the amounts of all task hours
    static String[] arrStatus; // contains the status of all tasks
    static String[] arrDescription; //contains the description of all tasks
    
    //Used to reset total hours to zero when starting new 'Add task'
    public static void setTotalTasks(double totalTasks) {
        Tasks.totalTasks = totalTasks;
    }
        
    //Unit testing purposes
    public static void setTaskNumber(int taskNumber) {
        Tasks.taskNumber = taskNumber;
    }
        
   
    
    //Asks user questions to capture relevent data when making a task
    public void taskDetails(String firstName, String lastName)
    {
        try {
        String task = JOptionPane.showInputDialog(null, "Plese enter the number of tasks you want to make");
                   int Tasks = Integer.parseInt(task);
        
        double total = 0;
        boolean inputValid = false;
        arrDeveloper = new String[Tasks];
        arrTaskName = new String[Tasks];
        arrTaskID = new String[Tasks];
        arrNumTasks = new double[Tasks];
        arrStatus = new String[Tasks];  
        arrDescription = new String[Tasks];
                   
                   
                   
        //for loop to make sure user only fills in deatils for the number of tasks they set above
        for (int i=0; i < Tasks; i++)
        { 
            taskName = JOptionPane.showInputDialog(null, "Plese enter the task's name " + (i+1));
            //Task name must be there and must have 3 or more characters
            if (!checkTaskName(taskName)) {
                do {
                JOptionPane.showMessageDialog(null, "Error! Please enter 3 characters or more");
                 taskName = JOptionPane.showInputDialog(null, "Plese enter the task's name " + (i+1));
                 arrTaskName[i] = taskName;
                inputValid = true;
                }while (!checkTaskName(taskName));
            }
            
            else{
                arrTaskName[i] = taskName;
                inputValid = true;
            }
            
            description = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s descrption " + (i+1));
            //Description must'nt be blank and must be 50 charcters or less
            if (!checkTaskDescription(description)) {
                do {
                JOptionPane.showMessageDialog(null, "Error! Please enter 50 characters or less");
                 description = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s descrption " + (i+1));
                 arrDescription[i] = description;
                 inputValid = true;
                }while (!checkTaskDescription(description));
            }
            
            else{
              arrDescription[i] = description;
              inputValid = true;
            }
            
            developer = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s developer " + (i+1));
            if (!developer.matches(".*[A-Z].*" + " " + ".*[A-Z].*") || !developer.matches(".*[a-z].*" + " " + ".*[a-z].*")) {
                do{
                JOptionPane.showMessageDialog(null, "Error! Please enter name and surname in small and big letters");
                developer = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s developer " + (i+1));
                arrDeveloper[i] = developer;
                inputValid = true;
                }while (!developer.matches(".*[A-Z].*" + " " + ".*[A-Z].*") || !developer.matches(".*[a-z].*" + " " + ".*[a-z].*"));
            }
            else {
           arrDeveloper[i] = developer;
            inputValid = true;
            }
            
           
            //Hours for task contributes to accumulator
            String amount = JOptionPane.showInputDialog(null, "Plese enter " + taskName + "'s duration " + (i+1));
                numTasks = Integer.parseInt(amount);
                arrNumTasks[i] = numTasks;
                
             int option = 0;
             
             ImageIcon icon = new ImageIcon("To Do, Doing, Done.png");
            
             String[] options = {"To Do", "Doing", "Done"};
             option = JOptionPane.showOptionDialog(null,
             null,
             "Please select" + taskName + "'s status:",
             WindowConstants.DISPOSE_ON_CLOSE,
             JOptionPane.PLAIN_MESSAGE,
             icon,
             options,
             options[0]);
             String statuses = options[option];
             arrStatus[i] = statuses;
             
             
             
             Tasks deets = new Tasks( taskName,  description,  developer,  numTasks,  Status);
                   //Impliment's method
                retrieveStatus(option);
                
                arrTaskID[i] = deets.createTaskID(taskName, developer);
                taskNumber--;
                printTaskDetails();
            //The pop-up box for total return hours of all tasks
                JOptionPane.showMessageDialog(null,"Total amount of Task hours: "+ ReturnTotalHours());
            
          }
        }catch (NumberFormatException n) {    
              JOptionPane.showMessageDialog(null,"Invalid value, please enter a number ");
              taskNumber = -1;
         }
 
    }
    
    //Accumulator for total hours of all tasks
    public double ReturnTotalHours()
    {
            totalTasks += numTasks;
            return totalTasks;
    }
    
    //Method to generate each tasks ID
    public String createTaskID(String taskName, String developer) {
        
        this.taskName = taskName;
        this.developer = developer;
        taskNumber++;
        
        String id = taskName.substring(0, 2).toUpperCase();
        String id2 = developer.substring(developer.length()-3).toUpperCase();
        TaskID = id + ":" + taskNumber + ":" + id2;
        return TaskID;  
    }
     
    //Method to check that task description is 50 characters long or less and not blank
     public boolean checkTaskDescription(String description) 
    {
        if(description.length() <= 50 && !description.isBlank())
        {
            return true;
        }
        
        else {
            return false;
        }
    }
     
     //Method to check that task name is 3 characters long or more and not blank
     public boolean checkTaskName(String taskName) 
    {
        if(taskName.length() >= 3 && !taskName.isBlank())
        {
            return true;
        }
        else {
            return false;
        }
    }


    //Method prints all the details regarding each task. 1 pop up box = 1 task
    public String printTaskDetails() {
       
        //Designing my pop up box content
        StringBuilder display = new StringBuilder();
        for (int i=0; i <= arrTaskNumber; i++) {
        //append, toString...
        display.append("Task Name: ").append(taskName);
        display.append("\nTask Description: ").append(description);
        display.append("\nDeveloper Details: ").append(developer);
        display.append("\nTask Duration: ").append(numTasks);
        display.append("\nTask ID: ").append(createTaskID(taskName, developer));
        display.append("\nTask Status: ").append(Status);
        JOptionPane.showMessageDialog(null, display.toString());
        }
        return display.toString();
    }
    
    //Method  
    public String retrieveStatus(int option)
    { 
        
              switch (option) {
                case 0:
                   Status = "To Do"; 
                break;
                
                case 1:
                    Status = "Doing"; 
                break;
                
                case 2:
                    Status = "Done";
    }
              return  Status;// return status
    }
    
    public String displayReport() {
        
        //Designing my pop up box content
        StringBuilder display = new StringBuilder();
        for (int i=0; i <= taskNumber; i++) {
          
        //append, toString...
        display.append("Task Name: ").append(arrTaskName[i]);
        display.append("\nDesctiption: ").append(arrDescription[i]);
        display.append("\nDeveloper Details: ").append(arrDeveloper[i]);
        display.append("\nTask Duration: ").append(arrNumTasks[i]);
        display.append("\nTask ID: ").append(arrTaskID[i]);
        display.append("\nTask Status: ").append(arrStatus[i]).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, display.toString());
        return display.toString();
    }
    
     public String displayLongestTask() {
        double maxDuration = 0;
        StringBuilder message = new StringBuilder("Task/s:\n");

        // First loop to find the max duration
        for (int i = 0; i < arrNumTasks.length; i++) {
            if (arrNumTasks[i] > maxDuration) {
                maxDuration = arrNumTasks[i];
            }
        }

        // Second loop to collect tasks with the max duration
        for (int i = 0; i < arrNumTasks.length; i++) {
            if (arrNumTasks[i] == maxDuration) {
                message.append("Developer: ").append(arrDeveloper[i])
                       .append("\nDuration: ").append(arrNumTasks[i]).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, message.toString(), "The Longest Duration/s", JOptionPane.INFORMATION_MESSAGE);
        return message.toString();
     }

    
    public boolean SearchTaskNames(String searchValue)
{
    boolean found = false; 
                    
    //Designing my pop up box content
    StringBuilder display = new StringBuilder();
    for (int i =0; i <= taskNumber; i++)
    {
        //Matches
        if (arrTaskName[i].equalsIgnoreCase(searchValue))
        {
        //append, toString...
        display.append("Task Name: ").append(arrTaskName[i]);
        display.append("\nDesctiption: ").append(arrDescription[i]);
        display.append("\nDeveloper Details: ").append(arrDeveloper[i]);
        display.append("\nTask Duration: ").append(arrNumTasks[i]);
        display.append("\nTask ID: ").append(arrTaskID[i]);
        display.append("\nTask Status: ").append(arrStatus[i]).append("\n\n");
        JOptionPane.showMessageDialog(null, display.toString());
        found = true; // the value was found 
        }
    }
    // if value was not found >> tell the user to try again 
    if (!found){ JOptionPane.showMessageDialog(null, "Task name not found. Please try again");}
    return found;
}
    
     public boolean SearchDevelopers(String searchValue2)
{
    boolean found = false; 
                    
    //Designing my pop up box content
    StringBuilder display = new StringBuilder();
    for (int i =0; i <= taskNumber; i++)
    {
        //Matches
        if (arrDeveloper[i].equalsIgnoreCase(searchValue2))
        {
        //append, toString...
        display.append("Task Name: ").append(arrTaskName[i]);
        display.append("\nDesctiption: ").append(arrDescription[i]);
        display.append("\nDeveloper Details: ").append(arrDeveloper[i]);
        display.append("\nTask Duration: ").append(arrNumTasks[i]);
        display.append("\nTask ID: ").append(arrTaskID[i]);
        display.append("\nTask Status: ").append(arrStatus[i]).append("\n\n");
        JOptionPane.showMessageDialog(null, display.toString());
        found = true; // the value was found 
        }
    }
    // if value was not found >> tell the user to try again 
    if (!found){ JOptionPane.showMessageDialog(null, "Task developer not found. Please try again");}
    return found;
}
     
     public boolean RemoveTask(String removeValue) {
                
    String[] temparAarrDeveloper = new String[taskNumber+1]; 
    // contains the Developer names
    String[] tempArrTaskName = new String[taskNumber+1]; 
    // contains the Task names 
    String[] tempArrTaskID = new String[taskNumber+1]; 
    // contains the generated Task IDs
    double[] tempArrNumTasks = new double[taskNumber+1];
    // contains the Durations
    String[] tempArrStatus = new String[taskNumber+1]; 
    // contains the status
    String[] tempArrDescription = new String[taskNumber+1];
    //contains description
    
    int j= 0; 
    
    boolean removed = false; 
    // variable to keep track of if the task was removed or not 
    
   
    // run a loop for all tasks entered by the user
    for (int i =0; i <= taskNumber; i++)
    {
        // if the task name of this transaction does NOT matches the task name 
        if (!(arrTaskName[i].equalsIgnoreCase(removeValue)))
        {
            // store each of the values for this task in the respective temporary arrays for 
            // later use
        tempArrNumTasks[j] = arrNumTasks[i];
        tempArrTaskID[j] = arrTaskID[i];
        tempArrTaskName[j] = arrTaskName[i];
        tempArrStatus[j] = arrStatus[i];
        temparAarrDeveloper[j] = arrDeveloper[i];
        tempArrDescription[j] = arrDescription[i];
        j++; // add 1 to j since a value was added not removed 
        
        }
       // if the task name of this task matches the task name
        else { removed = true;}
    }

    // if no value was removed then ask user to try again 
    if (!removed){ 
        JOptionPane.showMessageDialog(null, "Transaction could not be removed. Please try again");
        
    }
    else { // a value was removed from the arrays 
      
        
      arrNumTasks = tempArrNumTasks;
      arrDeveloper = temparAarrDeveloper;
      arrTaskID = tempArrTaskID;
      arrTaskName = tempArrTaskName;
      arrStatus = tempArrStatus;
      arrDescription = tempArrDescription;
      // tell the user that the value was removed successfully 
      JOptionPane.showMessageDialog(null, "Transaction removed successfully.");
      // decrease the task number since one transaction was removed 
      taskNumber--;
    }
    return removed;
}
    
}