import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfHandler {
	
	String path;
	PDDocument document;
	PDPageTree tree;
	PDFTextStripper stripper;
	int numPages;
	
	PdfHandler(String path){
		this.path=path;
		try {
			document=PDDocument.load(new File(path));
			stripper=new PDFTextStripper();
		} catch (IOException e) {

		}
	}
	
	public String getStringFromPdf(int num) {
		getStripper().setStartPage(num);
		getStripper().setEndPage(num);
		
		String textFromPage=null;
		
		try {
			textFromPage=getStripper().getText(getDocument());
		} catch (IOException e) {

		}
		
		return textFromPage;
	}

	public PDDocument getDocument() {
		
		return document;
	}

	public PDPageTree getTree() {
		return getDocument().getPages();
	}

	public PDFTextStripper getStripper() {
		return stripper;
	}

	public int getNumPages() {
		return getTree().getCount();
	}
	
}
