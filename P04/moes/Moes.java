package moes;
import customer.Student;
import java.util.ArrayList;
import product.Media;

public class Moes{
    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();
    public void addMedia(Media media){
        library.add(media);
    }
    public String getMediaList(){
        String output = "";
        int i = 0;
        for(Media m: library){
            output = output + i + ") " + m.toString() + "\n";
            i++;
        }
        return output;

    }
    
    
}
