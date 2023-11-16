package net.shuaiwu.utils;

import info.monitorenter.cpdetector.io.*;
import java.io.*;
import java.nio.charset.Charset;

/**
 * java 文件流、内存流处理、编解码处理
 * 字节流
 *  输入流
 *  输出流
 * 字符流
 *  输入流
 *  输出流
 */
public class StreamUtil {
    /**
     * 探测器，探测流编码
     * @param inputStream 输入流
     * @return 编码字符串
     * @throws IOException
     */
    public static String getCharset(InputStream inputStream) throws IOException {
        CodepageDetectorProxy detectorProxy = CodepageDetectorProxy.getInstance();
        detectorProxy.add(new ParsingDetector(false));
        detectorProxy.add(JChardetFacade.getInstance());
        detectorProxy.add(ASCIIDetector.getInstance());
        detectorProxy.add(UnicodeDetector.getInstance());
        Charset charset = detectorProxy.detectCodepage(new BufferedInputStream(inputStream), 8);
        return charset.name();
    }

    public static String readFile(String fileAbsolutePath) throws IOException {
        File file = new File(fileAbsolutePath);
        if(file.exists()){
            try(FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fileInputStream, getCharset(new FileInputStream(file)));
                BufferedReader bufferedReader = new BufferedReader(isr)
            ){
                String line;
                StringBuffer sb = new StringBuffer();
                while((line = bufferedReader.readLine()) != null){
                    sb.append(line).append("\r\n");
                }
                line = sb.substring(0, sb.length()-2);
                System.out.println(line);
                return line;
            } catch (IOException e) {
                throw new IOException(e);
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String body = readFile("src/main/resources/KY视频列表地址.txt");
        System.out.println(body);
    }
}
