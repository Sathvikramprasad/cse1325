package customer;
import product.Media;
/**
* represents an account type that has unlimited access to media
*
* @author    Sathvik Ramprasad
* @version    0.2
* @since      0.2
* @license.agreement Gnu General Public License 3.0
*/
 public class Unlimited extends Account{
    @Override
    /**
 * plays specified media. For Unlimited accounts, this method returns a message indicating that the media is being played.
 * 
 * @param      media the Media object to be played.
 * @return     returns a message indicating that the media is being played.
 * @since      0.2
 */
    public String play(Media media){
            return "Playing "+media.toString();
        }
 }