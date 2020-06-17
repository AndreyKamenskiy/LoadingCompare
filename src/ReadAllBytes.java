import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class ReadAllBytes implements LoadIntArray {

    private String fileName;

    @Override
    public int[] load() throws IOException {
        String[] input = new String(Files.readAllBytes(Paths.get(fileName))).split("\\s+");

        int n = Integer.parseInt(input[0]);
        int[] numbers = getIntArray(input, 1, 1 + n);
        return numbers;
    }

    private static int[] getIntArray(String[] in, int from, int to) {
        int[] a = new int[to - from];

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(in[from + i]);
        }
        return a;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
