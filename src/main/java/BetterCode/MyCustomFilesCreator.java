package BetterCode;

import BetterCode.Readers.FileReader;
import BetterCode.Structures.Tuple;
import BetterCode.Writers.FileWriter;
import BetterCode.Writers.PdfWriter;

import java.io.IOException;
import java.util.List;

public class MyCustomFilesCreator
{

    public static void createCustomFiles(String fileToRead, List<String> myWordsAsInput) throws IOException
    {
        List<String> listOfReadStrings = FileReader.readFile(fileToRead);
        String readFileContent = combineListIntoString(listOfReadStrings);
        String inputWordsContent = combineListIntoString(myWordsAsInput);

        FileWriter.generateFile("outputFile", "txt",readFileContent+inputWordsContent);

        PdfWriter pdfWriter = new PdfWriter("outputPDF");
        pdfWriter.addParagraph(readFileContent+inputWordsContent);
        pdfWriter.addMetaInfo("TITLEEEE_TEST",new Tuple("KEYHERE","VALUEHERE"));
        pdfWriter.closeDocument();

    }

    public static String combineListIntoString(List<String> input)
    {
        String combinedString = "";
        for (String str:
                input) {
            combinedString += str+'\n';
        }

        return combinedString;
    }

}