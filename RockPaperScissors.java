import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static String normalizeMove(String move) {
        for (String validMove : MOVES) {
            if (validMove.equalsIgnoreCase(move.trim())) return validMove;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter number of rounds: ");
        int rounds;
        try {
            rounds = Integer.parseInt(scanner.nextLine().trim());
            if (rounds <= 0) throw new NumberFormatException();
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a positive whole number.");
            scanner.close();
            return;
        }

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            String playerMove;
            while (true) {
                System.out.print("Round " + (i + 1) + " — enter Rock, Paper, or Scissors: ");
                playerMove = normalizeMove(scanner.nextLine());
                if (playerMove != null) break;
                System.out.println("Invalid move. Try again.");
            }
            String computerMove = MOVES[random.nextInt(MOVES.length)];
            String result = playRound(playerMove, computerMove);
            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
            System.out.printf("Result: %s (computer chose %s)%n%n", result, computerMove);
        }

        System.out.println("\nFINAL SCOREBOARD");
        System.out.printf("%-8s | %-14s | %-16s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------+----------------+------------------+----------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d | %-14s | %-16s | %-14s%n", i + 1, playerMoves[i], computerMoves[i], results[i]);
        }
        double winPercentage = wins * 100.0 / rounds;
        System.out.printf("%nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
        scanner.close();
    }
}
