import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class ByFileReader implements LoadIntArray {

    private String fileName;

    @Override
    public int[] load() throws IOException {
        FileReader fr = new FileReader(fileName);
        Scanner scanner = new Scanner(fr);
        String[] input = scanner.useDelimiter("\\A").next().split("\\s+");
        scanner.close();
        int n = Integer.parseInt(input[0]);
        int[] numbers = getIntArray(input, 1, 1 + n);
        return numbers;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private static int[] getIntArray(String[] in, int from, int to) {
        int[] a = new int[to - from];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(in[from + i]);
        }
        return a;
    }

}
