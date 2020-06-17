import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ScannerNextIntLoader implements LoadIntArray {

    private String fileName;

    @Override
    public int[] load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        scanner.close();
        return input;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
