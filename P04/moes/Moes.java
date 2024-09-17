package moes;
import customer.Account;
import customer.Alacarte;
import customer.Student;
import customer.Unlimited;
import java.util.ArrayList;
import product.Media;

public class Moes{
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();
    public void addMedia(Media media){
        library.add(media);
    }
    public String getMediaList(){
        String output = "";
        int i = 0;
        for(Media m: library){
            output = output + i + ") " + m.toString() + "\n";
            i++;
        }
        return output;
    }
    public void addStudent(Student student){
        customers.add(student);
    }
    public String getStudentList(){
        int i = 0;
        String output = "";
        for(Student s: customers){
            output = output + i + ") " + s.toString() + "\n";
            i++;
        }
        return output;       
    } 
     public int getPoints(int num){
        Student student = customers.get(num);
        Account account = student.getAccount();
        if (account instanceof Alacarte){
            Alacarte a = (Alacarte) account;
            int p1 = a.getPointsRemaining();
            return p1;
        } else if (account instanceof Unlimited) {
            return  Integer.MAX_VALUE;
        } else{
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }
      public String buyPoints(int num, int points){
        Student student = customers.get(num);
        Account account = student.getAccount();
        if (account instanceof Alacarte){
            Alacarte a = (Alacarte) account;
            a.buyPoints(points);
            int p1 = a.getPointsRemaining();
            return "Available: " + p1;
            
        } else if (account instanceof Unlimited) {
            return "Account type Unlimited, no need for points. ";
        } else{
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }
    public String playMedia(int studentNumber, int mediaNumber){
        Student student = customers.get(studentNumber);
        Media media = library.get(mediaNumber);        
        return student.requestMedia(media);
    } 
}
