import java.util.List;

public class User {
    private String username;
    private AchievementStorage as;
    private Points points;
    private Badge badge;
    

    public User(String username) {
        this.username = username;
        as = AchievementStorageFactory.getAchievementStorage();
        points = new Points();
        badge = new Badge();
    }
    
    
    public void addPoints(String type, int value) {
    	points.addPoints(getUsername(), type, value);
    }
    
    public int getPoints(String type) {
        return points.getPoints(getUsername(), type);
    }
    
    public Points getPoints() {
        return points;
    }
    
    public Badge getBadge() {
        return badge;
    }
    
    public void addPointsAchievement(String name) {
        points.addAchievement(getUsername(), name);
    }
    
    public void addBadgeAchievement(String name) {
        badge.addAchievement(getUsername(), name);
    }
    
    public boolean hasAchievement(String achievementName) {
        Achievement achievement = as.getAchievement(getUsername(), achievementName);
        return achievement != null;
    }
    
    public List<Achievement> getAchievements() {
        return as.getAchievements(this.username);
    }
    
    private String getUsername() {
    	return this.username;
    }
    
}

