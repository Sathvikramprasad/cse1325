package test;
import product.Media;

class TestMedia{
    public static void main(String args[]) {
        int failureCount = 0;
        Media media = new Media("thing to test", "https://www.youtube.com/", 0);
       if(!media.toString().equals("thing to test (https://www.youtube.com/)")){
        System.err.println("FAIL");
        failureCount++;
       }
    String validURLs[]={"https://youtube.com", "file://media/lib/garp.mp4"};
    String invalidURLs[] ={" hello.world", "htt://badurl.com", "flub://badurl.com"};
       try{
        for(String s: validURLs){
            new Media("title", s, 0);
        }
        }
        catch(RuntimeException e){
            System.err.println("FAIL");
            failureCount++;
        }
        for(String s: invalidURLs){
            boolean errorThrown = false;
            try {
              new Media("title", s, 0);  
            } 
            catch (RuntimeException e) {
                errorThrown = true;
            }
            if(!errorThrown){
                System.err.println("FAIL");
                failureCount++;
                break;
            }
        }
       System.exit(failureCount);
       
       
    }

}