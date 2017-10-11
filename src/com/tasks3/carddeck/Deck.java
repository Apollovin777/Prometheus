package com.tasks3.carddeck;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    public static void main(String[] args){
        int index = 0;
        Deck deck = new Deck();
        index = 0;
        for (Card c: deck.deck
                ) {
            System.out.println(index + " " + c.getSuit().name() + " " + c.getRank().name());
            index++;
        }

    }

    private Card[] deck = new Card[36];

    public Deck(){
        int index = 0;
        for (Suit s: Suit.values()
             ) {
            for (Rank r: Rank.values()
                 ) {
                deck[index] = new Card(r,s);
                index++;
            }
        }
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = deck.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = deck[index];
            deck[index] = deck[i];
            deck[i] = a;
        }
    }

    /* * Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */
    public void order() {
        Card[] temp = new Card[deck.length];
        int index = 0;
        for (Suit s: Suit.values()
                ) {
            for (Rank r: Rank.values()
                    ) {
                for(int i = 0; i < deck.length; i++){
                    if(deck[i].getSuit().equals(s) && deck[i].getRank().equals(r)){
                        temp[index]=deck[i];
                        index++;
                    }
                }
            }
        }
        deck = temp;
    }

    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {
        if(deck.length>0)
            return true;
        else
            return false;
    }

    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    public Card drawOne() {
        if(deck.length>0) {
            Card drawOneCard = deck[deck.length - 1];
            deck = Arrays.copyOf(deck, deck.length - 1);
            return drawOneCard;
        }
        else
            return null;
    }
}
