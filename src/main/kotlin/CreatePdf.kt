import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.Phrase
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream


class CreatePdf {

    fun createPdf(filePath: String, people: List<Person>) {

        val document = Document(PageSize.A4)
        PdfWriter.getInstance(document, FileOutputStream(filePath))

        document.open()
        val table = PdfPTable(tableFields.size)
        table.widthPercentage = 100f

        tableFields.forEach { field ->
            table.addCell(createCell(field))
        }

        people.forEach { person ->
            table.addCell(createCell(person.firstName))
            table.addCell(createCell(person.lastName))
            table.addCell(createCell(person.middleName))
            table.addCell(createCell(person.age))
            table.addCell(createCell(person.gender))
            table.addCell(createCell(person.birthDate))
            table.addCell(createCell(person.birthPlace))
            table.addCell(createCell(person.postalCode))
            table.addCell(createCell(person.country))
            table.addCell(createCell(person.region))
            table.addCell(createCell(person.city))
            table.addCell(createCell(person.street))
            table.addCell(createCell(person.houseNumber))
            table.addCell(createCell(person.apartmentNumber))
        }

        document.add(table)
        document.close()
    }

    private fun createCell(text: String): Phrase {
        val baseFont = BaseFont.createFont("src/main/resources/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        val font = com.itextpdf.text.Font(baseFont, 4f)
        return Phrase(text, font)
    }
}
