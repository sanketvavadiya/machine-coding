package src.public_interface;

import src.handler.TopicHandler;
import src.model.Message;
import src.model.Topic;
import src.model.TopicSubscriber;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Queue {
    private final Map<String, TopicHandler> topicHandlers;

    public Queue() {
        this.topicHandlers = new HashMap<>();
    }

    public Topic createTopic(final String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlers.put(topic.getTopicId(), topicHandler);
        System.out.println("Topic created: " + topicName);
        return topic;
    }

    public void subscribe(Topic topic, ISubscriber subscriber) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to " + topic.getTopicName());
    }

    public void publish(Message message, Topic topic) {
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to " + topic.getTopicName());
        TopicHandler topicHandler = topicHandlers.get(topic.getTopicId());
        new Thread(() -> {
            try {
                topicHandler.publish();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void resetOffset(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for(TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            if(topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println("Offset reset for " + topic.getTopicName() + " of " + subscriber.getId() + " and set: " + newOffset);
                TopicHandler topicHandler = topicHandlers.get(topic.getTopicId());
                new Thread(() -> {
                    try {
                        topicHandler.publish();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }).start();
                break;
            }
        }
    }
}
