package stackjava.com.apachepoi.word.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WriteInto {
	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		XWPFDocument docx = new XWPFDocument(new FileInputStream("Test1.docx"));
		List<XWPFParagraph> paragraphList = docx.getParagraphs();

		XWPFDocument document = new XWPFDocument();
		FileOutputStream out = new FileOutputStream(new File("Test2.docx"));
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();

		run.setText("Hello");
		run.addCarriageReturn();

		for (XWPFParagraph p : paragraphList) {
			run.setText(p.getText());
			run.addCarriageReturn();
		}
		document.write(out);
		document.close();
		out.close();
		System.out.println("Test2.docx written successfully");
	}
}
