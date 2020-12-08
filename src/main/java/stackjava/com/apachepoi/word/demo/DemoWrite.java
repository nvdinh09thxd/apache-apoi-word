package stackjava.com.apachepoi.word.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class DemoWrite {
	public static void main(String[] args) throws IOException {
		// Create Blank document
		XWPFDocument document = new XWPFDocument();

		// Create new Paragraph
		XWPFParagraph paragraph1 = document.createParagraph();
		XWPFRun run = paragraph1.createRun();
		run.setText("Paragraph 1: stackjava.com");
		
		XWPFParagraph paragraph2 = document.createParagraph();
		run = paragraph2.createRun();
		run.setText("Paragraph 2: demo read/write file MS-Word");
		
		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(new File("demo-apache-apoi-word.docx"));
		document.write(out);
		out.close();
		document.close();
		System.out.println("successully");
	}
}
