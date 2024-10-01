package mdi;
import customer.Student;
import java.util.Scanner;
import moes.Moes;
import product.Media;


public class Main{
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running;

    private void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Student name? ");
        String name = sc.nextLine();
        System.out.print("Student ID? ");
        int id = sc.nextInt();
        System.out.println("Student email? ");
        String email = sc.nextLine();
        System.out.print("(a)lacarte or (u)nlimited? ");
        String type = sc.nextLine();
        boolean unlimited;
        if(type.startsWith("a")){
            unlimited = false;
        }
        else{
            unlimited = true;
        }
        Student student = new Student(name, id, email, unlimited);
        moes.addStudent(student);
        System.out.println(menu);
        output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        output+="Added Student "+ student;
        output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        
    }
    private void listStudents(){ 
        System.out.println(menu);
        output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        output+= moes.getStudentList();
        output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";     
       
    }
    private void addMedia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Title? ");
        String title = sc.nextLine();
        System.out.println("URL? ");
        String url = sc.nextLine();
        System.out.println("Points? ");
        int points = sc.nextInt();
        Media media = new Media(title, url, points);
        moes.addMedia(media);
        System.out.println(menu);
        output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        output+= "Added media "+ media ;
        output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";

        
    }
    private void listMedia(){
        System.out.println(menu);
        output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        output+= moes.getMediaList();
        output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";        
       
    }
    private void playMedia(){
        System.out.println(moes.getStudentList());
        Scanner sc = new Scanner(System.in);
        System.out.println("Student number? ");
        int studentNumber = sc.nextInt();
        System.out.println(moes.getMediaList());
        System.out.println("Media number? ");
        int mediaNumber = sc.nextInt();
        System.out.println(menu);
        output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        output+= moes.playMedia(studentNumber, mediaNumber);
        output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        
       
    }
    private void listAvailablePoints(){
        System.out.println(moes.getStudentList());
        Scanner sc = new Scanner(System.in);
        System.out.println("Student number? ");
        int studentNumber = sc.nextInt();
        System.out.println(menu);
        output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
        output+="Points remaining "+ moes.getPoints(studentNumber);
        output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
      
        
    }
    private void buyPoints(){
        Scanner sc = new Scanner(System.in);
        System.out.println(moes.getStudentList());
        System.out.println("Student number? ");
        int studentNumber = sc.nextInt();
        System.out.println("Points remaining = "+moes.getPoints(studentNumber)+"\n");
        System.out.println("Enter number of points to buy ");
        int numPoints = sc.nextInt();
        if(numPoints<0){
            
           output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
           output+="No purchasing negative points!";
           output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
             
        }
        else{
             
            output="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
            output+=moes.buyPoints(studentNumber, numPoints);
            output+="~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n";
            
        }

    }
    public Main(){
        moes = new Moes();
        output = "";
        menu = new Menu();
        running = true;
        menu.addMenuItem(new MenuItem("0) Exit", ()-> endApp()));
        menu.addMenuItem(new MenuItem("1) Play media",  ()-> playMedia()));
        menu.addMenuItem(new MenuItem("2) List media",  ()-> listMedia()));
        menu.addMenuItem(new MenuItem("3) List available points",  ()->listAvailablePoints()));
        menu.addMenuItem(new MenuItem("4) Buy points",  ()-> buyPoints()));
        menu.addMenuItem(new MenuItem("5) Add media",  ()-> addMedia()));
        menu.addMenuItem(new MenuItem("6) List all students", ()-> listStudents()));
        menu.addMenuItem(new MenuItem("7) Add a student", ()-> addStudent()));
        


    }
    private void endApp(){
        running = false;
    }
    private void mdi(){
        Scanner sc = new Scanner(System.in);
        int choice;
        while(running){
            System.out.println("                       \\\\\\///             ");
            System.out.println("                      / _  _ \\        ");
            System.out.println("                    (| (.)(.) |)      ");
            System.out.println(".-----------------.OOOo--()--OOOo.--------------------.");
            System.out.println("|                                                     |");
            System.out.println("|     MAVS Online Entertainment System (MOES)         |");
            System.out.println("|     Version 1.0.1         Sathvik Ramprasad         |");
            System.out.println("|                                                     |");
            System.out.println("'-----------------------------------------------------'");
            System.out.println(menu);
            System.out.println(output);
            System.out.println("Selection? ");
            choice = sc.nextInt();
            menu.run(choice);

        }
    }
    public static void main(String args[]) {
        Main m = new Main();
        m.mdi();
    }

}

