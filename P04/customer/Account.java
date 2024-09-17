package customer;
import product.Media;
public abstract class Account{
     int accountNumber;
     static int nextAccountNumber = 1;
    public Account(){
        accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public abstract String play(Media media);


}