
public class Pincipal {
	
    public static void main(String[] args) {
        // Criando uma instância de EmailService
        EmailService emailService = new EmailService();
        
        // Injetando a dependência EmailService na classe UserService
        UserService userService = new UserService(emailService);

        // Utilizando o UserService para enviar um e-mail
        userService.sendEmail("exemplo@email.com", "Olá! Isso é um exemplo.");
    }

}
