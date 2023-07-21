
public class UserService {

    private EmailService emailService;

    // Injeção de dependência via construtor
    public UserService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(String to, String message) {
        emailService.send(to, message);
    }
	
}
