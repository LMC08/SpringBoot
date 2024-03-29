package com.example.demo.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @ClassName: CreatePdfTest
 * @Description:
 * @Author liminchuan
 * @Date:Create： 2021/3/4 16:02
 */
public class CreatePdfTest {
    public static String getPdfPath(){
        System.out.println("===========start=============");
        String outPath = "C:/Users/lmc08/Desktop/pdfDemo-master/简历1.pdf";
        try {
            Document doc = createPdf(outPath);
            //生成  合同文件
            createFile(doc);
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
            outPath = null;
        }
        System.out.println("===========end=============");
        return  outPath;
    }

    /**
     * 创建一个pdf并打开
     * @param outpath  pdf路径
     */
    public static Document createPdf(String outpath) throws DocumentException, IOException {
        //页面大小
        //Rectangle rect = new Rectangle(PageSize.A4.rotate());//文档横方向
        Rectangle rect = new Rectangle(PageSize.A4);//文档竖方向
        //如果没有则创建
        File saveDir = new File(outpath);
        File dir = saveDir.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        Document doc = new Document(rect);
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(outpath));
        //PDF版本(默认1.4)
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);
        //页边空白
        doc.setMargins(40, 40, 40, 40);
        //打开文档
        doc.open();
        return doc;
    }

    public static void createFile(Document doc) throws DocumentException {
        doc.add(PdfFontUtils.getFont(1, "合作协议"));
        doc.add(PdfFontUtils.getFont(6, "甲方："));
        doc.add(PdfFontUtils.getFont(6, "乙方："));
        doc.add(PdfFontUtils.getFont(6, "时间："));
        doc.add(PdfFontUtils.getFont(6, "地点："));
        Paragraph text05 = PdfFontUtils.getFont(5, "《根据中华人民共和国合同法》的有关规定，经甲、乙双方友好协商，本着长期平等合作.....吧啦吧啦吧啦吧啦吧啦吧啦吧啦吧啦");
        doc.add(text05);

        //三、其他
        doc.add(PdfFontUtils.getFont(5, "1.双方根据国家法律规定建立合作关系，双方严格遵守和执行国家各项方针政策和有关法律、法规和条例规定。 "));
        doc.add(PdfFontUtils.getFont(5, "2.双方严格按照《中华人民共和国招标投标法》及相关规定实施合作。 "));
        doc.add(PdfFontUtils.getFont(5, "3.自定义 "));

        PdfPTable table = new PdfPTable(3);
        table.getDefaultCell().setBorder(1);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "甲方：（盖章）")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "乙方：（盖章）")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "法定代表人或负责人签章")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "法定代表人或负责人签章")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "地址：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "地址：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "开户银行：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "开户银行：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "邮编：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "邮编：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "授权代理人：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "项目经理：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "电话：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        cell.setBorder(Rectangle.NO_BORDER);
        cell = new PdfPCell(new Phrase(PdfFontUtils.getFont(5, "电话：")));
        cell.setColspan(1);
        //cell.setBorder(0);
        table.addCell(cell);
        doc.add(table);

    }
}