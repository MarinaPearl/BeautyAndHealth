import ru.Demchuck.BeautyAndHealth.Parser.ReaderURL;
import ru.Demchuck.BeautyAndHealth.Parser.WriterInCSV;

public class App {
    public static void main(String[] args) {
        ReaderURL readerURLEyeCream = new ReaderURL("eyeCream.txt");
        readerURLEyeCream.read();
        WriterInCSV writerEyeCream = new WriterInCSV(readerURLEyeCream.getUrl(), "eyeCreamOut.csv");
        ReaderURL readerURL = new ReaderURL("shampooURl.txt");
        readerURL.read();
        WriterInCSV writerShampoo = new WriterInCSV(readerURL.getUrl(), "shampooOut.csv");
        writerShampoo.write();
        ReaderURL readURLHandCream = new ReaderURL("handCream.txt");
        readURLHandCream.read();
        WriterInCSV writerHandCream = new WriterInCSV(readURLHandCream.getUrl(), "handCream.csv");
        writerHandCream.write();
    }

}
