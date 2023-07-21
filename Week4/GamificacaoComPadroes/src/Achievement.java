
public abstract class Achievement {
    private String name;
    protected AchievementStorage as;
    
    public Achievement() {
    	as = AchievementStorageFactory.getAchievementStorage();
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAchievement(String username, String name) {
    	setName(name);
    	as.addAchievement(username, this);
    }
}
