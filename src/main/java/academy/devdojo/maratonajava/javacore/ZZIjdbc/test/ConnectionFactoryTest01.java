package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.model.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProduceRepository;

public class ConnectionFactoryTest01    {
    public static void main(String[] args) {
        Producer producer = Producer.ProducerBuilder.builder().nome("NHK").build();
        ProduceRepository.save(producer);
    }
}
