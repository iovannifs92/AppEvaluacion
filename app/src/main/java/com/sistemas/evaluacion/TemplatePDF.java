package com.sistemas.evaluacion;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import static android.provider.Telephony.Mms.Part.TEXT;
import static java.lang.Float.max;
import static java.lang.Float.min;

public class TemplatePDF {
    private Context context;
    public File pdfFile;
    private Document document;
    private PdfWriter pdfWriter;
    private Paragraph paragraph;
    private ColumnText ct;
    private Rectangle pageSize, rectangle;
    private static final float factor = (float)1.8;
    private static final float fontSize = 6;
    private Font fTitle=new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
    private Font fSubTitle=new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private Font fText=new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    private Font fFormatText=new Font(Font.FontFamily.TIMES_ROMAN, fontSize, Font.BOLD);
    private Font fHighText=new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);

    private static final float eps = (float)1e-3;
    private static final float tol = factor*fontSize - eps;//Defined as cell height
    private static final float pageMargin = 38;
    private static final float margin = factor*fontSize;
    private static final float separation = 0;

    public TemplatePDF(Context context) {
        this.context = context;
    }

    public void openDocument(){
        createFile();
        try{
            document=new Document(PageSize.LETTER);
            pdfWriter=PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();

            ct = new ColumnText(pdfWriter.getDirectContent());
            pageSize = document.getPageSize();
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }
    }

    private void createFile(){
        File folder=new File(Environment.getExternalStorageDirectory().toString(),"PDF");

        if(!folder.exists())
            folder.mkdir();
        pdfFile=new File(folder, "TemplatePDF.pdf");
        pdfFile.getAbsolutePath();
    }

    public void closeDocument(){
        document.close();
    }

    public void addMetaData(String title, String subject, String author){
        document.addTitle(title);
        document.addSubject(subject);
        document.addAuthor(author);
    }

    public void addTitles(String title, String subTitle, String date){
        try{
            paragraph=new Paragraph();
            addChild(new Paragraph(title, fTitle));
            addChild(new Paragraph(subTitle, fSubTitle));
            addChild(new Paragraph("Generado  "+date, fHighText));
            paragraph.setSpacingBefore(50);
            paragraph.setSpacingAfter(10);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }
    }

    //region Add titles when using ColumnText to draw the table
    public void addColumnTextTitles(String title, String subTitle, String date){
        try{
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            Chunk chunk;
            chunk = new Chunk(title, fTitle);
            paragraph.add(chunk);
            chunk.setGenericTag(title);
            chunk = new Chunk(subTitle, fSubTitle);
            paragraph.add(chunk);
            chunk.setGenericTag(subTitle);
            chunk = new Chunk(date, fHighText);
            paragraph.add(chunk);
            ct.addElement(paragraph);
            Rectangle rect = new Rectangle(pageSize.getLeft() + pageMargin,
                            pageSize.getBottom() + pageMargin,
                            pageSize.getRight() - pageMargin,
                            pageSize.getTop() - pageSize.getHeight()*11/100 - margin);
            ct.setSimpleColumn(rect);
            ct.go();
            ct.setYLine(ct.getYLine() - margin);
        }catch (Exception e){
            Log.e("write column text titles", e.toString());
        }
    }
    //endregion

    private void addChild(Paragraph childParagraph){
        childParagraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(childParagraph);
    }

    public void addParagraph(String text){
        try{
            paragraph=new Paragraph(text, fText);
            paragraph.setSpacingAfter(5);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }
    }

    public void addColumnTextParagraph(String text){
        try{
            Paragraph paragraph = new Paragraph();
            paragraph.setSpacingAfter(5);
            paragraph.setSpacingBefore(5);
            Chunk chunk;
            chunk = new Chunk(text, fText);
            paragraph.add(chunk);
            chunk.setGenericTag(text);
            ct.addElement(paragraph);
            if(ct.getYLine() > 0) {
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getRight() - pageMargin,
                        Math.min(ct.getYLine(), pageSize.getTop() - pageMargin));
            }
            else {
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getRight() - pageMargin,
                        pageSize.getTop() - pageMargin);
            }
            if(rectangle.getHeight() <= 0){
                document.newPage();
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getRight() - pageMargin,
                        pageSize.getTop() - pageMargin);
            }
            ct.setSimpleColumn(rectangle);
            ct.go();
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }
    }


    public void addParagraph(String text, BaseColor col){
        try{
            Font fColor = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, col);
            paragraph=new Paragraph(text, fColor);
            paragraph.setSpacingAfter(5);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }
    }

    public void createTable(String [] header, ArrayList<String[]> imputado){
        try{
            paragraph=new Paragraph();
            paragraph.setFont(fText);
            PdfPTable pdfPTable=new PdfPTable(header.length);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(10);
            PdfPCell pdfPCell;
            int indexC=0;
            while (indexC<header.length){
                pdfPCell=new PdfPCell(new Phrase(header[indexC++], fSubTitle));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.GRAY);
                pdfPTable.addCell(pdfPCell);
            }

            for (int indexR=0; indexR<imputado.size();indexR++){
                String[] row=imputado.get(indexR);
                for (indexC=0; indexC<header.length;indexC++){
                    pdfPCell=new PdfPCell(new Phrase(row [indexC]));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setFixedHeight(40);
                    if (indexC==2){
                        switch (row[indexC]){
                            case "Bajo":
                                pdfPCell.setBackgroundColor(BaseColor.GREEN);
                                break;
                            case "Moderado":
                                pdfPCell.setBackgroundColor(BaseColor.YELLOW);
                                break;
                            case "Alto":
                                pdfPCell.setBackgroundColor(BaseColor.RED);
                                break;
                        }
                    }
                    pdfPTable.addCell(pdfPCell);
                }
            }

            paragraph.add(pdfPTable);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }

    }

    public void createTable(ArrayList<PdfPCell> imputado, int cols, float[] widths){
        try{
            paragraph=new Paragraph();
            paragraph.setFont(fFormatText);
            PdfPTable pdfPTable=new PdfPTable(cols);
            pdfPTable.setHorizontalAlignment(Element.ALIGN_LEFT);
            pdfPTable.setWidths(widths);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(10);
            pdfPTable.setSplitLate(false);

            for (int index=0; index<imputado.size();index++){
                PdfPCell pdfPCell;
                pdfPCell = imputado.get(index);
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

                //region Set the table font
                PdfPCell newPdfPCell = new PdfPCell(new Phrase(pdfPCell.getPhrase().getContent(), fFormatText));
                newPdfPCell.setBackgroundColor(pdfPCell.getBackgroundColor());
                newPdfPCell.setRowspan(pdfPCell.getRowspan());
                newPdfPCell.setColspan(pdfPCell.getColspan());
                newPdfPCell.setRotation(pdfPCell.getRotation());
                newPdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                pdfPTable.addCell(newPdfPCell);
                //endregion
            }

            paragraph.add(pdfPTable);

            //region Simulate to get the tables heights
            ct.addElement(paragraph);
            float oldYLine = ct.getYLine();
            if(ct.getYLine() > 0) {
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getLeft() + pageSize.getWidth()/2,
                        Math.min(ct.getYLine(), pageSize.getTop() - pageMargin));
            }
            else{
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getLeft() + pageSize.getWidth()/2,
                        pageSize.getTop() - pageMargin);
            }

            boolean fits = true;
            int c = 0;
            int status = ColumnText.START_COLUMN;
            while (ColumnText.hasMoreText(status)) {
                if(c == 2){
                    fits = false;
                    rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                            pageSize.getBottom() + pageMargin,
                            pageSize.getLeft() + pageSize.getWidth()/2,
                            1000000);
                }
                ct.setSimpleColumn(rectangle);
                status = ct.go(true);
                c++;
            }
            //endregion
            float h = pdfPTable.getTotalHeight();

            if(fits) {
                ct.setYLine(oldYLine);
            }
            else{
                document.newPage();//Keep table together
                ct.setYLine(0);
            }

            //region Simulate where to split the columns
            while(true) {
                if(fits) {
                    ct.setYLine(oldYLine);
                }
                else{
                    ct.setYLine(0);
                }
                ct.addElement(paragraph);
                if (ct.getYLine() > 0) {
                    rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                            Math.max(ct.getYLine() - h / 2 - tol, pageMargin),
                            pageSize.getLeft() + pageSize.getWidth() / 2,
                            Math.min(ct.getYLine(), pageSize.getTop() - pageMargin));
                } else {
                    rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                            Math.max(pageSize.getTop() - pageMargin - h / 2 - tol, pageMargin),
                            pageSize.getLeft() + pageSize.getWidth() / 2,
                            pageSize.getTop() - pageMargin);
                }
                c = 0;
                status = ColumnText.START_COLUMN;
                while (ColumnText.hasMoreText(status)) {
                    //Rectangle left, right, lower and upper coordinates
                    float lx = 0;
                    float rx = 0;
                    float ly = 0;
                    float uy = 0;

                    float prevYLine = ct.getYLine();

                    if (c == 3) {
                        break;
                    }

                    ct.setSimpleColumn(rectangle);
                    status = ct.go(true);
                    c++;
                    if (c % 2 == 0) {
                        lx = pageSize.getLeft() + pageMargin;
                        rx = pageSize.getLeft() + pageSize.getWidth() / 2;
                    } else if (c % 2 == 1) {
                        lx = pageSize.getLeft() + pageSize.getWidth() / 2 + separation;
                        rx = pageSize.getRight() - pageMargin;
                    }

                    if (c % 2 == 1) {
                        ly = rectangle.getBottom();
                        uy = rectangle.getTop();
                    } else if (c % 2 == 0) {
                        ct.setYLine(Math.min(ct.getYLine(), prevYLine) - margin);

                        ly = Math.max(pageSize.getTop() - h / 2 - tol, pageMargin);
                        uy = pageSize.getTop() - pageMargin;
                    }
                    rectangle = new Rectangle(lx, ly, rx, uy);
                }
                if(c == 3) {
                    break;
                }
                h -= 9;
            }
            while(true) {
                if(fits) {
                    ct.setYLine(oldYLine);
                }
                else{
                    ct.setYLine(0);
                }
                ct.addElement(paragraph);
                if (ct.getYLine() > 0) {
                    rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                            Math.max(ct.getYLine() - h / 2 - tol, pageMargin),
                            pageSize.getLeft() + pageSize.getWidth() / 2,
                            Math.min(ct.getYLine(), pageSize.getTop() - pageMargin));
                } else {
                    rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                            Math.max(pageSize.getTop() - pageMargin - h / 2 - tol, pageMargin),
                            pageSize.getLeft() + pageSize.getWidth() / 2,
                            pageSize.getTop() - pageMargin);
                }
                c = 0;
                status = ColumnText.START_COLUMN;
                while (ColumnText.hasMoreText(status)) {
                    //Rectangle left, right, lower and upper coordinates
                    float lx = 0;
                    float rx = 0;
                    float ly = 0;
                    float uy = 0;

                    float prevYLine = ct.getYLine();

                    if (c == 3) {
                        break;
                    }

                    ct.setSimpleColumn(rectangle);
                    status = ct.go(true);
                    c++;
                    if (c % 2 == 0) {
                        lx = pageSize.getLeft() + pageMargin;
                        rx = pageSize.getLeft() + pageSize.getWidth() / 2;
                    } else if (c % 2 == 1) {
                        lx = pageSize.getLeft() + pageSize.getWidth() / 2 + separation;
                        rx = pageSize.getRight() - pageMargin;
                    }

                    if (c % 2 == 1) {
                        ly = rectangle.getBottom();
                        uy = rectangle.getTop();
                    } else if (c % 2 == 0) {
                        ct.setYLine(Math.min(ct.getYLine(), prevYLine) - margin);

                        ly = Math.max(pageSize.getTop() - h / 2 - tol, pageMargin);
                        uy = pageSize.getTop() - pageMargin;
                    }
                    rectangle = new Rectangle(lx, ly, rx, uy);
                }
                if(c <= 2) {
                  break;
                }
                h += 9;
            }
            //endregion

            if(fits) {
                ct.setYLine(oldYLine);
            }
            else{
                ct.setYLine(0);
            }

            ct.addElement(paragraph);
            if(ct.getYLine() > 0) {
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        Math.max(ct.getYLine() - h/2 - tol, pageMargin),
                        pageSize.getLeft() + pageSize.getWidth()/2,
                        Math.min(ct.getYLine(), pageSize.getTop() - pageMargin));
            }
            else{
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        Math.max(pageSize.getTop() - pageMargin - h/2 - tol, pageMargin),
                        pageSize.getLeft() + pageSize.getWidth()/2,
                        pageSize.getTop() - pageMargin);
            }
            c = 0;
            status = ColumnText.START_COLUMN;
            while (ColumnText.hasMoreText(status)) {
                //Rectangle left, right, lower and upper coordinates
                float lx = 0;
                float rx = 0;
                float ly = 0;
                float uy = 0;

                float prevYLine = ct.getYLine();

                //Lines never used, a table is always fitted in a single page
                /*if(c == 2) {
                    document.newPage();
                    ct.setYLine(0);
                    oldYLine = pageSize.getTop() - pageMargin;
                }*/
                if(c == 2){
                    break;
                }

                ct.setSimpleColumn(rectangle);
                status = ct.go();
                c++;
                if (c%2 == 0) {
                    lx = pageSize.getLeft() + pageMargin;
                    rx = pageSize.getLeft() + pageSize.getWidth()/2;
                }
                else if(c%2 == 1){
                    lx = pageSize.getLeft() + pageSize.getWidth()/2 + separation;
                    rx = pageSize.getRight() - pageMargin;
                }

                if(c%2 == 1) {
                    ly = rectangle.getBottom();
                    uy = rectangle.getTop();
                }
                else if (c%2 == 0){
                    h -= 2*oldYLine - ct.getYLine() - prevYLine;//Line never used, a table is always fitted in a single page
                    ct.setYLine(Math.min(ct.getYLine(), prevYLine) - margin);

                    ly = Math.max(pageSize.getTop() - h/2 - tol, pageMargin);
                    uy = pageSize.getTop() - pageMargin;
                }
                rectangle = new Rectangle(lx, ly, rx, uy);
            }
            if(c == 1){
                ct.setYLine(ct.getYLine() - margin);
            }
        }catch (Exception e){
            Log.e("openDocument", e.toString());
        }

    }

    public void addImgName () {
        try{
            String r=(Environment.getExternalStorageDirectory().toString()+ File.separator +"PDF" + File.separator + "membrete.png");
            Image image = Image.getInstance(r);//"/storage/emulated/Images" + File.separator + imageName);
            image.scaleAbsolute(PageSize.LETTER);
            image.setAbsolutePosition(0,0);
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
        }catch (Exception e){
            Log.e("addImgName ", e.toString());
        }

    }

    public void addImgQR () {
        try{
            String r=(Environment.getExternalStorageDirectory().toString()+ File.separator +"PDF" + File.separator + "codigo.png");
            Image image = Image.getInstance(r);//"/storage/emulated/Images" + File.separator + imageName);
            image.scaleAbsolute(100, 100);
            //image.setAbsolutePosition(0,0);
            image.setAlignment(Element.ALIGN_BOTTOM);
            document.add(image);
        }catch (Exception e){
            Log.e("addImgName ", e.toString());
        }

    }

    public void addColumnTextImgQR () {
        try{
            String r=(Environment.getExternalStorageDirectory().toString()+ File.separator +"PDF" + File.separator + "codigo.png");
            Image image = Image.getInstance(r);//"/storage/emulated/Images" + File.separator + imageName);
            image.scaleAbsolute(100, 100);
            //image.setAbsolutePosition(0,0);
            image.setAlignment(Element.ALIGN_BOTTOM);
            image.setAlignment(Element.ALIGN_RIGHT);
            ct.addElement(image);
            if(ct.getYLine() > 0) {
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getRight() - pageMargin,
                        Math.min(ct.getYLine(), pageSize.getTop() - pageMargin));
            }
            else {
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getRight() - pageMargin,
                        pageSize.getTop() - pageMargin);
            }
            if(rectangle.getHeight() <= 100){
                document.newPage();
                rectangle = new Rectangle(pageSize.getLeft() + pageMargin,
                        pageSize.getBottom() + pageMargin,
                        pageSize.getRight() - pageMargin,
                        pageSize.getTop() - pageMargin);
            }
            ct.setSimpleColumn(rectangle);
            ct.go();
        }catch (Exception e){
            Log.e("addImgName ", e.toString());
        }

    }

    /*public void viewPDF(){
        Intent intent=new Intent(context, ViewPDFActivity.class);
        intent.putExtra("path", pdfFile.getAbsolutePath());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }*/

    public void appViewPDF(Activity activity){
        if(pdfFile.exists()){
            Uri pdfPath;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                pdfPath = FileProvider.getUriForFile(activity.getApplicationContext(), "com.sistemas.evaluacion", pdfFile);
            } else {
                pdfPath = Uri.fromFile(pdfFile);
            }
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(pdfPath, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pdfIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            try{
                activity.startActivity(pdfIntent);
            }catch(ActivityNotFoundException e){
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.adobe.reader")));
                Toast.makeText(activity.getApplicationContext(), "No tienes aplicación para visualizar el PDF", Toast.LENGTH_SHORT).show();
            }

            /*Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            try{
                activity.startActivity(intent);
            }catch (ActivityNotFoundException e){
                activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.adobe.reader")));
                Toast.makeText(activity.getApplicationContext(), "No cuentas con una aplicación para ver PDF", Toast.LENGTH_LONG).show();
            }*/
        }
        else{
            Toast.makeText(activity.getApplicationContext(), "El archivo no se encontro", Toast.LENGTH_LONG).show();
        }
    }
}
