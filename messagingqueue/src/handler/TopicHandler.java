package src.handler;

import src.model.Message;
import src.model.Topic;
import src.model.TopicSubscriber;
import src.public_interface.ISubscriber;

import java.util.HashMap;
import java.util.Map;

public class TopicHandler {
    private final Topic topic;
    private  final Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() throws InterruptedException {
        for(TopicSubscriber topicSubscriber : topic.getTopicSubscribers()) {
            startSubscriberWorker(topicSubscriber);
//            the below snippet would help to simply the logic if offset requirement is not there
//            ISubscriber subscriber = topicSubscriber.getSubscriber();
//            Message message = topic.getMessages().get(topicSubscriber.getOffset().get());
//            new Thread(() -> {
//                try {
//                    subscriber.consume(message);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
        }
    }

    private void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        String subscriberId = topicSubscriber.getSubscriber().getId();
        if(!subscriberWorkers.containsKey(subscriberId)) {
            SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }
}
