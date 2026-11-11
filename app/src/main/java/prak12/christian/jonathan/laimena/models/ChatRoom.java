package prak12.christian.jonathan.laimena.models;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;
    private List<String> badwords = new ArrayList<>();
    
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
        for (User member : members) {
            if (member.equals(sender) == false) {
                member.receiveMessage(sender, pesanTerfilter);
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
