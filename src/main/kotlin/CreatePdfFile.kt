import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream


fun createPdfFile(filePath: String, people: List<List<String>>) {

    val document = Document(PageSize.A4)
    PdfWriter.getInstance(document, FileOutputStream(filePath))

    document.open()
    val table = PdfPTable(people[0].size)
    table.widthPercentage = 100f

    val baseFont = BaseFont.createFont("src/main/resources/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
    val fontSize = 4f
    val font = com.itextpdf.text.Font(baseFont, fontSize)

    for (person in people) {
        for (cell in person) {
            table.addCell(Phrase(cell, font))
        }
    }

    document.add(table)
    document.close()
}
