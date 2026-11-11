package prak12.christian.jonathan.laimena.view;

public class ChatConsoleView {
    public void printHeaderChatApp(String title) {
        System.out.println();
        System.out.println("========================================");
        System.out.println(title);
        System.out.println("========================================");
    }

    public void printInfoChat(String message) {
        System.out.println("[INFO]: " + message);
    }
}