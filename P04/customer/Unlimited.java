package customer;
import customer.Account;
import product.Media;

 public class Unlimited extends Account{
    @Override
    public String play(Media media){
            return "Playing "+media.toString();
        }
 }