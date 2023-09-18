package br.edu.ifsp;
import br.edu.ifsp.deck.Card;
import br.edu.ifsp.game.Game;
import br.edu.ifsp.game.Player;

public class Principal {

    public static void main(String[] args) {
        Player player1 = new Player("joao");
        Player player2 = new Player("cleber");

        Game game1 = new Game(player1, player2);

        for (int i = 0; i < 50; i++) {
            game1.play();
        }


    }

}
