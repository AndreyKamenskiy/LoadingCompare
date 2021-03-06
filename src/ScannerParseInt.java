import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ScannerParseInt implements LoadIntArray {

    private String fileName;

    @Override
    public int[] load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int n = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] convertedValues = new int[n];
        for (int i = 0; i < n; i++) {
            convertedValues[i] = Integer.parseInt(input[i]);
        }
        scanner.close();
        return convertedValues;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
