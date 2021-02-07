package haveFunAlgor.c13;

import java.io.File;

public class FileIOTest {
    public static void main(String[] args) {
        File f = new File(".\\pride-and-prejudice.txt");

        System.out.println(f.exists() + f.toString());
    }
}
