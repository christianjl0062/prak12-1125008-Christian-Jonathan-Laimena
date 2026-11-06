package prak12.christian.jonathan.laimena.models;
import java.util.List;
import java.util.ArrayList;

public class User {
    private String name;
    List<User> contacts;

    public User(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(User user) {
        this.contacts.add(user);
    }

    public void sendMessage(User receiver, String message) {
        System.out.println("[" + this.name + " -> " + receiver.getName() + "]: " + message);
        receiver.receiveMessage(this, message);
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + this.name + "] Menerima pesan dari " + sender.getName() + ": " + message);
    }

    public void sendGroupMessage(String message) {
        System.out.println("[" + this.name + " mengirim pesan ke grup]: " + message);
        for (User contact : this.contacts) {
            contact.receiveMessage(this, message);
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
