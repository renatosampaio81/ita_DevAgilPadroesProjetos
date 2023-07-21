import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamificacaoTest {
	
    @BeforeAll
    public static void setup() {
        AchievementStorageFactory.setAchievementStorage(new MemoryAchievementStorage());
    }

    @BeforeEach
    public void resetAchievements() {
        AchievementStorageFactory.getAchievementStorage().resetAchievements();
    }

    @Test
    public void testAddPoints() {
    	
    	User user = new User("Renato");
        
        user.addPoints("Type A", 50);
        Assertions.assertEquals(50, user.getPoints("Type A"));
        user.addPoints("Type A", 50);
        Assertions.assertEquals(100, user.getPoints("Type A"));
        
        user.addPoints("Type B", 70);
        Assertions.assertEquals(70, user.getPoints("Type B"));
        
        user.addPointsAchievement("Level 0");
        user.addPointsAchievement("Level 1");
        user.addPointsAchievement("Level 1");
        
        Assertions.assertTrue(user.hasAchievement("Level 0"));
        Assertions.assertFalse(user.hasAchievement("Level 10"));
        Assertions.assertEquals(2, user.getAchievements().size());

    }

    @Test
    public void testAddBadge() {
    	
    	User user = new User("Renato");

        user.addBadgeAchievement("First Badge");
        user.addBadgeAchievement("First Badge");
        
        Assertions.assertTrue(user.hasAchievement("First Badge"));
        Assertions.assertFalse(user.hasAchievement("Second Badge"));
        Assertions.assertEquals(1, user.getAchievements().size());
        
    }

}
