package mail;

import java.util.Scanner;

class InputReader {

    private Scanner scanner;
    private HTMLBuilder builder;

    InputReader() {
        this.scanner = new Scanner(System.in);
        this.builder = new HTMLBuilder();
    }

    User getCredentials() {
        String username = "";
        String password;
        System.out.println("Herzlich willkommen im besten eMail-Programm der Welt!\n");

        System.out.println("Bitte geben Sie ihre gmail-adresse an:");
        boolean validUsername = false;
        while (!validUsername) {
            username = scanner.nextLine();
            if (username.contains("@")) {
                validUsername = true;
            } else {
                username = "";
                System.out.println("Bitte geben Sie ihre Mailadresse an:");
            }
        }

        System.out.println("Nun geben Sie ihr Passwort ein:");
        password = scanner.nextLine();
        return new User(username, password);
    }

    String getRecipient() {
        System.out.println("An wen wollen Sie eine Mail schreiben?");
        String recipient = "";
        boolean validAddress = false;
        while (!validAddress) {
            recipient = scanner.nextLine();
            if (recipient.contains("@")) {
                validAddress = true;
            } else {
                recipient = "";
                System.out.println("An wen wollen Sie eine Mail schreiben?");
            }
        }
        return recipient;
    }

    String getSubject() {
        System.out.println("Bitte geben Sie den der Mail Betreff an.");
        String subject = scanner.nextLine();
        return subject;
    }

    String getContent() {
        String content = "";

        boolean send = false;
        while (!send) {
            System.out.println("Geben Sie ein HTML-Element an, hier einige Beispiele:");
            System.out.println("h1 : Titel");
            System.out.println("h2 : Untertitel");
            System.out.println("p : Fliesstext");
            System.out.println("\nsend : die Mail versenden");

            String element = scanner.nextLine();
            if(element.equals("send")) {
                send = true;
            } else if(element.equals("h1") || element.equals("h2") || element.equals("p")) {
                System.out.println("Geben Sie den Inhalt des Elements an:");
                String elementContent = scanner.nextLine();
                content = content + builder.getHTMLFromInput(element, elementContent);
            }
        }

        return content;
    }
}
