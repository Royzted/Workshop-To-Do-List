import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class todolist
{
    public static void main (String [] args)
    {
        try {
            Scanner sc = new Scanner(System.in);
            int choice;
            ArrayList<String> tasks = new ArrayList<>();
            int index = 0, conf;
            String task;
            File file = new File("todolist.txt");

            if (file.exists()) {
            tasks.addAll(Files.readAllLines(Paths.get("todolist.txt")));
            tasks.remove(0);
                file.delete();
            }

            file.createNewFile();
            
            PrintWriter pw = new PrintWriter(file);

             do{
                 System.out.println("""

        ======TODO LIST======

        1.\tPut in a new task
        2.\tMark as done
        3.\tView whole list
        4.\tDelete task
        5.\tExit
        """);

        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine();

                switch(choice)
                {
                    case 1:
                        System.out.println("Enter your task");
                        task = sc.nextLine().trim();
                        tasks.add(task);
                        break;

                    case 2: 
                        for (String t : tasks) {
                            String cleanPrint = t.replaceFirst("^\\d+\\.\\s*","");
                            System.out.println((index + 1) + ".\t" + cleanPrint);
                            index++;
                        }
                        index = 0;
                        System.out.println("Which task do you want to mark?");
                        conf = sc.nextInt();
                        if (conf < 1 )
                        {
                            System.out.println("invalid number");
                        }else
                        {
                            tasks.set((conf-1), tasks.get(conf-1) + " (done)");
                        }
                        break;
                    
                    case 3:
                        for (String t : tasks) {
                            String cleanPrint = t.replaceFirst("^\\d+\\.\\s*","");
                            System.out.println((index + 1) + ".\t" + cleanPrint);
                            index++;
                        }
                        index = 0;
                        break;

                    case 4:
                        for (String t : tasks) {
                            String cleanPrint = t.replaceFirst("^\\d+\\.\\s*","");
                            System.out.println((index + 1) + ".\t" + cleanPrint);
                            index++;
                        }
                        index = 0;
                        System.out.println("Which task do you want to delete?");
                        conf = sc.nextInt();
                        tasks.remove(conf-1);
                        break;

                    case 5:
                        System.out.println("Goodbye!");
                        pw.println("=====TO DO LIST=====");
                        for (String t : tasks) {
                            String clean = t.replaceFirst("^\\d+\\.\\s*", "");
                            pw.println((index + 1) + ".\t" + clean);
                            index++;
                        }
                        index = 0;
                    
                        break;
                        

                    default:
                        System.out.println("Invalid number!");
                        break;
                }
    

        
            }while(choice != 5);
                pw.close();
            }
            catch(IOException e){
            
                System.out.println("Error: " + e);

            }
        
    }
}
