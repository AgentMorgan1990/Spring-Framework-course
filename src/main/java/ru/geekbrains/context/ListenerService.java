package ru.geekbrains.context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;

import ru.geekbrains.context.Card;

@Component
public class ListenerService {

    void workWithCard(Card card) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String name = reader.readLine();
            String[] words = name.split(" ");
            if (words[0].equals("end")) {
                break;
            } else {
                switch (words[0]) {
                    case ("add"):
                        card.addById(Long.parseLong(words[1]));
                        break;
                    case ("delete"):
                        card.deleteById(Long.parseLong(words[1]));
                        break;
                    case ("show"):
                        card.showAllInCard();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
