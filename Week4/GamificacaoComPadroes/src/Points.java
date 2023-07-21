
public class Points extends Achievement {

    public Points() {
    	super();
    }
    
    public void addPoints(String username, String type, int value) {
    	as.addPoints(username, type, value);
    	notifyObservers(username, this);
    }
    
    public int getPoints(String username, String type) {
    	return as.getPoints(username, type);
    }
    
    protected void notifyObservers(String user, Achievement a) {
        for (AchievementObserver observer : as.getObservers()) {
            observer.achievementUpdate(user, a);
        }
    }

}
