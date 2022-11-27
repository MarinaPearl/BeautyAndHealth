import ru.Demchuck.BeautyAndHealth.DB.DatabaseHandler;
import ru.Demchuck.BeautyAndHealth.Parser.ConnectionDBEyeCream;
import ru.Demchuck.BeautyAndHealth.Parser.ReaderURL;
import ru.Demchuck.BeautyAndHealth.Parser.DataBaseParametr;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
//        System.out.println();
//        ReaderURL readerURLEyeCream = new ReaderURL("eyeCream.txt");
//        readerURLEyeCream.read();
//        WriterInCSV writerEyeCream = new WriterInCSV(readerURLEyeCream.getUrl(), "eyeCreamOut.csv");
//        ReaderURL readerURL = new ReaderURL("shampooURl.txt");
//        readerURL.read();
//        WriterInCSV writerShampoo = new WriterInCSV(readerURL.getUrl(), "shampooOut.csv");
//        writerShampoo.write();
//        ReaderURL readURLHandCream = new ReaderURL("handCream.txt");
//        readURLHandCream.read();
//        WriterInCSV writerHandCream = new WriterInCSV(readURLHandCream.getUrl(), "handCream.csv");
//        writerHandCream.write();
        try {
            DatabaseHandler databaseHandler = new DatabaseHandler();
//            ReaderURL readerURLEyeCream = new ReaderURL("eyeCream.txt");
//            readerURLEyeCream.read();
//            var connectionDBEyeCream = new ConnectionDBEyeCream(readerURLEyeCream.getUrl());
//            connectionDBEyeCream.write();
//            ArrayList<DataBaseParametr> eyeCreamArrayList = connectionDBEyeCream.getList();
//            for (DataBaseParametr it : eyeCreamArrayList) {
//                databaseHandler.insertProduct(it.getBrand(), it.getShortDescription(), it.getVolume(), it.getPrice(),
//                it.getDescription(), 0);
//            }
//            ReaderURL readerURL = new ReaderURL("shampooURl.txt");
//            readerURL.read();
//            var connectionDBEShampoo = new ConnectionDBEyeCream(readerURL.getUrl());
//            connectionDBEShampoo.write();
//            ArrayList<DataBaseParametr> shampooList = connectionDBEShampoo.getList();
//            for (DataBaseParametr it : shampooList) {
//                databaseHandler.insertProduct(it.getBrand(), it.getShortDescription(), it.getVolume(), it.getPrice(),
//                        it.getDescription(), 2);
//            }
            ReaderURL readerURLHandCream = new ReaderURL("handCream.txt");
            readerURLHandCream.read();
            var connectionDBHandCream = new ConnectionDBEyeCream(readerURLHandCream.getUrl());
            connectionDBHandCream.write();
            ArrayList<DataBaseParametr> handCreamList = connectionDBHandCream.getList();
            for (DataBaseParametr it : handCreamList) {
                databaseHandler.insertProduct(it.getBrand(), it.getShortDescription(), it.getVolume(), it.getPrice(),
                        it.getDescription(), 1);
            }
//            Statement statementEyeCream = databaseHandler.getDbConnection().createStatement();
//            ResultSet resultSetEyeCream = statementEyeCream.executeQuery("select * from beautyandhealth.eyecream where description like '%Омолаживающий%' or shortDescription like '%Омолаживающий%'");
//            String fullPath = "src/main/resources/eyeCreamSelect.txt";
//            PrintWriter writer = new PrintWriter(fullPath, StandardCharsets.UTF_8);
//            while (resultSetEyeCream.next()) {
//                writer.print(resultSetEyeCream.getString(2) + "; ");
//                writer.print(resultSetEyeCream.getString(3) + "; ");
//                writer.print(resultSetEyeCream.getString(4) + "; ");
//                writer.println(resultSetEyeCream.getString(5) + "; ");
//            }
//            writer.close();
        }catch (Exception error) {
            error.printStackTrace();
        }
    }

}
