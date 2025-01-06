package devguideocp.Part2_C16to21.A20_1_JavaIO;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author hatzp
 **/
public class WritingReadingTextFiles {
    public static void main(String[] args) throws IOException {

        //writing
        //to be used with try-with-resources
        //opt1
        FileOutputStream outputFile = new FileOutputStream("info.txt");
        OutputStreamWriter outputStream = new OutputStreamWriter(outputFile);
        PrintWriter printWriter1 = new PrintWriter(outputStream, true);

        //opt2
        FileOutputStream outputFile2 = new FileOutputStream("info.txt");
        PrintWriter printWriter2 = new PrintWriter(outputFile2, true);

        //opt3
        FileWriter fileWriter = new FileWriter("info.txt");
        PrintWriter printWriter3 = new PrintWriter(fileWriter, true);

        //opt4
        PrintWriter printWriter4 = new PrintWriter("info.txt");

        Charset utf8 = Charset.forName("UTF-8");
        //Charset utf8 = StandardCharsets.UTF_8;
        FileWriter fileWriter3 = new FileWriter("info.txt", utf8);
        PrintWriter printWriter5 = new PrintWriter(fileWriter3, true);

        PrintWriter printWriter6 = new PrintWriter("info.txt", utf8);//no flushing though



        //reading
        //opt1
        FileInputStream inputFile = new FileInputStream("info.txt");
        InputStreamReader reader = new InputStreamReader(inputFile);

        FileReader fileReader = new FileReader("info.txt");

        FileInputStream inputFile2 = new FileInputStream("info.txt");
        InputStreamReader reader2 = new InputStreamReader(inputFile2, utf8);

        FileReader reader3 = new FileReader("info.txt", utf8);



        //BUFFERED Versions for efficiency
        //BufferedWriter provides newLine() for writing platform dependent line separator

        FileOutputStream   outputFile5      = new FileOutputStream("info.txt");
        OutputStreamWriter outputStream5    = new OutputStreamWriter(outputFile5, utf8);
        BufferedWriter     bufferedWriter1 = new BufferedWriter(outputStream5);
        PrintWriter        printWriter15    = new PrintWriter(bufferedWriter1, true);

        FileWriter     fileWriter5      = new FileWriter("info.txt");
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter5);
        PrintWriter    printWriter25    = new PrintWriter(bufferedWriter2, true);

        //buff reader offeres readLine() and lines() stream of string

        // Using the UTF-8 character encoding:
        FileReader     fileReader5      = new FileReader("lines.txt", utf8);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader5);

// Use the default encoding:
        FileReader     fileReader6      = new FileReader("lines.txt");
        BufferedReader bufferedReader2 = new BufferedReader(fileReader6);





    }
}
