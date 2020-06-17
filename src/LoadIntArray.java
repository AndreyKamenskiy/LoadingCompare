import java.io.IOException;

interface LoadIntArray {
    int[] load() throws IOException;
    void setFileName(String fileName);
}

