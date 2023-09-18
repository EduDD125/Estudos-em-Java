package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Player {
    private String name;
    private int score;
    private Card[] cards = new Card[3];
    private int cardsNumber;
    private Card vira;

    public Player(String name) {
        this.name = name;
        this.cardsNumber = 3;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
    public Card chooseCard(){
        return cards[--cardsNumber];
    }
    public void incrementScore(){
        this.score++;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
    public void setScore() {
        this.score++;
    }
}
