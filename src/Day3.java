import javax.xml.stream.events.Characters;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3 {
    public void ReadFile() {
        try {
            File myObj = new File("resources/Day3.txt");
            Scanner myReader = new Scanner(myObj);

            List<String> ruckSacks = new ArrayList<>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ruckSacks.add(data);
            }
            System.out.println(part1(ruckSacks));
            System.out.println(part2(ruckSacks));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String part2(List<String> ruckSacks) {
        int total = 0;
        for (int i = 0; i < ruckSacks.size(); i+=3) {
            total += parseCharacterToNumber(findCommonLetterInThreeElfGroup(ruckSacks.get(i), ruckSacks.get(i+1), ruckSacks.get(i+2)));
        }
        return String.valueOf(total);
    }

    public char findCommonLetterInThreeElfGroup(String first, String second, String third) {
        char elfBadge = 0;
        char[] firstContents = first.toCharArray();
        for (char content : firstContents) {
            if (second.indexOf(content) != -1 && third.indexOf(content) != -1) {
                elfBadge = content;
                break;
            }
        }
        return elfBadge;
    }

    public String part1(List<String> ruckSacks) {
        int total = 0;
        for (String sack : ruckSacks) {
            boolean isFound = false;
            char[] left = sack.substring(0, sack.length() / 2).toCharArray();
            char[] right = sack.substring(sack.length() / 2).toCharArray();

            for (char leftCharacter : left) {
                if (isFound) {
                    break;
                }
                for (char rightCharacter : right) {
                    if (leftCharacter == rightCharacter) {
                        total += parseCharacterToNumber(leftCharacter);
                        isFound = true;
                        break;
                    }
                }
            }
        }
        return String.valueOf(total);
    }

    public int parseCharacterToNumber(char duplicateLetter) {
        int asciiNumber = duplicateLetter;
        if (duplicateLetter <= 90 && duplicateLetter >= 65) {
            asciiNumber = asciiNumber - 65 + 27;
        } else if (duplicateLetter >= 97 && duplicateLetter <= 122) {
            asciiNumber = asciiNumber - 97 + 1;
        }
        return asciiNumber;
    }
}
