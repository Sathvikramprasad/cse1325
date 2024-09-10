public class Student{
    String name;
    int id;
    String email;
    Account account;

   public Student(String name, int id, String email){
        if(!(email.endsWith("uta.edu"))){
            throw new IllegalArgumentException("Non-UTA email address: "+email);
        }
        this.name=name;
        this.id=id;
        this.email=email;
        account=new Account();
    }

   public String requestMedia(Media media){
        return account.play(media);
    }
    @Override
    public String toString(){
        return name +" (" + id + ", " + email + ", " + account.getAccountNumber() + ")";
    }


}