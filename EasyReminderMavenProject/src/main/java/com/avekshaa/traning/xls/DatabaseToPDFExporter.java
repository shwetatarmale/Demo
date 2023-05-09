package com.avekshaa.traning.xls;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@WebServlet("/DatabaseToPDFExporter")
public class DatabaseToPDFExporter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false", "root", "shweta@12345");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM sampledata");

            // Create a new PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Create a table with three columns
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            // Set column widths
            float[] columnWidths = { 1f, 2f, 2f };
            table.setWidths(columnWidths);

         // Add table headers
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
           PdfPCell headerCell1 = new PdfPCell(new com.itextpdf.text .Paragraph("ID", headerFont));
            headerCell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
          //  headerCell2.setPadding(5f);
            PdfPCell headerCell2 = new PdfPCell(new Paragraph("Description", headerFont));
            headerCell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
            PdfPCell headerCell3 = new PdfPCell(new Paragraph("ErrorCode", headerFont));
            headerCell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(headerCell1);
            table.addCell(headerCell2);
            table.addCell(headerCell3);
            // Fetch data from the database and add to the table
            Font dataFont = new Font(Font.FontFamily.HELVETICA, 10);
            while (rs.next()) {
                PdfPCell cell1 = new PdfPCell(new Paragraph(rs.getString("idtxn"), dataFont));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                PdfPCell cell2 = new PdfPCell(new Paragraph(rs.getString("description"), dataFont));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
                PdfPCell cell3 = new PdfPCell(new Paragraph(rs.getString("errorcode"), dataFont));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
            }
            // Add the table to the document
            document.add(table);

            document.close();
            con.close();

            // Set response headers
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=data.pdf");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle errors
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
    }
