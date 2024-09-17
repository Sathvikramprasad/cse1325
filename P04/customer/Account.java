package customer;
import product.Media;
public class Account{
     int accountNumber;
     static int nextAccountNumber = 1;
    public Account(){
        accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public String play(Media media){
            return "Playing "+media.toString();
        }


}