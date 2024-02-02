package src.model;

public class Message {
    String message;

    public String getMessage() {
        return message;
    }

    public Message(String message) {
        this.message = message;
    }

    // setter should not implement for message, once the message is published can not be changed
}
