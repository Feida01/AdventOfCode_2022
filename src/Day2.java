import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class Day2 {
    public void ReadFile() {

        try {
            File myObj = new File("resources/Day2.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> enemyDecisions = new ArrayList<>();
            ArrayList<String> yourDecisions = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitAnswers = data.split("");

                enemyDecisions.add(splitAnswers[0]);
                yourDecisions.add(splitAnswers[2]);
            }
            System.out.println(part1(enemyDecisions, yourDecisions));
            System.out.println(part2(enemyDecisions, yourDecisions));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Rock VS Rock = +4
    // Rock VS Paper = +8
    // Rock VS Scissor = +3
    // Paper VS Rock = +1
    // Paper VS Paper = +5
    // Paper VS Scissor = +9
    // Scissor VS Rock = +7
    // Scissor VS Paper = +2
    // Scissor VS Scissor = +6
    // A X = 4 | A Y = 8 | A Z = 3
    // B X = 1 | B Y = 5 | B Z = 9
    // C X = 7 | C Y = 2 | C Z = 6



    // A = Rock         X = LOSE
    // B = Paper        Y = DRAW
    // C = Scissor      Z = WIN
    // Win = +6, Draw = +3, Lose = +0
    // Rock = 1, Paper = 2, Scissor = 3
    public String part2(List<String> enemyDecisions, List<String> yourDecisions) {
        String enemyRock = "A", enemyPaper = "B", enemyScissor = "C";
        int yourRock = 1, yourPaper = 2, yourScissor = 3;
        String LOSE = "X", DRAW = "Y", WIN = "Z";
        int LOSEpoints = 0, DRAWpoints = 3, WINpoints = 6;

        int totalPoints = 0;

        for (int i = 0; i < enemyDecisions.size(); i++) {
            if (enemyDecisions.get(i).equals(enemyRock) && yourDecisions.get(i).equals(LOSE)) {
                totalPoints += yourScissor + LOSEpoints;
            } else if (enemyDecisions.get(i).equals(enemyRock) && yourDecisions.get(i).equals(DRAW)) {
                totalPoints += yourRock + DRAWpoints;
            } else if (enemyDecisions.get(i).equals(enemyRock) && yourDecisions.get(i).equals(WIN)) {
                totalPoints += yourPaper + WINpoints;
            } else if (enemyDecisions.get(i).equals(enemyPaper) && yourDecisions.get(i).equals(LOSE)) {
                totalPoints += yourRock + LOSEpoints;
            } else if (enemyDecisions.get(i).equals(enemyPaper) && yourDecisions.get(i).equals(DRAW)) {
                totalPoints += yourPaper + DRAWpoints;
            } else if (enemyDecisions.get(i).equals(enemyPaper) && yourDecisions.get(i).equals(WIN)) {
                totalPoints += yourScissor + WINpoints;
            } else if (enemyDecisions.get(i).equals(enemyScissor) && yourDecisions.get(i).equals(LOSE)) {
                totalPoints += yourPaper + LOSEpoints;
            } else if (enemyDecisions.get(i).equals(enemyScissor) && yourDecisions.get(i).equals(DRAW)) {
                totalPoints += yourScissor + DRAWpoints;
            } else if (enemyDecisions.get(i).equals(enemyScissor) && yourDecisions.get(i).equals(WIN)) {
                totalPoints += yourRock + WINpoints;
            }
        }
        return String.valueOf(totalPoints);
    }

    // A = Rock = X
    // B = Paper = Y
    // C = Scissor = Z
    // Win = +6, Draw = +3, Lose = +0
    // Rock = 1, Paper = 2, Scissor = 3
    // Rock VS Rock = +4
    // Rock VS Paper = +8
    // Rock VS Scissor = +3
    // Paper VS Rock = +1
    // Paper VS Paper = +5
    // Paper VS Scissor = +9
    // Scissor VS Rock = +7
    // Scissor VS Paper = +2
    // Scissor VS Scissor = +6
    public String part1(List<String> enemyDecisions, List<String> yourDecisions) {
        String enemyRock = "A", enemyPaper = "B", enemyScissor = "C";
        String yourRock = "X", yourPaper = "Y", yourScissor = "Z";

        int totalPoints = 0;

        for (int i = 0; i < enemyDecisions.size(); i++) {
            if (enemyDecisions.get(i).equals(enemyRock) && yourDecisions.get(i).equals(yourRock)) {
                totalPoints += 4;
            } else if (enemyDecisions.get(i).equals(enemyRock) && yourDecisions.get(i).equals(yourPaper)) {
                totalPoints += 8;
            } else if (enemyDecisions.get(i).equals(enemyRock) && yourDecisions.get(i).equals(yourScissor)) {
                totalPoints += 3;
            } else if (enemyDecisions.get(i).equals(enemyPaper) && yourDecisions.get(i).equals(yourRock)) {
                totalPoints += 1;
            } else if (enemyDecisions.get(i).equals(enemyPaper) && yourDecisions.get(i).equals(yourPaper)) {
                totalPoints += 5;
            } else if (enemyDecisions.get(i).equals(enemyPaper) && yourDecisions.get(i).equals(yourScissor)) {
                totalPoints += 9;
            } else if (enemyDecisions.get(i).equals(enemyScissor) && yourDecisions.get(i).equals(yourRock)) {
                totalPoints += 7;
            } else if (enemyDecisions.get(i).equals(enemyScissor) && yourDecisions.get(i).equals(yourPaper)) {
                totalPoints += 2;
            } else if (enemyDecisions.get(i).equals(enemyScissor) && yourDecisions.get(i).equals(yourScissor)) {
                totalPoints += 6;
            }
        }
        return String.valueOf(totalPoints);
    }
}
