package product;
import java.net.MalformedURLException;
import java.net.URL;

public class Media{
    String title;
    String url;
    int points;

    public Media(String title, String url, int points){
       try {
        URL urlTest = new URL(url);
           
       } catch (MalformedURLException e) {
        throw new RuntimeException("Wrong URL");
       }
    
        this.title=title;
        this.url=url;
        this.points=points;
    }
    @Override
    public String toString(){
        return title + " (" + url + ")" + points;
    }
    public int getPoints(){
        return points;
    }
}