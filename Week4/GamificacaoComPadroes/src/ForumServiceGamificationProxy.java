
public class ForumServiceGamificationProxy implements ForumService, AchievementObserver {
    private ForumService forumService;
    private AchievementStorage as;

    public ForumServiceGamificationProxy(ForumService forumService) {
        this.forumService = forumService;
        this.as = AchievementStorageFactory.getAchievementStorage();
        as.addObserver(this);
    }

    @Override
    public void addTopic(String user, String topic) {
        forumService.addTopic(user, topic);
        addPoints(user, "CREATION", 5);
        addBadgeAchievement(user, "I CAN TALK");
    }

    @Override
    public void addComment(String user, String topic, String comment) {
        forumService.addComment(user, topic, comment);
        addPoints(user, "PARTICIPATION", 3);
        addBadgeAchievement(user, "LET ME ADD");
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        forumService.likeTopic(user, topic, topicUser);
        addPoints(topicUser, "CREATION", 1);
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        forumService.likeComment(user, topic, comment, commentUser);
        addPoints(commentUser, "PARTICIPATION", 1);
    }

    private void addPoints(String user, String type, int value) {
    	User userObj = new User(user);
    	userObj.addPoints(type, value);
    }
    
    public int getPoints(String user, String type) {
    	User userObj = new User(user);
    	return userObj.getPoints(type);
    }
    
    private void addPointsAchievement(String user, String badgeName) {
    	User userObj = new User(user);
    	userObj.addBadgeAchievement(badgeName);
    }

    private void addBadgeAchievement(String user, String badgeName) {
    	User userObj = new User(user);
    	userObj.addBadgeAchievement(badgeName);
    }
    
    public boolean hasAchievement(String user, String achievementName) {
    	User userObj = new User(user);
    	return userObj.hasAchievement(achievementName);
    }
    
    public void resetAchievements() {
        as.resetAchievements();
    }
    
    @Override
    public void achievementUpdate(String user, Achievement a) {
        if (a instanceof Points) {
            int points = getPoints(user, "CREATION");
            if (points >= 100 && !hasAchievement(user, "INVENTOR")) {
                addPointsAchievement(user, "INVENTOR");
            }

            points = getPoints(user, "PARTICIPATION");
            if (points >= 100 && !hasAchievement(user, "PART OF THE COMMUNITY")) {
                addPointsAchievement(user, "PART OF THE COMMUNITY");
            }
        }
    }
    
}
