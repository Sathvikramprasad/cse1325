package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import product.Media;
/**
* an abstract class representing a general account for accessing media.
*
* @author     Sathvik Ramprasad
* @version    0.2
* @since      0.1
* @license.agreement Gnu General Public License 3.0
*/
public abstract class Account{
     int accountNumber;
     static int nextAccountNumber = 1;
     /**
* initializes a new account with a new account number. The account number is incremented for each new Account created.
*
* @since    0.1
*/
    public Account(){
        accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    /**
 * returns the unique account number associated with this account.
 * 
 * @return    returns the account number.
 * @since     0.1
 */
    public int getAccountNumber(){
        return this.accountNumber;
    }
    /**
 * an abstract method to be implemented by subclasses to play the specified media.
 * 
 * @param    media the media object to be played.
 * @return    returns a message indicating the result of the media play request.
 * @since    0.2
 */
    public abstract String play(Media media);

    public void save(BufferedWriter bw) throws IOException{
        bw.write(nextAccountNumber + "\n");
        bw.write(accountNumber + "\n");
    }
    public Account(BufferedReader br) throws IOException{
        nextAccountNumber=Integer.parseInt(br.readLine());
        this.accountNumber=Integer.parseInt(br.readLine());
    }

    }

