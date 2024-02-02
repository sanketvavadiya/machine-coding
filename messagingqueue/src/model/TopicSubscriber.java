package src.model;

import src.public_interface.ISubscriber;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    private final AtomicInteger offset; // this is to allow accurate update of offset in case of multithreading
    private final ISubscriber subscriber;

    public TopicSubscriber(ISubscriber subscriber) {
        this.offset = new AtomicInteger(0);
        this.subscriber = subscriber;
    }

    public AtomicInteger getOffset() {
        return offset;
    }

    public ISubscriber getSubscriber() {
        return subscriber;
    }
}
