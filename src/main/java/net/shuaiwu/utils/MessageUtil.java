package net.shuaiwu.utils;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class MessageUtil {
    public static String TOPIC_NAME = "HeartBeat";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, args[0]);
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String,String> producer = new KafkaProducer<String,String>(props);
        Long start = System.currentTimeMillis();
        String key = "key-"+ start;
        String message = "Message-"+ start;
        ProducerRecord record= new ProducerRecord<String, String>(TOPIC_NAME, key, message);
        producer.send(record);
        Long end = System.currentTimeMillis();
        Long bad = end - start;
        producer.close();
        if(bad > 5000){
            System.exit(2);
        }else{
            System.exit(1);
        }
    }
}
