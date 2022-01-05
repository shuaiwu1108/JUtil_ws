package org.wslio.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FilesUtil {
    public static final String baseResources = "src/main/resources/";

    public static String readFile(String fileName){
        LineIterator lineIterator = null;
        StringBuffer sb = new StringBuffer();
        try {
            lineIterator = FileUtils.lineIterator(new File(baseResources + fileName), "UTF-8");
            while (lineIterator.hasNext()){
                String tmpLine = lineIterator.nextLine();
                sb.append(tmpLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (lineIterator != null){
                try {
                    lineIterator.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static List<String> readFileToList(String fileName){
        LineIterator lineIterator = null;
        List<String> stringList = new ArrayList<>();
        try {
            lineIterator = FileUtils.lineIterator(new File(baseResources + fileName), "UTF-8");
            while (lineIterator.hasNext())
                stringList.add(lineIterator.nextLine());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (lineIterator != null){
                try {
                    lineIterator.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringList;
    }

    public static void writeFileForList(List<String> lineList, String writeFilePath){
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(baseResources + writeFilePath)));
            for (String line : lineList){
                bufferedOutputStream.write(line.getBytes("utf-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Properties loadProperties(String fileName){
        Properties properties = new Properties();
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(baseResources + fileName))){
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return properties;
        }
    }

    public static void main(String[] args) {
        String html = readFile("StaticHTML/KY视频列表文档源码.html");
        System.out.println(html);
    }
}
