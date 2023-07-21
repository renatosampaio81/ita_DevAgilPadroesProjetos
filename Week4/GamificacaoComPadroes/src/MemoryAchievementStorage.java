import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryAchievementStorage implements AchievementStorage {
    private Map<String, Map<String, Achievement>> achievements;
    private Map<String, Map<String, Integer>> userPoints;
    private List<AchievementObserver> observers = new ArrayList<>();

    public MemoryAchievementStorage() {
        this.achievements = new HashMap<>();
        this.userPoints = new HashMap<>();
    }

    @Override
    public void addAchievement(String username, Achievement a) {   	
    	achievements.putIfAbsent(username, new HashMap<>());
        Map<String, Achievement> userAchievements = achievements.get(username);
        userAchievements.put(a.getName(), a);  
    }
    
    @Override
    public List<Achievement> getAchievements(String user) {
        Map<String, Achievement> userAchievements = achievements.getOrDefault(user, new HashMap<>());
        return new ArrayList<>(userAchievements.values());
    }

    @Override
    public Achievement getAchievement(String user, String achievementName) {
        Map<String, Achievement> userAchievements = achievements.getOrDefault(user, new HashMap<>());
        return userAchievements.get(achievementName);
    }

	@Override
	public void resetAchievements() {
		achievements.clear();
		userPoints.clear();
	}
	
	@Override
    public void addPoints(String username, String type, int value) {
        userPoints.putIfAbsent(username, new HashMap<>());
        int currentPoints = userPoints.get(username).getOrDefault(type, 0);
        userPoints.get(username).put(type, currentPoints + value);
    }
	
	@Override
    public int getPoints(String username, String type) {
        return userPoints.getOrDefault(username, new HashMap<>()).getOrDefault(type, 0);
    }
	
    @Override
    public void addObserver(AchievementObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public List<AchievementObserver> getObservers() {
        return observers;
    }
    
}

