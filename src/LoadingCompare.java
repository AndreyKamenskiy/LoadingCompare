import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadingCompare  {

    public static void main(String[] args) throws IOException {

        List<LoadIntArray> loaders = new ArrayList<>();
        loaders.add(new ScannerNextIntLoader());
        loaders.add(new ScannerParseInt());
        loaders.add(new ScannerNextParseInt());
        loaders.add(new UseDelimiter());
        //loaders.add(new ByFileReader()); // equals to useDelimeter
        loaders.add(new ReadAllBytes());

        System.out.print("Length \t");
        for (LoadIntArray currentLoader : loaders) {
            System.out.print(currentLoader.getClass().getName().replaceFirst(".*\\.+", "") + "\t");
        }
        System.out.println();

        for (int length = CreateLoadingTestsData.START_LENGTH;
             length <= CreateLoadingTestsData.END_LENGTH;
             length += CreateLoadingTestsData.STEP) {
            String fullFileName =  CreateLoadingTestsData.PATH_TO_DATA_FILES + "test" + length + "int.txt";
            System.out.print(length + "\t");
            for (LoadIntArray currentLoader : loaders) {
                currentLoader.setFileName(fullFileName);
                long time = nanoToMicro(getLoaderAverageTime(currentLoader));
                System.out.printf(" %d \t", time);
            }
            System.out.println();
        }
    }

    private static long nanoToMilli(long time) {
        return time / 1_000_000;
    }

    private static long nanoToMicro(long time) {
        return time / 1_000;
    }

    private static long getLoaderAverageTime(LoadIntArray loader) throws IOException {

        long timeInNanoseconds = System.nanoTime();
        for (int i = 0; i < CreateLoadingTestsData.TIMES_FOR_EACH_LENGTH; i++) {
            int[] input = loader.load();
        }
        long averageTime = (System.nanoTime() - timeInNanoseconds) / CreateLoadingTestsData.TIMES_FOR_EACH_LENGTH;
        return averageTime;
    }
}
