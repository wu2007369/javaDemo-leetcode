package javaTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
public class TestItextPdf {
    /**
     * @param args
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)  /*throws FileNotFoundException, DocumentException*/
    {

        splitPdf("/Users/wuzhiming/Downloads/刘云生.pdf",4);
//        createPdf();
    }

    private static void createPdf() throws FileNotFoundException,
            DocumentException{

        // TODO Auto-generated method stub
        Document document = new Document(PageSize.A4);
        PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream(
                "/Users/wuzhiming/Downloads/刘云生.pdf"));
        document.open();
        try {
            BaseFont bfChinese = BaseFont.createFont("STSong-Light",
                    "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font fontChinese = new Font(bfChinese, 13, Font.NORMAL);
            document.addHeader("itext", "liuyunsheng");
            for (int i = 0; i < 100; i++) {
                document.add(new Paragraph("刘云生", fontChinese));
                document.add(new Paragraph("青岛科技大学", fontChinese));
                document.add(new Paragraph("软件工程", fontChinese));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        document.close();
    }


    /**
     * 将filename文件切分成多个自定义页数大小的文件
     * @param filename 文件路径
     * @param splitSize  切分后的小文件的页数
     * @return 将filename文件划分成的子文件数目 >0则是成功
     */
    public static int splitPdf(String filename,int splitSize) {
        // String filename = "1904.08394.pdf";
        PdfReader reader = null;
        try {
            reader = new PdfReader(filename);
        } catch (IOException e) {
            return -1;
        }
        int numberOfPages = reader.getNumberOfPages();
        int numberOfNewFiles = 0, pageNumber = 1;
        while (pageNumber <= numberOfPages) {
            Document doc = new Document();
            String outputFilename = String.format(filename.substring(0, filename.length()-4) + "_%02d" + ".pdf", numberOfNewFiles);
            PdfWriter writer = null;
            try {
                writer = PdfWriter.getInstance(doc, new FileOutputStream(outputFilename));
            } catch (FileNotFoundException e) {
                return -2 - numberOfNewFiles * 10;
            } catch (DocumentException e) {
                return -3 - numberOfNewFiles * 10;
            }
            doc.open();
            PdfContentByte cb = writer.getDirectContent();
            // 这里判断加到了循环里不好，有优化空间
            for (int j = 1; pageNumber <= numberOfPages && j <= splitSize; ++j, pageNumber++) {
                doc.newPage();
                // 查看源码得知pageNumber是从1开始计数的
                cb.addTemplate(writer.getImportedPage(reader, pageNumber), 0, 0);
            }
            doc.close();
            numberOfNewFiles++;
            writer.close();
        }
        return numberOfNewFiles;
    }

}
