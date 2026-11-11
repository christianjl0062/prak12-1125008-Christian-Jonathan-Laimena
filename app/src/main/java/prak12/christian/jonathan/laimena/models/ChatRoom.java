package prak12.christian.jonathan.laimena.models;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;
    private List<String> badwords = new ArrayList<>();
    private List<String> mutedUsers = new ArrayList<>();
    private List<String> chatHistory = new ArrayList<>();

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        this.members = new ArrayList<>();
    }

    public void registerUser(User user) {
        members.add(user);
        user.setChatRoom(this);
    }

    public void removeUser(User user) {
        if (members.isEmpty()) {
            System.out.println("Room ini gak ada anggota sama sekali");
        } else {
            if (members.contains(user)) {
                members.remove(user);
                user.setChatRoom(null);
                System.out.println("User " + user.getName() + " sudah berhasil dihapus dari room " 
                + this.roomName);
            } else {
                System.out.println("Maaf, user " + user.getName() + " gak ditemukan.");
            }
        }
    }

    public void sendBroadcast(User sender, String message) {
        String pesanTerfilter = filterMessage(message);
        String logPesan = sender.getName() + ": " + pesanTerfilter;
        chatHistory.add(logPesan);

        if (mutedUsers.contains(sender.getName())) {
            System.out.println("[Mediator]: Pesan dari " + sender.getName() 
            + " sudah diblokir karena usernya ke mute duluan.");
        } else {
            for (User member : members) {
                if (member.equals(sender) == false) {
                    member.receiveMessage(sender, pesanTerfilter);
                }
            }
        }
    }

    public void sendPrivateMessage(User sender, String recipientName, String message) {
        String pesanTerfilter = filterMessage(message);
        boolean userFound = false;
        for (User member : members) {
            if (member.getName().equals(recipientName)) {
                member.receiveMessage(sender, pesanTerfilter);  
                userFound = true;
            }
        }
        
        if (userFound == false) {
            System.out.println("User " + recipientName + " tidak ditemukan di room ini.");
        }
    }

    public void addBadWord(String word) {
        badwords.add(word.toLowerCase());
    }

    public String filterMessage(String message) {
        String filteredMessage = message;
        for (String badword : badwords) {
            filteredMessage = filteredMessage.replace(badword, "***");
        }
        return filteredMessage;
    }

    public void muteUser(User user) {
        if (mutedUsers.contains(user.getName()) == false) {
            mutedUsers.add(user.getName());
            System.out.println("[Mediator]: User " + user.getName() 
            + " sudah dimute / udah bisu total di room " + roomName + ".");
        }
    }

    public void unmuteUser(User user) {
        mutedUsers.remove(user.getName());
        System.out.println("[Mediator]: User " + user.getName() + 
        " berhasil di unmute / gak bisu lagi.");
    }

    public void showHistory() {
        System.out.println("========================================");
        System.out.println("History Chat di Room: " + roomName + "");
        System.out.println("========================================");
        if (chatHistory.isEmpty()) {
            System.out.println("Maaf, ini belum ada history chat nya.");
        } else {
            for (String chatAppLog : chatHistory) {
                System.out.println(chatAppLog);
            }
        }
        System.out.println("========================================");
    }
    
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public List<User> getMembers() {
        return members;
    }
    public void setMembers(List<User> members) {
        this.members = members;
    }
}
