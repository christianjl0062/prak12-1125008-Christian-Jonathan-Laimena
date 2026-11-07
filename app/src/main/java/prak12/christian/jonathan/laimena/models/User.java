package prak12.christian.jonathan.laimena.models;

public class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name) {
        this.name = name;
    }

    public void send(String message) {
        if (this.chatRoom != null) {
            chatRoom.sendBroadcast(this, message);
        } else {
            System.out.println(this.name + " belum bisa gabung ke chat roomnya.");
        }
    }

    public void sendPrivate(String recipientName, String message) {
        if (this.chatRoom != null) {
            System.out.println("[" + this.name + "] Mengirim pesan privat ke " + recipientName + ":");
            chatRoom.sendPrivateMessage(this, recipientName, message);
        } else {
            System.out.println(this.name + " gagal kirim pesan privat karena belum gabung ke room.");
        }
    }

    public void receiveMessage(User sender, String message) {
        System.out.println("[" + this.name + "] Menerima pesan dari " + sender.getName() 
        + ": " + message);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }
    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }
}
