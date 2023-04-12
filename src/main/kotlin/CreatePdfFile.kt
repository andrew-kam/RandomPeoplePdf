import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream


class CreatePdfFile : CreateFile {

    override fun createFile(fileSettings: FileSettings, headerFile: List<String>,
                            dataGenerator: GenerateData, countLines: Int) {

        val document = Document(PageSize.A4)
        PdfWriter.getInstance(document, FileOutputStream(fileSettings.fileName))

        document.open()
        val table = PdfPTable(headerFile.size)
        table.widthPercentage = fileSettings.pageWidth

        val baseFont = BaseFont.createFont(fileSettings.pathFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        val font = com.itextpdf.text.Font(baseFont, fileSettings.fontSize)

        val listOfLines = mutableListOf<List<String>>()

        listOfLines.add(headerFile)
        repeat(countLines) {
            listOfLines.add(dataGenerator.generateData())
        }

        listOfLines.forEach { line ->
            line.forEach {
                table.addCell(Phrase(it, font))
            }
        }

        document.add(table)
        document.close()
        println("Файл создан. Путь: ${File(fileSettings.fileName).absolutePath}")
    }
}
