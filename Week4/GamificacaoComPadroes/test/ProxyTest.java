import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProxyTest {

	private ForumService realForumService;
    private ForumServiceGamificationProxy gamifiedForumService;

    @BeforeEach
    public void setup() {
        // Criar a implementação real do ForumService
        realForumService = mock(ForumService.class);
        gamifiedForumService = new ForumServiceGamificationProxy(realForumService);
        gamifiedForumService.resetAchievements();
    }


    @Test
    public void testAddTopic() {
        // Chamar o método addTopic na implementação gamificada
        gamifiedForumService.addTopic("user1", "Título do Tópico");
        
        // Verificar se o método addTopic foi chamado na implementação real
        verify(realForumService).addTopic("user1", "Título do Tópico");

        // Verificar se os pontos e badges foram adicionados corretamente
        assertEquals(5, gamifiedForumService.getPoints("user1", "CREATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user1", "I CAN TALK"));
        assertEquals(false, gamifiedForumService.hasAchievement("user1", "INVENTOR"));
        
        // Adicionando mais 95 pontos para atingir o badge "INVENTOR"
        for (int i = 0; i < 19; i++) {
            gamifiedForumService.addTopic("user1", "Título do Tópico");
        }
        assertEquals(100, gamifiedForumService.getPoints("user1", "CREATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user1", "INVENTOR"));
        
    }

    @Test
    public void testAddComment() {
        gamifiedForumService.addComment("user2", "Título do Tópico", "Comentário");
        verify(realForumService).addComment("user2", "Título do Tópico", "Comentário");
        assertEquals(3, gamifiedForumService.getPoints("user2", "PARTICIPATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user2", "LET ME ADD"));
        assertEquals(false, gamifiedForumService.hasAchievement("user2", "PART OF THE COMMUNITY"));
        
        // Adicionando mais 99 pontos para atingir o badge "PART OF THE COMMUNITY"
        for (int i = 0; i < 33; i++) {
            gamifiedForumService.addComment("user2", "Título do Tópico", "Comentário");
        }
        assertEquals(102, gamifiedForumService.getPoints("user2", "PARTICIPATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user2", "PART OF THE COMMUNITY"));
    }

    @Test
    public void testLikeTopic() {
        gamifiedForumService.likeTopic("user3", "Título do Tópico", "user1");
        verify(realForumService).likeTopic("user3", "Título do Tópico", "user1");
        assertEquals(1, gamifiedForumService.getPoints("user1", "CREATION"));
    }

    @Test
    public void testLikeComment() {
        gamifiedForumService.likeComment("user4", "Título do Tópico", "Comentário", "user2");
        verify(realForumService).likeComment("user4", "Título do Tópico", "Comentário", "user2");
        assertEquals(1, gamifiedForumService.getPoints("user2", "PARTICIPATION"));
    }
    
    @Test
    public void testAddTopicTwice() {
        gamifiedForumService.addTopic("user5", "Título do Tópico");
        gamifiedForumService.addTopic("user5", "Título do Tópico");

        verify(realForumService, times(2)).addTopic("user5", "Título do Tópico");
        assertEquals(10, gamifiedForumService.getPoints("user5", "CREATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user5", "I CAN TALK"));
    }
    
    @Test
    public void testMultipleActions() {
        gamifiedForumService.addTopic("user6", "Título do Tópico");
        gamifiedForumService.addComment("user6", "Título do Tópico", "Comentário");
        gamifiedForumService.likeTopic("user6", "Título do Tópico", "user1");
        gamifiedForumService.likeComment("user6", "Título do Tópico", "Comentário", "user2");
        gamifiedForumService.addTopic("user6", "Título do Tópico");
        gamifiedForumService.addComment("user6", "Título do Tópico", "Comentário");
        gamifiedForumService.likeTopic("user6", "Título do Tópico", "user1");
        gamifiedForumService.likeComment("user6", "Título do Tópico", "Comentário", "user2");

        verify(realForumService, times(2)).addTopic("user6", "Título do Tópico");
        verify(realForumService, times(2)).addComment("user6", "Título do Tópico", "Comentário");
        verify(realForumService, times(2)).likeTopic("user6", "Título do Tópico", "user1");
        verify(realForumService, times(2)).likeComment("user6", "Título do Tópico", "Comentário", "user2");

        assertEquals(10, gamifiedForumService.getPoints("user6", "CREATION"));
        assertEquals(2, gamifiedForumService.getPoints("user1", "CREATION"));
        assertEquals(6, gamifiedForumService.getPoints("user6", "PARTICIPATION"));
        assertEquals(2, gamifiedForumService.getPoints("user2", "PARTICIPATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user6", "I CAN TALK"));
        assertEquals(true, gamifiedForumService.hasAchievement("user6", "LET ME ADD"));
    }
    
    @Test
    public void testExceptionHandling() {
        // Fazendo o mock lançar uma exceção para o método addTopic
        doThrow(new RuntimeException("Erro ao adicionar tópico")).when(realForumService).addTopic("user7", "Título do Tópico");
        
        // Verificando se os achievements não foram adicionados
        assertThrows(RuntimeException.class, () -> gamifiedForumService.addTopic("user7", "Título do Tópico"));
        assertEquals(0, gamifiedForumService.getPoints("user7", "CREATION"));
        assertEquals(false, gamifiedForumService.hasAchievement("user7", "I CAN TALK"));
    }
    
    @Test
    public void testObserverInventor() {
        // Atingindo 100 pontos de "CREATION" e verificando se o usuário recebe o badge "INVENTOR"
        for (int i = 0; i < 20; i++) {
            gamifiedForumService.addTopic("user8", "Título do Tópico");
        }

        assertEquals(100, gamifiedForumService.getPoints("user8", "CREATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user8", "INVENTOR"));
    }
    
    @Test
    public void testObserverPartOfTheCommunity() {
        // Atingindo 100 pontos de "PARTICIPATION" e verificando se o usuário recebe o badge "PART OF THE COMMUNITY"
        for (int i = 0; i < 34; i++) {
            gamifiedForumService.addComment("user9", "Título do Tópico", "Comentário");
        }

        assertEquals(102, gamifiedForumService.getPoints("user9", "PARTICIPATION"));
        assertEquals(true, gamifiedForumService.hasAchievement("user9", "PART OF THE COMMUNITY"));
    }

}
