import kotlinx.cinterop.*
import platform.posix.FILE
import platform.posix.fclose
import platform.posix.fgets
import platform.posix.fopen

private fun readLine(
    buffer: CArrayPointer<ByteVar>,
    bufferLength: Int,
    file: CPointer<FILE>
) = fgets(buffer, bufferLength, file)?.toKString()?.trim()

fun readLines(path: String): List<String> {
    val file = fopen(path, "r") ?: throw IllegalArgumentException("Cannot open file $path")
    val list = mutableListOf<String>()
    try {
        memScoped {
            val bufferLength = 64 * 1024
            val buffer = allocArray<ByteVar>(bufferLength)

            var line = readLine(buffer, bufferLength, file)
            while (line != null) {
                list.add(line)
                line = readLine(buffer, bufferLength, file)
            }
        }
    } finally {
        fclose(file)
    }

    return list
}
