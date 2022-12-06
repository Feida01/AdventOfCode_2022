import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {
    public void ReadFile() {
        try {
            File myObj = new File("resources/Day6.txt");
            Scanner myReader = new Scanner(myObj);

            String data = "";
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            System.out.println(part1(data));
            System.out.println(part2(data));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String part1(String buffer) {
        return String.valueOf(findFirstMarker(4, buffer));
    }

    public String part2(String buffer) {
        return String.valueOf(findFirstMarker(14, buffer));
    }

    public int findFirstMarker(int sequenceSize, String buffer) {
        for (int i = 0; i < buffer.length() - sequenceSize + 1; i++) {
            String sequence = buffer.substring(i, i + sequenceSize);
            if (isUniqueSequenceSize(sequence)) {
                return i + sequenceSize;
            }
        }
        return 0;
    }

    public boolean isUniqueSequenceSize(String buffer) {
        for (int j = 0; j < buffer.length(); j++) {
            for (int k = j + 1; k < buffer.length(); k++) {
                if (buffer.charAt(j) == buffer.charAt(k)) {
                    return false;
                }
            }
        }
        return true;
    }
}
