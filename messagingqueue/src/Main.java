package src;

import src.model.Message;
import src.model.Topic;
import src.public_interface.ISubscriber;
import src.public_interface.Queue;

import java.io.IOException;

public class Main {
    public static  void main(String[] args) throws IOException {
        Queue queue = new Queue();
        Topic t1 = queue.createTopic("t1");
        Topic t2 = queue.createTopic("t2");
        Topic t3 = queue.createTopic("t3");

        ISubscriber s1 = new SleepingSubscriber("s1", 10000);
        ISubscriber s2 = new SleepingSubscriber("s2", 10000);
        queue.subscribe(t1, s1);
        queue.subscribe(t1, s2);
        queue.subscribe(t2, s1);

        queue.publish(new Message("m1"), t1);
        queue.publish(new Message("m2"), t1);

        queue.publish(new Message("m3"), t2);
        queue.resetOffset(t1, s1, 0);
    }
}
