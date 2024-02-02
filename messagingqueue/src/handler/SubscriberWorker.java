package src.handler;

import src.model.Message;
import src.model.Topic;
import src.model.TopicSubscriber;

public class SubscriberWorker implements Runnable {
    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    public synchronized void wakeUpIfNeeded() {
        notify();
    }

    @Override
    public void run() {
        synchronized (topicSubscriber) {
            while(true) {
                int offset = topicSubscriber.getOffset().get();
                while(offset >= topic.getMessages().size()) {
                    try {
                        topicSubscriber.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Message message = topic.getMessages().get(offset);
                try {
                    topicSubscriber.getSubscriber().consume(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                topicSubscriber.getOffset().compareAndSet(offset, offset+1);
            }
        }
    }
}
