package stackjava.com.apachepoi.word.demo;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class DemoRead {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("demo-apache-apoi-word.docx");
			XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
			List<XWPFParagraph> paragraphList = document.getParagraphs();
			for (XWPFParagraph paragraph : paragraphList) {
				System.out.println(paragraph.getText());
			}
			System.out.println("==============================");
			System.out.println("Read file using XWPFWordExtractor ");
			XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
			System.out.println(wordExtractor.getText());
			wordExtractor.close();
			document.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
