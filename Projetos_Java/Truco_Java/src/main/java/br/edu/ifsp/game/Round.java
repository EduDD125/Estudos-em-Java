package br.edu.ifsp.game;
import br.edu.ifsp.deck.Card;

public class Round {
    private String winner;
    private Card vira;

    public Round(String player1, Card card1, String player2, Card card2, Card vira) {
        if (0 > card1.compareValueTo(card2, vira)) {
            this.winner = player1;
        }
        if (0 == card1.compareValueTo(card2, vira)) {
            this.winner = null;
        }
        if(0 < card1.compareValueTo(card2, vira)){
            this.winner = player2;
        }
    }
    public String getWinner(){
        return winner;
    }
}
