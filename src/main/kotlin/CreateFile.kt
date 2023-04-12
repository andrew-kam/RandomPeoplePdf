interface CreateFile {
    fun createFile(fileSettings: FileSettings, headerFile: List<String>,
                   dataGenerator: GenerateData, countLines: Int)
}
