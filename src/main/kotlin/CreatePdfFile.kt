import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.File
import java.io.FileOutputStream


class CreatePdfFile : CreateFile {

    override fun createFile(countLines: Int) {

        val document = Document(PageSize.A4)
        PdfWriter.getInstance(document, FileOutputStream(FILE_NAME_PDF))

        document.open()
        val table = PdfPTable(TABLE_FIELD_NAMES.size)
        table.widthPercentage = PAGE_WIDTH

        val baseFont = BaseFont.createFont(PATH_FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        val font = com.itextpdf.text.Font(baseFont, FONT_SIZE)

        val dataGenerator: GenerateData = GenerateDataPerson()
        val listOfListsData = mutableListOf<List<String>>()

        listOfListsData.add(TABLE_FIELD_NAMES)
        repeat(countLines) {
            listOfListsData.add(dataGenerator.generateData())
        }

        for (line in listOfListsData) {
            for (cell in line) {
                table.addCell(Phrase(cell, font))
            }
        }

        document.add(table)
        document.close()
        println("Файл создан. Путь: ${File(FILE_NAME_PDF).absolutePath}")
    }
}
