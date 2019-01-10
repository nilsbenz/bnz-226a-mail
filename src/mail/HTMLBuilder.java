package mail;

class HTMLBuilder {

    HTMLBuilder() {}

    String getHTMLFromInput(String element, String content) {
        return "<" + element + ">" + content + "</" + element + ">";

    }
}
