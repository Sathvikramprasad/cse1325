public class Student{
    String name;
    int id;
    String email;
    Account account;

   public Student(String name, int id, String email){
        this.name=name;
        this.id=id;
        this.email=email;
        account=new Account();
    }

   public String requestMedia(Media media){
        return media.toString();
    }
    @Override
    public String toString(){
        return name +" (" + id + ", " + email + ", " + account.getAccountNumber() + ")";
    }


}