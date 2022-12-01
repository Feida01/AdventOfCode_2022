import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public void ReadFile() {
        try {
            File myObj = new File("Day1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
