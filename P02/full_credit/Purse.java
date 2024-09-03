public class Purse{
    public static void main(String args[]) {
        Coin coins[]= new Coin[5]; 
        coins[0]=new Coin(Denomination.PENNY, 2005);
        coins[1]=new Coin(Denomination.PENNY, 2000);
        coins[2]=new Coin(Denomination.NICKEL, 1986);
        coins[3]=new Coin(Denomination.DIME, 1947);
        coins[4]=new Coin(Denomination.QUARTER, 1923);
        
        

        double total = 0.0;
        int latestDate = 0;
        int earliestDate = 9999;

        for(Coin i : coins){
            if(i.getYear() < earliestDate){
                earliestDate = i.getYear();
            }
            if(i.getYear() > latestDate){
                latestDate = i.getYear();
            }
            total += i.getValue();
        }
        System.out.printf("You have $ %.2f in coins between %d and %d", total, earliestDate, latestDate );
    
        
    }   
}
