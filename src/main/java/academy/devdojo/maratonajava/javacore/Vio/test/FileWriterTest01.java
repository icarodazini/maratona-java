package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

// File
// FileWriter
// FileReader
// BufferedWriter
// BufferedReader
public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try (java.io.FileWriter fw = new java.io.FileWriter(file, true)) {
            fw.write("Hello, World!\nÓla, DevDojo!\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
