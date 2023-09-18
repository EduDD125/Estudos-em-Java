package br.edu.ifsp.game;
import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;
public class Hand {
    public Card vira;
    private Player player1;
    private Player player2;
    private Round[] rounds = new Round[3];
    private int roundNumbers;

    public Hand(Player player1, Player player2) {
        Deck newDeck = new Deck();
        newDeck.shuffle();
        this.vira = newDeck.takeOne();
        player1.setCards(newDeck.take(3));
        player2.setCards(newDeck.take(3));
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playRound() {
        if(roundNumbers < 3) {
            Round newRound = new Round(player1.getName(), player1.chooseCard(),
                    player2.getName(), player2.chooseCard(), vira);
            System.out.printf("\nWinner is %s\n", newRound.getWinner());
            rounds[roundNumbers++] = newRound;
        }
    }

    public boolean isdDone() {
        return roundNumbers == 3;
    }

    public String getWinner() {
        if (roundNumbers == 3) {
            if (rounds[0].getWinner() == rounds[1].getWinner() || rounds[0].getWinner() == rounds[2].getWinner()) {
                return rounds[0].getWinner();
            }
            if (rounds[0].getWinner() == null && rounds[1].getWinner() != null) {
                return rounds[1].getWinner();
            }
            if (rounds[0].getWinner() == null && rounds[1].getWinner() == null && rounds[2].getWinner() != null) {
                return rounds[2].getWinner();
            }
        }
        return null;
    }

    public int getRoundNumbers() {
        return this.roundNumbers;
    }
}