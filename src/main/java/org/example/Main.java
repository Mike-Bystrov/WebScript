package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String url = "https://www.youtube.com/";
        String decodedContent = "";
        try {
            // �������� web-�������� � ������� Jsoup
            Document document = Jsoup.connect(url).header("Accept-Encoding", "UTF-8").get();

            // �������� ����� �� web-�������� � ������ ��������� ���������
            String pageContent = document.outerHtml();

            // �������������� ������ � Java-������ � �������������� ���������� ���������

            decodedContent = new String(pageContent.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }



        String textInWindows1251 = "��� ����� � ��������� Windows-1251"; // �������� �� ��� �����

        // �������������� �� Windows-1251 � UTF-8 ��������
        byte[] windows1251Bytes = decodedContent.getBytes(StandardCharsets.UTF_8);
        String textInUtf8 = new String(windows1251Bytes, Charset.forName("Windows-1251"));

        System.out.println("����� � win-1251: " + textInUtf8);
        PrintWriter wr1 = new PrintWriter("out1");
        wr1.println(textInUtf8);
        wr1.close();

        int l = '4';

    }
}