package prak12.christian.jonathan.laimena.models;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String roomName;
    private List<User> members;

    public ChatRoom(String roomName) {
        this.roomName = roomName;
        this.members = new ArrayList<>();
    }

    public void registerUser(User user) {
        members.add(user);
        user.setChatRoom(this);
    }

    public void sendBroadcast(User sender, String message) {
        for (User member : members) {
            if (member.equals(sender) == false) {
                member.receiveMessage(sender, message);
            }
        }
    }
    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
