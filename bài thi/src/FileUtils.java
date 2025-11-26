import java.io.*;
import java.util.*;

public class FileUtils {

    public static List<Contact> readCSV(String path) throws IOException {
        List<Contact> temp = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) return temp;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        br.readLine(); // bo qua header

        while ((line = br.readLine()) != null) {
            Contact c = Contact.fromCSV(line);
            if (c != null) temp.add(c);
        }
        br.close();
        return temp;
    }

    public static void writeCSV(String path, List<Contact> list) throws IOException {
        File file = new File(path);
        file.getParentFile().mkdirs();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("phone,group,name,gender,address,dob,email\n");

        for (Contact c : list) {
            bw.write(c.toCSV() + "\n");
        }

        bw.close();
    }
}
