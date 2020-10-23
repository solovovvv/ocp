package com.mycompany.ocp.ch1.advancedclassdesign.equalshashcodeandtostring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashCodeDemo {
    public static void main(String[] args) {
        Card card1 = new Card("Туз", "Пик");
        Card card2 = new Card("Туз", "Черви");
        System.out.println(card1.hashCode() + " " + card2.hashCode());  //hashCode неправильно переопределен и hashCode'ы равны, но это неправильно

        Set<Card> cards = new HashSet<>();
        cards.add(card1);
        cards.add(card2);
        System.out.println("cards size(): " + cards.size());
        cards.forEach(System.out::println);

        Map<Card, String> map = new HashMap<>();
        map.put(card1, "Hello");
        map.put(card2, "World");
        map.forEach((card, s) -> System.out.println(card + " " + s));
        System.out.println(map.get(card2));


    }
}

class Card {
    private String rank;    //ранг карты (например, король)
    private String suite;   //масть карты (черви, пики и пр.)

    public Card(String rank, String suite) {
        if (rank == null || suite == null)
            throw new IllegalArgumentException();
        this.rank = rank;
        this.suite = suite;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card card = (Card) obj;
        return card.rank.equals(this.rank) && card.suite.equals(this.suite);
    }

    public int hashCode() {
        return rank.hashCode();
    }

}