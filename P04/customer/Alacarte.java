package customer;
import product.Media;
public class Alacarte extends Account{
    int pointsRemaining;

    public void buyPoints(int points){
        pointsRemaining += points;
    }
    public int getPointsRemaining(){
        return pointsRemaining;
    }
    @Override
    public String play(Media media){
        if(pointsRemaining < media.getPoints()){
            return "Buy more points: Requires "+(media.getPoints() - pointsRemaining);
        }
        else{
            pointsRemaining -= media.getPoints();
            return "Playing "+ media.toString();
        }
    }
}