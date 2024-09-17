package product;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Takes title url as input and confirms the media that the user chose
 * @author      Sathvik Ramprasad
 * @version     0.2
 * @since       0.2
 * @license.agreement Gnu General Public License 3.0
 * */

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