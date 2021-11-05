package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ListenerService service = new ListenerService();

        Card card = context.getBean(Card.class);
        service.workWithCard(card);

        Card card2 = context.getBean(Card.class);
        service.workWithCard(card2);

        context.close();
    }
}
