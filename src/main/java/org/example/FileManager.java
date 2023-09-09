package org.example;
import java.io.*;

import java.io.FileNotFoundException;

public class FileManager {

    public String read(String filePath) throws FileNotFoundException, IOException{
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String content = "";

        try{
            String line;
            while((line = bufferedReader.readLine()) !=null){
                content += line + "n";
            }
        } finally{
            bufferedReader.close();
            fileReader.close();
        }

        return content;
    }

    public void write(String filePath, String content) throws IOException{
        FileWriter fileWriter = new FileWriter(filePath);

        try{
            fileWriter.write(content);
        } finally {
            fileWriter.close();
        }
    }

    public void copy(String sourceFilePath, String destinationFilePath) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(sourceFilePath);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath);
        byte[] buffer = new byte[1024];
        int bytesRead;

        try{
            while((bytesRead = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
