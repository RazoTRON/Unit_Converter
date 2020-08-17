package converter

fun main() {
    run()
}

fun run() {
    loop@ while (true) { println("Enter what you want to convert (or exit):")
        var line = readLine()!!.toLowerCase().replace("degrees ", "").replace("degree ", "").split(" ")
        when {
            line[0] == "exit" -> break@loop
            line[0].toDoubleOrNull() == null -> println("Parse error") 
        }
        Size.convert(line[0].toDouble(), line[line.size - 3], line[line.size - 1]) 
    }
}

enum class Size(val names: Array<String>, val value: Double, val type: String) {
    GRAM(arrayOf("g", "gram", "grams"), 1.0, "Weight"),
    KILOGRAM(arrayOf("kg", "kilogram", "kilograms"), 1000.0, "Weight"),
    MILIGRAM(arrayOf("mg", "milligram", "milligrams"), 0.001, "Weight"),
    POUND(arrayOf("lb", "pound", "pounds"), 453.592, "Weight"),
    OUNCE(arrayOf("oz", "ounce", "ounces"), 28.3495, "Weight"),
    METER(arrayOf("m", "meter", "meters"), 1.0, "Length"),
    KILOMETR(arrayOf("km", "kilometer", "kilometers"), 1000.0, "Length"),
    CENTIMETER(arrayOf("cm", "centimeter", "centimeters"), 0.01, "Length"),
    MILLIMETER(arrayOf("mm", "millimeter", "millimeters"), 0.001, "Length"),
    MILE(arrayOf("mi", "mile", "miles"), 1609.35, "Length"),
    YARD(arrayOf("yd", "yard", "yards"), 0.9144, "Length"),
    FOOT(arrayOf("ft", "foot", "feet"), 0.3048, "Length"),
    INCH(arrayOf("in", "inch", "inches"), 0.0254, "Length"),
    
    CELSIUS(arrayOf("dc", "degree Celsius", "degrees Celsius", "celsius", "c"), 0.0, "Temperature"),
    FAHRENHEIT(arrayOf("df", "degree Fahrenheit", "degrees Fahrenheit", "fahrenheit", "f"), 0.0, "Temperature"),
    KELVIN(arrayOf("k", "Kelvin", "Kelvins", "kelvin", "kelvins"), 0.0, "Temperature"),
    NULL(arrayOf("???", "???", "???"), 0.0, "NULL");
    
    companion object {
        fun convert(num: Double, from: String, to: String) {
            var fromEnum = Size.NULL
            var toEnum = Size.NULL
            for(enum in values()) { 
                if (enum.names.contains(from)) fromEnum = enum
                if (enum.names.contains(to)) toEnum = enum 
            }
            if (fromEnum == Size.NULL || toEnum == Size.NULL || fromEnum.type != toEnum.type) {
                println("Conversion from ${fromEnum.names[2]} to ${toEnum.names[2]} is impossible"); return }
            if (fromEnum.type != "Temperature" && num < 0) { 
                println("${fromEnum.type} shouldn't be negative."); return }
            val result = Size.result(num, fromEnum, toEnum)
            fun plural(num: Double, unit: Size): String = if (num == 1.0) unit.names[1] else unit.names[2]
            println("$num ${plural(num, fromEnum)} is $result ${plural(result, toEnum)}")
        }
    
        fun result(num: Double, from: Size, to: Size): Double {
            fun size(num: Double, from: Size, to: Size): Double { return num * from.value / to.value }
            fun temp(num: Double, from: Size, to: Size): Double {
                val celsius = when (from) {
                    CELSIUS -> num
                    FAHRENHEIT -> (num - 32) * 5 / 9
                    KELVIN -> num - 273.15
                    else -> 0.0
                }
                val result = when (to) {
                    CELSIUS -> celsius
                    FAHRENHEIT -> celsius * 9 / 5 + 32
                    KELVIN -> celsius + 273.15
                    else -> 0.0
                }
                return result
            }
            return when (from.type) {
                "Weight" -> size(num, from, to)
                "Length" -> size(num, from, to)
                "Temperature" -> temp(num, from, to)
                else -> 0.0
            }
        }
    }
}