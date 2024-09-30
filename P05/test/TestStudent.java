package test;
import customer.Student;
import product.Media;
public class TestStudent{
    public static void main(String args[]) {
        int failureCount = 0;
        Student student1 = new Student("ABCD", 1234, "abc1234@uta.edu");
        if(!student1.toString().equals("ABCD (1234, abc1234@uta.edu, 1)")){
            failureCount++;
            System.err.println("Wrong string representation");
        }
        boolean error = false;
        try {
            Student student2 = new Student("xyz", 5678, "gfh5678@outlook.com");
        } 
        
        catch (IllegalArgumentException e) {
            error = true;
            if(!e.getMessage().equals("Non-UTA email address: gfh5678@outlook.com")){
                System.err.println("Wrong message for exception");
                failureCount++;
            }
        }
        catch(Exception e){
                error = true;
                System.err.println("Wrong Execption thrown : "+ e.getMessage());
                failureCount++;
        }
        if(error == false){
            System.err.println("No Exception thrown");
            failureCount++;
        }
        Media m1=new Media("song1", "https://www.youtube.com/", 0);
       if(!student1.requestMedia(m1).equals("Playing song1 (https://www.youtube.com/)")){
        System.err.println("Wrong output for request media");
        failureCount++;
       }
       System.exit(failureCount);
    }
}