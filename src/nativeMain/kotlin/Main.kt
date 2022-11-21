private fun processTracks(lines: List<String>, linePattern: String): List<Track> {
    val tracks = mutableListOf<Track>()
    for ((index, line) in lines.withIndex()) {
        tracks.add(processTrack(line, linePattern, index))
    }
    return tracks.sortedBy { it.index }
}

private fun processTrack(line: String, pattern: String, lineIndex: Int): Track {
    val index = lineIndex

    return Track(index, line, "", TrackTime(0,0,0))
}

fun main(args: Array<String>) {
    val options = AppOptions(args)

    println("Input file: ${options.input}")
    println("Output file: ${options.input}")

    val lines = readLines(options.input)
    val tracks = processTracks(lines, options.pattern)
    for (track in tracks) {
        println("$track")
    }
}
