package prak12.christian.jonathan.laimena.controller;

import prak12.christian.jonathan.laimena.models.ChatRoom;
import prak12.christian.jonathan.laimena.models.User;

public class ChatController {
    private ChatRoom chatRoom;

    public ChatController(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public void registerUserToRoom(User user) {
        chatRoom.registerUser(user);
    }

    public void removeUserFromRoom(User user) {
        chatRoom.removeUser(user);
    }

    public void muteUserInRoom(User user) {
        chatRoom.muteUser(user);
    }

    public void showChatHistory() {
        chatRoom.showHistory();
    }
}
