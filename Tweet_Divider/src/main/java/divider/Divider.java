package divider;

import java.io.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import static utils.Constants.*;

public class Divider {

    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String inputText = "";
            String line;
            while ((line = reader.readLine()) != null) {

                inputText += line + "\n";
            }
            reader.close();

            ArrayList<String> parts = new ArrayList<>();
            int totalLength = inputText.length();
            int partCount = (int) Math.ceil((double) totalLength / maxLength);
            for (int i = 0; i < partCount; i++) {
                int start = i * maxLength;
                int end = Math.min(start + maxLength, totalLength);
                String part = inputText.substring(start, end);

              /*  if (end != totalLength && !Character.isWhitespace(inputText.charAt(end))) {

                    int j = part.length() - 1;
                    while (j >= 0 && !Character.isWhitespace(part.charAt(j))) {
                        j--;
                    }
                    if (j > 0) {
                        end = start + j + 1;
                        part = inputText.substring(start, end);

                    }
                }


               */

                parts.add("(" + (i + 1) + "/" + partCount + ") " + part);

                FileWriter writer = new FileWriter(outputFile);
                for (String part1 : parts) {
                    writer.write(part1 + "\n\n");
                }
                writer.close();

            }

            System.out.println("Metin " + partCount + " parçaya bölündü ve " + "output.txt dosyasına kaydedildi");


        } catch (IOException e) {
            System.out.println(" Hata : " + e.getMessage());
        }

    }


}
