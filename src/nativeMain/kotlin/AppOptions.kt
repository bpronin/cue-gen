import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default
import kotlinx.cli.required

class AppOptions(args: Array<String>) {
    private val parser = ArgParser("CUE generator")

    val input by parser.option(
        ArgType.String, shortName = "i", description = "Input file"
    ).required()

    val pattern by parser.option(
        ArgType.String, shortName = "p", description = "Line pattern. A string of track fields separated by custom dividers." +
                "Acceptable fields are: " +
                "%track% - track number; " +
                "%title% - track title; " +
                "%performer% - track title; " +
                "%time% - track time from start; " +
                "%duration% - track duration"
    ).default("%title% %duration%")

    init {
        parser.parse(args)
    }
}