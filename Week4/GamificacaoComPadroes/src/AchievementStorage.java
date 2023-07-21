import java.util.List;

public interface AchievementStorage {
    void addAchievement(String user, Achievement a);
    List<Achievement> getAchievements(String user);
    Achievement getAchievement(String user, String achievementName);
    void resetAchievements();
	void addPoints(String user, String type, int value);
	int getPoints(String user, String type);
	void addObserver(AchievementObserver observer);
	List<AchievementObserver> getObservers();
}
