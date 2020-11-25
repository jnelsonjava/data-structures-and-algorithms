package hrank.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeaderBoard {
    // Given a "dense ranked" leaderboard, find the rank of each player score as they improve
    // ranked list is high scores in descending order
    // player list is player scores in ascending order
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = new ArrayList<>();

        // create stack of leaderboard points without duplicates
        Stack<Integer> uniqueRanked = new Stack<>();
        for (int leader : ranked) {
            if (uniqueRanked.size() == 0) uniqueRanked.push(leader);
            if (leader != uniqueRanked.peek()) uniqueRanked.push(leader);
        }

        // check each player score against the top of the stack to determine rank
        // pop the top value off the stack if it is lower than the player score
        for (int score : player) {
            while (!uniqueRanked.isEmpty() && uniqueRanked.peek() <= score) uniqueRanked.pop();
            ranks.add(uniqueRanked.size() + 1);
        }
        return ranks;
    }
}
