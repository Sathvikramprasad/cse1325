package moes;
import customer.Account;
import customer.Alacarte;
import customer.Student;
import customer.Unlimited;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import product.Media;
/**
* The Moes class manages media and student accounts, has methods to add and list media,
 manages student points, and plays media.
* @author           Sathvik Ramprasad
* @version          0.2
* @since            0.2
* @license.agreement Gnu General Public License 3.0
*/

public class Moes{
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();
    public void addMedia(Media media){
        library.add(media);
    }
    /**
 * Returns a list of all media objects in the library, numbered by their position.
 * 
 * @return       a string representing the list of media objects with its index numbers.
 * @since        0.2
 */
    public String getMediaList(){
        String output = "";
        int i = 0;
        for(Media m: library){
            output = output + i + ") " + m.toString() + "\n";
            i++;
        }
        return output;
    }
    /**
 * Adds a student to the customers list.
 * 
 * @param       student Adds a student to the system.
 * @since       0.2
 */
    public void addStudent(Student student){
        customers.add(student);
    }
    /**
 * Returns the list of all student objects in the customer list, with index of their position.
 * 
 * @return     returns a string representing the list of students with their index numbers.
 * @since       0.2
 */
    public String getStudentList(){
        int i = 0;
        String output = "";
        for(Student s: customers){
            output = output + i + ") " + s.toString() + "\n";
            i++;
        }
        return output;       
    } 
    /**
 * Retrieves available points for a student's account, based on the account type.
 * 
 * @param      num The index of the student in the customer list.
 * @return     returns the number of points available in the student's account.
 * @since      0.2
 */
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
    /**
 * Adds points to a student's Alacarte account or provides message for Unlimited accounts.
 * 
 * @param      num The index of the student in the customer list.
 * @param      points The number of points to add to the student's account.
 * @return     returns a message indicating the point balance for Alacarte accounts, or a message for Unlimited accounts.
 * @since      0.2
 */
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
    /**
 * Allows a student to play the selected media, only if their account has sufficient points.
 * 
 * @param      studentNumber The index of the student in the customer list.
 * @param      mediaNumber The index of the media in the library list.
 * @return     returns a message indicating whether the media is playing or if more points are required.
 * @since      0.2
 */
    public String playMedia(int studentNumber, int mediaNumber){
        Student student = customers.get(studentNumber);
        Media media = library.get(mediaNumber);        
        return student.requestMedia(media);
    } 
    private ArrayList<Media>mediaList;
    private ArrayList<Student>studentList;

    public void save(BufferedWriter bw) throws IOException{
        bw.write(mediaList.size() + "\n");
        for(Media media : mediaList){
            media.save(bw);
        }
        bw.write(studentList.size() + "\n");
        for(Student student : studentList){
            student.save(bw);
        }
    }
    public Moes(BufferedReader br) throws IOException{
        int mediaSize=Integer.parseInt(br.readLine());
        mediaList=new ArrayList<>(mediaSize);
        for(int i=0; i<mediaSize; i++){
            mediaList.add(new Media(br));
        }
        int studentSize=Integer.parseInt(br.readLine());
        studentList=new ArrayList<>(studentSize);
        for(int i=0; i<studentSize; i++){
            studentList.add(new Student(br));
        }
    }
}
