package mail;

import java.io.Console;
import java.util.Scanner;

class InputReader {

    private Scanner scanner = new Scanner(System.in);
    private HTMLBuilder builder;

    User getCredentials() {
        String username = "";
        String password;
        System.out.println("Herzlich willkommen im besten eMail-Programm der Welt!\n");

        System.out.println("Bitte geben Sie ihre gmail-adresse an:");
        boolean validUsername = false;
        while (!validUsername) {
            username = scanner.next();
            if (username.contains("@")) {
                validUsername = true;
            } else {
                username = "";
                System.out.println("Bitte geben Sie ihre Mailadresse an:");
            }
        }

        System.out.println("Nun geben Sie ihr Passwort ein:");
        password = scanner.next();
        return new User(username, password);
    }

    String getRecipient() {
        System.out.println("An wen wollen Sie eine Mail schreiben?");
        String recipient = "";
        boolean validAddress = false;
        while (!validAddress) {
            recipient = scanner.next();
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
        return scanner.next();
    }

    String getContent() {
        builder = new HTMLBuilder();
        String content = "";

        System.out.println("Geben Sie ein HTML-Element an, hier einige Beispiele:");
        System.out.println("h1 : Titel");
        System.out.println("h2 : Untertitel");
        System.out.println("p : Fliesstext");
        System.out.println("\nsend : die Mail versenden");

        boolean send = false;
        while (!send) {
            String element = scanner.next();
            if(element.equals("send")) {
                send = true;
            } else {
                System.out.println("Geben Sie den Inhalt des Elements an:");
                String elementContent = scanner.next();
                content = content + builder.getHTMLFromInput(element, elementContent);
            }
        }

        return content;
    }
}
