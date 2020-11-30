package com.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.util.SystemOutLogger;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.apache.poi.ss.usermodel.Workbook;
public class Main {
	public static void main(String[] args) throws IOException, Docx4JException {
		System.out.println("\n Wprowadz E dla Tlumaczenia listwy \nWprowadz W dla Tlumaczenia projektu \nWprowadz I dla tlumaczenia inwentury");
		 Scanner scan = new Scanner(System.in);
		 String choosing = scan.nextLine();
		 if(choosing.equals("W")) {
			 System.out.println("Wprowadz pelna sciezke do word");
			 String path = scan.nextLine();
			 Word.translateProjekt(path);
		 }
		 if(choosing.equals("E")) {
			 System.out.println("Wprowadz pelna sciezke do excela");
			 String path = scan.nextLine();
			 Excel.translateListwa(path);
		 }
		 if(choosing.equals("I")) {
			 System.out.println("Wprowadz pelna sciezke do excela");
			 String path = scan.nextLine();
			 Inwentura.traslateInwentura(path);
		 }
	}
}
