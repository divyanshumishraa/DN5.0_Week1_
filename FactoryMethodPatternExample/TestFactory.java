abstract class DocumentFactory {
    public abstract Document createDocument();
    
    public void newDocument() {
        Document doc = createDocument();
        doc.open();
        doc.close();
    }
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new wDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

public class TestFactory {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.newDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.newDocument();
    }
}