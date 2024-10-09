package customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import product.Media;
/**
* represents an account type where media access is based on points available
*
* @author     Sathvik Ramprasad
* @version    0.2
* @since      0.2
* @license.agreement Gnu General Public License 3.0
*/
public class Alacarte extends Account{
    int pointsRemaining;
    /**
 * adds the specified number of points to the account's points balance.
 * 
 * @param     points the number of points to be added into the account.
 * @since     0.2
 */
    public void buyPoints(int points){
        pointsRemaining += points;
    }
    /**
 * retrieves the number of points remaining in the account.
 * 
 * @return     returns the number of points remaining in the account.
 * @since      0.2
 */
    public int getPointsRemaining(){
        return pointsRemaining;
    }
    @Override
    /**
* Attempts to play the specified media, i there are not enough points then a message indicating shortage of points is returned. Or else the media is played and required points are deducted. 
*
* @param        media the Media object to be played.
* @return       returns a message indicating whether the media is being played or if more points are required.
* @since        0.2
*/
    public String play(Media media){
        if(pointsRemaining < media.getPoints()){
            return "Buy more points: Requires "+(media.getPoints() - pointsRemaining);
        }
        else{
            pointsRemaining -= media.getPoints();
            return "Playing "+ media.toString();
        }
    }
    public Alacarte(int pointsRemaining){
        super();
        this.pointsRemaining=pointsRemaining;
    }
    public void save(BufferedWriter bw) throws IOException{
        super.save(bw);
        bw.write(Integer.toString(pointsRemaining) + "\n");
    }
    public Alacarte(BufferedReader br) throws IOException{
        super(br);
        this.pointsRemaining=Integer.parseInt(br.readLine());
    }
}