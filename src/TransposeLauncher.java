import org.kohsuke.args4j.*;

import java.io.*;
import java.util.Scanner;

public class TransposeLauncher {
    @Argument(metaVar = "file", usage = "Входной файл")
    private String file;
    @Option(name = "-o", metaVar = "ofile", usage = "Имя выходного файла")
    private String ofile;
    @Option(name = "-a", metaVar = "width", usage = "Ширина каждого поля")
    private int width;
    @Option(name = "-t", metaVar = "cut", usage = "Обрезание до определённого размера")
    private boolean cut;
    @Option(name = "-r", metaVar = "align",  usage = "Выравнивание по правой стороне")
    private boolean align;



    public static void main(String[] args) {
        new TransposeLauncher().launch(args);
    }

    public void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            if ((cut || align) && width == 0) width = 10;
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar IdeaProjects.jar -a width -t cut -r align -o ofile -file");
            parser.printUsage(System.err);
            return;
        }

        Transpose transposer = new  Transpose(width, align, cut);
        try {
            InputStream input;
            if (file == null) input = new BufferedInputStream(System.in);
            else input = new FileInputStream(file);
            Scanner scanner = new Scanner(input);
            OutputStream output;
            if (ofile == null) output = new BufferedOutputStream(System.out);
            else output = new FileOutputStream(ofile);
            PrintWriter printWriter = new PrintWriter(output);
            transposer.transpose(scanner, printWriter);
    } catch (IOException e){
    System.err.print(e.getMessage());
    }
    }
}
