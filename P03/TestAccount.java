public class TestAccount{
    public static void main(String args[]) {
        Account A1 = new Account();
        Account A2 = new Account();
        if(!(A1.getAccountNumber()==1&&A2.getAccountNumber()==2)){
            System.out.println("FAIL");
            System.exit(1);
        }
    }
}