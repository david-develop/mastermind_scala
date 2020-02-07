import scala.util.Random

class circle {
    val colors: List[String] = List("R", "Y", "G", "B", "C", "M")
    val random = new Random
    var color = colors(random.nextInt(colors.length))
    val form = "\u2B24   "
    def print_crl (color: String, form: String) : Unit = {
		if (color == "Y") {
			print(Console.YELLOW + form + Console.RESET)
		} else if (color == "R") {
			print(Console.RED + form + Console.RESET)
		} else if (color == "B") {
			print(Console.BLUE + form + Console.RESET)
		} else if (color == "G") {
			print(Console.GREEN + form + Console.RESET)
		} else if (color == "W") {
			print(Console.WHITE + form + Console.RESET)
		} else if (color == "M") {
			print(Console.MAGENTA + form + Console.RESET)
		}
    }
}

object Main {
    def main(args: Array[String]) {

		var chip_bot:Array[circle]=new Array[circle](4)
		var chip_player:Array[circle]=new Array[circle](4)

		// Set random pattern
		for (i <- 0 to 3) {
			chip_bot(i) = new circle()
	   		//chip_bot(i).print_crl(chip_bot(i).color, chip_bot(i).form)
		}
		// Welcome message
		val form = "\u2B24   "
		println("Welcome to mastermind of Stalion Team, BOG-Cohort-9")
		println("Please select 4 color for you chips\nType the corresponding letter UPPERCASE")
		println("Yellow      (Y) -> " + Console.YELLOW + form + Console.RESET)
		println("Red         (R) -> " + Console.RED + form + Console.RESET)
		println("Magenta     (M) -> " + Console.MAGENTA + form + Console.RESET)
		println("Blue        (B) -> " + Console.BLUE + form + Console.RESET)
		println("Green       (G) -> " + Console.GREEN + form + Console.RESET)
		println("White       (C) -> " + Console.WHITE + form + Console.RESET)
		println("\nYOU HAVE 10 OPORTUNITIES!\nGOOD LUCK!")

	   	println("\n_____________________________\n")

		for (i <- 0 to 3) {
			chip_player(i) = new circle()
			var msn_str = "Set color of chip " + i + ":  "
			chip_player(i).color = readLine(msn_str)
		}

		println("_____________________________\n")

		for (i <- 0 to 3) {
	   		chip_player(i).print_crl(chip_player(i).color, chip_player(i).form)
		}

		println()
	}
}