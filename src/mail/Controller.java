package mail;

class Controller {

    private Service service;
    private InputReader inputReader;

    private User user;
    private String recipient;
    private String subject;
    private String content;

    Controller() {
        service = new Service();
        inputReader = new InputReader();
    }

    void sendMail() {
        user = inputReader.getCredentials();
        recipient = inputReader.getRecipient();
        subject = inputReader.getSubject();
        content = inputReader.getContent();

        service.sendMail(user, recipient, subject, content);
    }
}
