import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public void ReadFile() {
        try {
            File myObj = new File("resources/Day1.txt");
            Scanner myReader = new Scanner(myObj);

            List<Integer> sums = new ArrayList<>();

            int total = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                if (!data.equals("")) {
                    total += Integer.parseInt(data);
                } else {
                    sums.add(total);
                    total = 0;
                }
            }
            System.out.println(part1(sums));
            System.out.println(part2(sums));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String part1(List<Integer> sums) {
        int HighestCalories = 0;
        for (Integer sum : sums) {
            if (sum > HighestCalories) {
                HighestCalories = sum;
            }
        }
        return String.valueOf(HighestCalories);
    }

    public String part2(List<Integer> sums) {
        List<Integer> topThreeHighestCalories = sums.stream().sorted(Comparator.reverseOrder()).limit(3).toList();

        int total = 0;
        for (Integer topThreeHighestCalory : topThreeHighestCalories) {
            total += topThreeHighestCalory;
        }
        return String.valueOf(total);
    }

}
