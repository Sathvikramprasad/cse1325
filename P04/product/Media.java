package product;
import java.net.MalformedURLException;
import java.net.URL;

public class Media{
    String title;
    String url;

    public Media(String title, String url){
       try {
        URL urlTest = new URL(url);
           
       } catch (MalformedURLException e) {
        throw new RuntimeException("Wrong URL");
       }
    
        this.title=title;
        this.url=url;
    }
    @Override
    public String toString(){
        return title + " (" + url + ")";
    }
}