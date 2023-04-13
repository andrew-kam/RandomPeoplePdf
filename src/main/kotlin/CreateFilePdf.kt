import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream


class CreateFilePdf : CreateFile {

    override fun createFile(fileSettings: FileSettings, dataGenerator: GenerateData, countLines: Int) {

        val document = Document(PageSize.A4)
        PdfWriter.getInstance(document, FileOutputStream(fileSettings.fileName))
        document.open()

        val table = PdfPTable(fileSettings.fileHeader.size)
        table.widthPercentage = fileSettings.pageWidth

        val baseFont = BaseFont.createFont(fileSettings.fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        val font = com.itextpdf.text.Font(baseFont, fileSettings.fontSize)

        fileSettings.fileHeader.forEach {
            table.addCell(Phrase(it, font))
        }

        repeat(countLines) {
            dataGenerator.generateData().forEach {
                table.addCell(Phrase(it, font))
            }
        }

        document.add(table)
        document.close()

        println("Файл создан. Путь: ${File(fileSettings.fileName).absolutePath}")
    }
}
