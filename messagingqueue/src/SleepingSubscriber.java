package src;

import src.model.Message;
import src.public_interface.ISubscriber;

public class SleepingSubscriber implements ISubscriber {
    String id;
    int sleepTimeInMillis;

    public SleepingSubscriber(String id, int sleepTimeInMillis) {
        this.id = id;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started: " + message.getMessage());
        Thread.sleep(sleepTimeInMillis);
        System.out.println("Subscriber: " + id + " processed: " + message.getMessage());
    }
}
