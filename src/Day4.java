import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {
    public void ReadFile() {
        try {
            File myObj = new File("resources/Day4.txt");
            Scanner myReader = new Scanner(myObj);

            List<String> assignments = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                assignments.add(data);
            }
            System.out.println(part1(assignments));
            System.out.println(part2(assignments));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String part2(List<String> assignments) {
        int total = 0;
        for (String assignment : assignments) {
            String[] split1 = assignment.split(",");
            String s1 = split1[0];
            String s2 = split1[1];

            String[] split2 = s1.split("-");
            String[] split3 = s2.split("-");

            int start1 = Integer.parseInt(split2[0]);
            int end1 = Integer.parseInt(split2[1]);
            int start2 = Integer.parseInt(split3[0]);
            int end2 = Integer.parseInt(split3[1]);
            if (isOverlapped(start1, end1, start2, end2)) {
                total++;
            }
        }
        return String.valueOf(total);
    }

    public boolean isOverlapped(int start1, int end1, int start2, int end2) {
        if (start2 <= end1 && end2 >= start1) {
            return true;
        } else return start1 <= end2 && end1 >= start2;
    }

    public String part1(List<String> assignments) {
        int total = 0;
        for (String assignment : assignments) {
            String[] split1 = assignment.split(",");
            String s1 = split1[0];
            String s2 = split1[1];

            String[] split2 = s1.split("-");
            String[] split3 = s2.split("-");

            int start1 = Integer.parseInt(split2[0]);
            int end1 = Integer.parseInt(split2[1]);
            int start2 = Integer.parseInt(split3[0]);
            int end2 = Integer.parseInt(split3[1]);
            if (inRange(start1, end1, start2, end2)) {
                total++;
            }
        }
        return String.valueOf(total);
    }

    public boolean inRange(int start1, int end1, int start2, int end2) {
        if (start1 <= start2 && end1 >= end2) {
            return true;
        } else return start2 <= start1 && end2 >= end1;
    }

}
