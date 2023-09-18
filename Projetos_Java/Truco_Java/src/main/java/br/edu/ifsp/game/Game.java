package br.edu.ifsp.game;

public class Game {
    private Player player1;
    private Player player2;
    private Hand[] hands = new Hand[23];
    private int handsNumber = 0;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        hands[handsNumber++] = new Hand(player1, player2);
        hands[handsNumber-1].playRound();
    }

    public void play(){
        if(this.isDone()){
            System.out.println(getWinner());
        }
        if(hands[handsNumber-1].isdDone()) {
            if (hands[handsNumber - 1].getWinner() == player1.getName()) player1.setScore();
            if (hands[handsNumber - 1].getWinner() == player2.getName()) player2.setScore();
            System.out.printf("Winner of Hand %d: %s\n", handsNumber, hands[handsNumber - 1].getWinner());
            hands[handsNumber++] = new Hand(player1, player2);
            hands[handsNumber-1].playRound();
        } else {
            hands[handsNumber-1].playRound();
        }
    }
    public boolean isDone(){
        return (player1.getScore() == 12 || player2.getScore() == 12);
    }
    public Player getWinner(){
        if (player1.getScore() == 12) return player1;
        if (player2.getScore() == 12) return player2;
        System.out.println("The games don´t have a winner yet!\n");
        return null;
    }
}
