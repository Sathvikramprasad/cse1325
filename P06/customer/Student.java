package customer;
import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
/**
 * the Student class represents a UTA student with their media account, granting media access and management.
 * 
 * @author      Sathvik Ramprasad
 * @version     0.2
 * @since       0.1
 * @license.agreement Gnu General Public License 3.0
*/
public class Student{
    String name;
    int id;
    String email;
    Account account;
    /**
 * constructs a Student object with their name, ID, email, and account type.
 * 
 * @param      name the student's name.
 * @param      id the student's ID number.
 * @param      email the student's email address.
 * @param      unlimited a boolean indicating if the account type is Unlimited (true) or Alacarte (false).
 * @since      0.2
 */

   public Student(String name, int id, String email, boolean unlimited){
        if(!(email.endsWith("uta.edu"))){
            throw new IllegalArgumentException("Non-UTA email address: "+email);
        }
        this.name=name;
        this.id=id;
        this.email=email;
        if(unlimited){
            account = new Unlimited();
        }
        else{
            account = new Alacarte();
        }
    }
    /**
 * returns the account linked with the student.
 * 
 * @param     media the Media object that the student wants to play.
 * @return    returns the Account object linked with the student.
 * @since     0.2
 */

   public String requestMedia(Media media){
        return account.play(media);
    }
    @Override
    public String toString(){
        return name +" (" + id + ", " + email + ", " + account.getAccountNumber() + ")";
    }
    public Account getAccount(){
        return account;
    }
     public void save(BufferedWriter bw) throws IOException{
        bw.write(name + "\n");
        bw.write(" " + id + "\n");
        bw.write(email + "\n");
        bw.write(" " + account.getClass().getName() + "\n");
        account.save(bw);
    }
    public Student(BufferedReader br) throws IOException{
        this.name=br.readLine();
        this.id=Integer.parseInt(br.readLine());
        this.email=br.readLine();
        String accountType=br.readLine();
        if(accountType.equals("Unlimited")){
            this.account=new Unlimited(br);
        }
        else{
            this.account=new Alacarte(br);
        }
    }

}