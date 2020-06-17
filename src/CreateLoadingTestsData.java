import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateLoadingTestsData {

    final static String NEW_LINE = "\n";
    public final static String PATH_TO_DATA_FILES = "./data/comparesData/";

    public final static int START_LENGTH = 1_000;
    public final static int END_LENGTH = 30_000;
    public final static int STEP = 1_000;
    public final static int TIMES_FOR_EACH_LENGTH = 100;
    public final static int MIN_VALUE = -100_000;
    public final static int MAX_VALUE = 100_000;

    public static void main(String[] regs) throws IOException {
        for (int length = START_LENGTH; length <= END_LENGTH; length += STEP) {
            String content = createTest(length, MIN_VALUE, MAX_VALUE);
            String fullFileName =  PATH_TO_DATA_FILES + "test" + length + "int.txt";
            saveToFile(fullFileName, content);
        }
    }

    static String createTest(int length, int minValue, int maxValue) {

        StringBuilder test = new StringBuilder();
        test.append(length);
        test.append(NEW_LINE);

        for (int i = 0; i < length; i++) {
            int currentNumber = getRandom(minValue, maxValue);
            test.append(currentNumber);
            test.append(" ");
        }

        return test.toString();
    }

    static int getRandom(int minValue, int maxValue) {
        return (int)(Math.random() * (maxValue - minValue + 1) + minValue);
    }

    static void saveToFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(new File(fileName));
        writer.append(content);
        writer.close();
    }
}
